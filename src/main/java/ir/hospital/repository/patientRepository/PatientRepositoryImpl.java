package ir.hospital.repository.patientRepository;

import ir.hospital.entity.Patient;
import org.hibernate.Session;

public class PatientRepositoryImpl implements PatientRepository{
    @Override
    public void save(Session session, Patient patient) {
        PatientRepository.super.save(session, patient);
    }

    @Override
    public Patient findById(Session session, Long id) {
        return session.find(Patient.class, id);
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
}
