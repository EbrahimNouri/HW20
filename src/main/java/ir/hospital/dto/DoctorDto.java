package ir.hospital.dto;

import ir.hospital.entity.SpecialtyType;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DoctorDto {

    private String name;

    private SpecialtyType specialtyType;

}
