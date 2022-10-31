package ir.hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Queuing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate localDate;

    private LocalDateType localDateType;

    private QueuingCheck queuingCheck = QueuingCheck.EMPTY;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;


}
