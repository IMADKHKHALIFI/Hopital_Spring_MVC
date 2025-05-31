package net.imad.hopital_spring_mvc;

import lombok.Data;
import net.imad.hopital_spring_mvc.Repository.PatientRepository;
import net.imad.hopital_spring_mvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;

@SpringBootApplication
public class HopitalSpringMvcApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HopitalSpringMvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //En utilisant constructeur sans paramaitre
        Patient patient1 = new Patient();
        patient1.setId(null);
        patient1.setNom("Mohamed");
        patient1.setEstMalade(true);
        patient1.setDateNaissance(new Date());
        patient1.setScore(123);
        patientRepository.save(patient1);

        //En utilisant constructeur avec paramaitre
        Patient patient2 = new Patient(null, "IMAD", new Date(), false, 110);
        patientRepository.save(patient2);
        // En utlise Builder
        Patient patient3 = Patient.builder()
                .nom("Hamza")
                .dateNaissance(new Date())
                .estMalade(true)
                .score(122)
                .build();
        patientRepository.save(patient3);

        patientRepository.save(new Patient(null,"Anas",new Date(),false,155));



    }


    @Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager ) {
        PasswordEncoder passwordEncoder = passwordEncoder();
        return args -> {
            UserDetails u1 = jdbcUserDetailsManager.loadUserByUsername("user11");
            if(u1 == null )
                jdbcUserDetailsManager
                    .createUser(User.withUsername("user11")
                    .password(passwordEncoder.encode("1234"))
                    .roles("USER")
                    .build());
            UserDetails u2 = jdbcUserDetailsManager.loadUserByUsername("user21");
            if(u2 == null )
                jdbcUserDetailsManager
                    .createUser(User.withUsername("user21")
                            .password(passwordEncoder.encode("1234"))
                            .roles("USER")
                            .build());
            UserDetails u3 = jdbcUserDetailsManager.loadUserByUsername("admin1");
            if(u3== null )
                jdbcUserDetailsManager
                    .createUser(User.withUsername("admin1")
                            .password(passwordEncoder.encode("1234"))
                            .roles("USER","ADMIN")
                            .build());
        };
    }



    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
