package gaga.elmahdi.tp3mvc.repository;

import gaga.elmahdi.tp3mvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNomContains(String keyword, Pageable pageable);

    @Query("select patient from Patient patient where patient.nom like :x")
    Page<Patient> rechercher(@Param("x") String keyword, Pageable pageable);
}
