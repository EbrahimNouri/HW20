package ir.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Column(unique = true, nullable = false)
    @Pattern(regexp = "\\d{10}",
            message = "Please provide a valid national code")
    private String nationalCode;

    @Size(min = 8, max = 100, message = "password is invalid")
    @Column(nullable = false)
    private String password;

    @Pattern(regexp = "\\d{11}",
            message = "Please provide a valid phone number")
    private String phoneNumber;

    private String address;

}
