package ir.hospital.repository.doctorRepository;

import ir.hospital.entity.Doctor;
import ir.hospital.entity.Patient;
import ir.hospital.repository.BaseRepository;
import org.hibernate.Session;

import java.util.Optional;

public interface DoctorRepository extends BaseRepository<Doctor> {
    Optional<Doctor> findByNc(Session session, String nationalCode);

}
