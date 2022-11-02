package ir.hospital.dto;

import ir.hospital.entity.Doctor;
import ir.hospital.entity.Patient;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SecretaryDto {
    private List<Patient> patients;
    private List<Doctor> doctors;
}
