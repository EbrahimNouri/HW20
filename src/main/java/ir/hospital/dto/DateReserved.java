package ir.hospital.dto;

import ir.hospital.entity.LocalDateType;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DateReserved {

    private LocalDate localDate;

    private List<LocalDateType> localDateType;

}
