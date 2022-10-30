package ir.hospital.repository.prescriptionRepository;

import ir.hospital.entity.Prescription;
import org.hibernate.Session;

public class PrescriptionRepositoryImpl implements PrescriptionRepository{
    @Override
    public void save(Session session, Prescription prescription) {
        PrescriptionRepository.super.save(session, prescription);
    }

    @Override
    public Prescription findById(Session session, Long id) {
        return session.find(Prescription.class, id);
    }

    @Override
    public void update(Session session, Prescription prescription) {
        PrescriptionRepository.super.update(session, prescription);
    }

    @Override
    public void delete(Session session, Prescription prescription) {
        PrescriptionRepository.super.delete(session, prescription);
    }

    @Override
    public void saveOrUpdate(Session session, Prescription prescription) {
        PrescriptionRepository.super.saveOrUpdate(session, prescription);
    }
}
