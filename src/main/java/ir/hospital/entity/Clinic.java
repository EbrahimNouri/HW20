package ir.hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "clinic")
    private Set<Doctor> doctors;

    @ManyToMany(mappedBy = "clinics")
    private Set<Patient> patients;

    @OneToOne
    private Secretary secretary;

}
