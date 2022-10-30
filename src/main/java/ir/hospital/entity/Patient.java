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
public class Patient extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private Set<Clinic> clinics;

    @OneToMany(mappedBy = "patient")
    private Set<Queuing> queuings;

    @OneToMany(mappedBy = "patient")
    private Set<Prescription> prescriptions;

}
