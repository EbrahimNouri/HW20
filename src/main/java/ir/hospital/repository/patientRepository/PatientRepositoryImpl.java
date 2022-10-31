package ir.hospital.repository.patientRepository;

import ir.hospital.entity.Patient;
import org.hibernate.Session;

import java.util.Optional;

public class PatientRepositoryImpl implements PatientRepository{
    @Override
    public void save(Session session, Patient patient) {
        PatientRepository.super.save(session, patient);
    }

    @Override
    public Optional<Patient> findById(Session session, Long id) {
        return Optional.ofNullable(session.find(Patient.class, id));
    }

    @Override
    public void update(Session session, Patient patient) {
        PatientRepository.super.update(session, patient);
    }

    @Override
    public void delete(Session session, Patient patient) {
        PatientRepository.super.delete(session, patient);
    }

    @Override
    public void saveOrUpdate(Session session, Patient patient) {
        PatientRepository.super.saveOrUpdate(session, patient);
    }

    @Override
    public Optional<Patient> findByNc(Session session, String nationalCode) {
        return Optional.ofNullable(session.createQuery("from Patient p where p.nationalCode = :ncode", Patient.class)
                .setParameter("nscode", nationalCode).getSingleResult());
    }
}
