package ir.hospital.repository.secretaryRepository;

import ir.hospital.entity.Doctor;
import ir.hospital.entity.Patient;
import ir.hospital.entity.Secretary;
import ir.hospital.repository.BaseRepository;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface SecretaryRepository extends BaseRepository<Secretary> {
    Optional<Secretary> findByNc(Session session, String nationalCode);

    Optional<List<Patient>> showAllPatient(Session session, Secretary secretary);

    Optional<List<Doctor>> showAllDoctors(Session session, Secretary secretary);

}
