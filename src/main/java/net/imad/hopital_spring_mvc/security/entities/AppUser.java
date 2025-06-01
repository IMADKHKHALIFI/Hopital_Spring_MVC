package net.imad.hopital_spring_mvc.security.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    private String  userId;
    @Column(unique=true)   // Indique que le champ nom d'utilisateur est unique !!! matnasch
    private String  userName;
    private String  password;
    private String  email;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles;
}
