package gaga.elmahdi.tp3.mvc.repositories;

import gaga.elmahdi.tp3.mvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientRepository extends JpaRepository<Patient, Long>{
    Page<Patient> findByNameContains(String name, Pageable pageableu);
}
