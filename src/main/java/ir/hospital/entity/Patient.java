package ir.hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
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

    @Builder
    public Patient(String firstname, String lastname, String nationalCode, String phoneNumber, String address, Long id
            , Set<Clinic> clinics, Set<Queuing> queuings, Set<Prescription> prescriptions) {
        super(firstname, lastname, nationalCode, phoneNumber, address);
        this.id = id;
        this.clinics = clinics;
        this.queuings = queuings;
        this.prescriptions = prescriptions;
    }

    public Patient(Long id, Set<Clinic> clinics, Set<Queuing> queuings, Set<Prescription> prescriptions) {
        this.id = id;
        this.clinics = clinics;
        this.queuings = queuings;
        this.prescriptions = prescriptions;
    }
}
