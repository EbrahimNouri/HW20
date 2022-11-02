package ir.hospital.repository.prescriptionRepository;

import ir.hospital.entity.Prescription;
import ir.hospital.repository.BaseRepository;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository extends BaseRepository<Prescription> {

    Optional<List<Prescription>> findByPatientId(Session session, Long id);
}
