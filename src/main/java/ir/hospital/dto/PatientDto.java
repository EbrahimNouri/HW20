package ir.hospital.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PatientDto {

    private String firstname;

    private String lastname;

    private String nationalCode;

    private String phoneNumber;

    private String address;

    private List<DiseaseRecordsDto> diseaseRecordsDtos;

}
