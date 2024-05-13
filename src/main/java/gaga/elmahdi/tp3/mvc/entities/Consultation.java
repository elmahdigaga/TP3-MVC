package gaga.elmahdi.tp3.mvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date date;
    private String rapport;
    @OneToOne
    private Appointment appointment;

}
