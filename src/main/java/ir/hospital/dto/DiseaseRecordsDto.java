package ir.hospital.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DiseaseRecordsDto {

    private String ClinicName;

    private String description;

    private LocalDate localDate;

    private String DrName;

}
