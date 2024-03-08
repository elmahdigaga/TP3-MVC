package gaga.elmahdi.tp3mvc;

import gaga.elmahdi.tp3mvc.entities.Patient;
import gaga.elmahdi.tp3mvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Tp3MvcApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp3MvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Patient patient1 = new Patient();
		patient1.setId(null);
		patient1.setNom("Mahdi");
		patient1.setDateNaissance(new Date());
		patient1.setMalade(false);
		patient1.setScore(999);

		Patient patient2 = new Patient();
		patient2.setId(null);
		patient2.setNom("Issam");
		patient2.setDateNaissance(new Date());
		patient2.setMalade(true);
		patient2.setScore(120);

		Patient patient3 = new Patient();
		patient3.setId(null);
		patient3.setNom("Abdelhadi");
		patient3.setDateNaissance(new Date());
		patient3.setMalade(true);
		patient3.setScore(345);

		patientRepository.save(patient1);
		patientRepository.save(patient2);
		patientRepository.save(patient3);
	}
}
