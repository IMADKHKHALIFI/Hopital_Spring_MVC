package net.imad.hopital_spring_mvc.security.service;

import lombok.AllArgsConstructor;
import net.imad.hopital_spring_mvc.security.entities.AppRole;
import net.imad.hopital_spring_mvc.security.entities.AppUser;
import net.imad.hopital_spring_mvc.security.repo.AppRoleRepository;
import net.imad.hopital_spring_mvc.security.repo.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.stream.Collectors;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.stream.Collectors;

import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {

    private final AppRoleRepository appRoleRepository;
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword) {
        AppUser appUser = appUserRepository.findByUserName(username);
        if (appUser != null) {
            return appUser; // ✔ return au lieu de throw
        }
        if (!password.equals(confirmPassword)) throw new RuntimeException("Passwords do not match");

        appUser = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .userName(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();

        return appUserRepository.save(appUser); // ✅ Utilise appUserRepository ici
    }


    @Override
    public AppRole addNewRole(String role) {
        AppRole existingRole = appRoleRepository.findByRole(role);
        if (existingRole != null) return existingRole;

        AppRole appRole = AppRole.builder()
                .role(role)
                .build();

        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUserName(username);
        if (appUser == null) throw new RuntimeException("User not found");

        AppRole appRole = appRoleRepository.findByRole(role);
        if (appRole == null) throw new RuntimeException("Role not found");

        // Si le rôle est déjà attribué, on ne refait rien
        if (!appUser.getRoles().contains(appRole)) {
            appUser.getRoles().add(appRole);
            appUserRepository.save(appUser); // ✅ important !
        }
    }


    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUserName(username);
        AppRole appRole = appRoleRepository.findByRole(role);
        if (appRole == null) throw new RuntimeException("Role not found");

        appUser.getRoles().remove(appRole);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByUserName(username);
        if (user == null) throw new UsernameNotFoundException("Utilisateur non trouvé: " + username);

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                        .collect(Collectors.toList())
        );
    }




    @Override
    public AppRole loadRoleByName(String role) {
        return appRoleRepository.findByRole(role);
    }

}

