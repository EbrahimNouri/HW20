package ir.hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Doctor extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeNumber;
    private SpecialtyType  specialtyType;

    @ManyToOne
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor")
    private Set<Queuing> queuings;

    @Builder
    public Doctor(String firstname, String lastname, String nationalCode, String password, String phoneNumber,
                  String address, Long id, String employeeNumber, SpecialtyType specialtyType,
                  Clinic clinic, Set<Queuing> queuings) {
        super(firstname, lastname, nationalCode, password, phoneNumber, address);
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.specialtyType = specialtyType;
        this.clinic = clinic;
        this.queuings = queuings;
    }

    public Doctor(Long id, String employeeNumber, SpecialtyType specialtyType, Clinic clinic, Set<Queuing> queuings) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.specialtyType = specialtyType;
        this.clinic = clinic;
        this.queuings = queuings;
    }
}
