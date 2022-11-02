package ir.hospital.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClinicDto {
    private String clinicName;

    private String address;

    private List<DoctorDto> doctorDtos;

}
