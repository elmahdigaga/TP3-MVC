package gaga.elmahdi.tp3.mvc.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.Collection;

@Entity(name = "PATIENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "The name of the patient is required") @Size(min = 5, max = 40)
    private String name;
     @Range(min =1,max= 120, message = "The age must be between 5 and 120")
    private int age;
    private boolean ill;
    @OneToMany(mappedBy = "patient")
    private Collection<Appointment> appointments;
}
