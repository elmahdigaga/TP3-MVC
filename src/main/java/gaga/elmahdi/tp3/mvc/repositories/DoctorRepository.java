package gaga.elmahdi.tp3.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import gaga.elmahdi.tp3.mvc.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
}
