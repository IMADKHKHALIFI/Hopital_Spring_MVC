package net.imad.hopital_spring_mvc.security.repo;

import net.imad.hopital_spring_mvc.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRole(String role);


}
