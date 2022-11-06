package ir.hospital.repository.prescriptionRepository;

import ir.hospital.entity.Prescription;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class PrescriptionRepositoryImpl implements PrescriptionRepository {

    private static final Logger LOGGER = LogManager.getLogger(PrescriptionRepositoryImpl.class);

    @Override
    public void save(Session session, Prescription prescription) {
        LOGGER.debug("Prescription repo save {}", prescription);
        PrescriptionRepository.super.save(session, prescription);
    }

    @Override
    public Optional<Prescription> findById(Session session, Long id) {
        LOGGER.debug("Prescription repo find by id {}", id);
        return Optional.ofNullable(session.find(Prescription.class, id));
    }

    @Override
    public void update(Session session, Prescription prescription) {
        LOGGER.debug("Prescription repo update {}", prescription);
        PrescriptionRepository.super.update(session, prescription);
    }

    @Override
    public void delete(Session session, Prescription prescription) {
        LOGGER.debug("Prescription repo delete {}", prescription);
        PrescriptionRepository.super.delete(session, prescription);
    }

    @Override
    public void saveOrUpdate(Session session, Prescription prescription) {
        LOGGER.debug("Prescription repo save or update {}", prescription);
        PrescriptionRepository.super.saveOrUpdate(session, prescription);
    }

    @Override
    public boolean isExist(Session session, Long id) {
        LOGGER.debug("Prescription repo is exist {}", id);
        return session.find(Prescription.class, id) != null;
    }

    @Override
    public Optional<List<Prescription>> findByPatientId(Session session, Long id) {
        LOGGER.debug("Prescription repo find by patient id{}", id);
        return Optional.ofNullable(session.createQuery("from Prescription p where p.patient.id = :pId"
                , Prescription.class).setParameter("pId", id).getResultList());
    }
}
