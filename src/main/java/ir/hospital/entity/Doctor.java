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
public class Doctor extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeNumber;
    private SpecialtyType  specialtyType;
    @ManyToOne()
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor")
    private Set<Queuing> queuings;

}
