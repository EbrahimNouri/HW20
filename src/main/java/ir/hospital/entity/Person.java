package ir.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {
    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String nationalCode;

    private String password;

    private String phoneNumber;

    private String address;

}
