package gaga.elmahdi.tp3.mvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private AppointmentStatus status;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    @OneToOne(mappedBy = "appointment")
    private Consultation consultation;
}
