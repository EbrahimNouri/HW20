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
    @ManyToOne(fetch = FetchType.EAGER)
    private Clinic clinic;

    @OneToMany(mappedBy = "patient")
    private Set<Queuing> queuings;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Set<Prescription> prescriptions;

    @Builder
    public Patient(String firstname, String lastname, String nationalCode, String password, String phoneNumber
            , String address, Long id, Clinic clinic, Set<Queuing> queuings, Set<Prescription> prescriptions) {
        super(firstname, lastname, nationalCode, password, phoneNumber, address);
        this.id = id;
        this.clinic = clinic;
        this.queuings = queuings;
        this.prescriptions = prescriptions;
    }

    public Patient(Long id, Clinic clinic, Set<Queuing> queuings, Set<Prescription> prescriptions) {
        this.id = id;
        this.clinic = clinic;
        this.queuings = queuings;
        this.prescriptions = prescriptions;
    }
}
