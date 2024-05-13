package gaga.elmahdi.tp3.mvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity(name = "DOCTORS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String speciality;
    private String email;
    @OneToMany(mappedBy = "doctor")
    private Collection<Appointment> appointments;
}
