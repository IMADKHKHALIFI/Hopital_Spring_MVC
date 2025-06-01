package net.imad.hopital_spring_mvc.security.repo;

import net.imad.hopital_spring_mvc.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String userName);
}
