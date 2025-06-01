package net.imad.hopital_spring_mvc.security.service;
import org.springframework.security.core.userdetails.UserDetailsService;
import net.imad.hopital_spring_mvc.security.entities.AppRole;
import net.imad.hopital_spring_mvc.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String username, String password, String email, String confirmPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);
    AppUser loadUserByUsername(String username); // ❌ à retirer si tu implémentes UserDetailsService
    AppRole loadRoleByName(String role);         // ✅ celle-ci est OK
}