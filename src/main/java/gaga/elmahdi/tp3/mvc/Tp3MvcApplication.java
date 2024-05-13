package gaga.elmahdi.tp3.mvc;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@SpringBootApplication
public class Tp3MvcApplication implements CommandLineRunner{

//    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(Tp3MvcApplication.class, args);
        System.out.println("The application is running...");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
//        patientRepository.save(new Patient(null, "Imane Bahyaoui",230,true , null));
//        patientRepository.save(new Patient(null, "Mohammed Mouddir",554,true , null));
//        patientRepository.save(new Patient(null, "Yassine Bahiyaoui",930,true , null));
//        patientRepository.save(new Patient(null,"Hmaza Negadi", 230,true , null));
    }
}
