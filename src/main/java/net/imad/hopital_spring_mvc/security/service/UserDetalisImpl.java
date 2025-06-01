package net.imad.hopital_spring_mvc.security.service;

import lombok.AllArgsConstructor;
import net.imad.hopital_spring_mvc.security.entities.AppRole;
import net.imad.hopital_spring_mvc.security.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.catalina.realm.UserDatabaseRealm.getRoles;


@Service
@AllArgsConstructor
public class UserDetalisImpl implements UserDetailsService {
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = accountService.loadUserByUsername(username);
        if (appUser == null) throw new UsernameNotFoundException(String.format("User %s not found", username));
        String[] roles =  appUser.getRoles().stream().map(u -> u.getRole()).toArray(String[]::new );
        UserDetails userDetails = User
                .withUsername(appUser.getUserName())
                .password(appUser.getPassword())
                .roles(roles).build();
        return null;
    }
}
