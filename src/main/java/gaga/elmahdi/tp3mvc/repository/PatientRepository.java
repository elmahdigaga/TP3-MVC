package gaga.elmahdi.tp3mvc.repository;

import gaga.elmahdi.tp3mvc.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
