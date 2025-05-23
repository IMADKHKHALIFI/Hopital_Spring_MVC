package net.imad.hopital_spring_mvc;

import lombok.Data;
import net.imad.hopital_spring_mvc.Repository.PatientRepository;
import net.imad.hopital_spring_mvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}
