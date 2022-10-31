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

    private String address;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
    private Set<Doctor> doctors;

    @ManyToMany(mappedBy = "clinics")
    private Set<Patient> patients;

    @OneToOne(fetch = FetchType.EAGER)
    private Secretary secretary;

}
