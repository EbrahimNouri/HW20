package ir.hospital.repository.prescriptionRepository;

import ir.hospital.entity.Prescription;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class PrescriptionRepositoryImpl implements PrescriptionRepository{
    @Override
    public void save(Session session, Prescription prescription) {
        PrescriptionRepository.super.save(session, prescription);
    }

    @Override
    public Optional<Prescription> findById(Session session, Long id) {
        return Optional.ofNullable(session.find(Prescription.class, id));
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

    @Override
    public boolean isExist(Session session, Long id) {
        return session.find(Prescription.class, id) != null;
    }

    @Override
    public Optional<List<Prescription>> findByPatientId(Session session, Long id) {
        return Optional.ofNullable(session.createQuery("from Prescription p where p.patient.id = :pId"
                , Prescription.class).setParameter("pId", id).getResultList());
    }
}
