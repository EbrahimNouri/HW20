package ir.hospital.dto;

import ir.hospital.entity.LocalDateType;
import ir.hospital.entity.SpecialtyType;
import lombok.*;

import java.time.LocalDate;
import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DoctorDto {

    private String firstname;

    private String lastname;

    private SpecialtyType specialtyType;

//    private List<Queuing> queuings;

    private Map<LocalDate, LocalDateType> dateReserves;

}
