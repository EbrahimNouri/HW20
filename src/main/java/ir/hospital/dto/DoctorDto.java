package ir.hospital.dto;

import ir.hospital.entity.Queuing;
import ir.hospital.entity.SpecialtyType;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DoctorDto {

    private String firstname;

    private String lastname;

    private SpecialtyType specialtyType;

    private List<Queuing> queuings;

    private List<DateReserved> dateReserves;

}
