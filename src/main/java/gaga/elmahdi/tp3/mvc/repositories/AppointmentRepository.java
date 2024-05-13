package gaga.elmahdi.tp3.mvc.repositories;

import gaga.elmahdi.tp3.mvc.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
}
