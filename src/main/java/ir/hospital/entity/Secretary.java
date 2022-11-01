package ir.hospital.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
public class Secretary extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Clinic clinic;

    @Builder
    public Secretary(String firstname, String lastname, String nationalCode, String password, String phoneNumber, String address, Long id, Clinic clinic) {
        super(firstname, lastname, nationalCode, password, phoneNumber, address);
        this.id = id;
        this.clinic = clinic;
    }

    public Secretary(Long id, Clinic clinic) {
        this.id = id;
        this.clinic = clinic;
    }
}
