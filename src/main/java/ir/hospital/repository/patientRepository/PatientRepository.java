package ir.hospital.repository.patientRepository;

import ir.hospital.dto.PatientGetterDto;
import ir.hospital.entity.Patient;
import ir.hospital.repository.BaseRepository;
import org.hibernate.Session;

import java.util.Optional;

public interface PatientRepository extends BaseRepository<Patient> {
    Optional<Patient> findByNc(Session session, String nationalCode);

}
