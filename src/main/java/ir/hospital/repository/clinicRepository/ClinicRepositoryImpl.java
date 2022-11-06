package ir.hospital.repository.clinicRepository;

import ir.hospital.entity.Clinic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;


public class ClinicRepositoryImpl implements ClinicRepository {

    private static final Logger LOGGER = LogManager.getLogger(ClinicRepositoryImpl.class);


    @Override
    public void save(Session session, Clinic clinic) {
        ClinicRepository.super.save(session, clinic);
        LOGGER.debug("clinic repo save {}", clinic);
    }

    @Override
    public Optional<Clinic> findById(Session session, Long id) {
        LOGGER.debug("clinic repo find by Id {}", id);
        return Optional.ofNullable(session.find(Clinic.class, id));
    }

    @Override
    public void update(Session session, Clinic clinic) {
        LOGGER.debug("clinic repo update {}", clinic);
        ClinicRepository.super.update(session, clinic);
    }

    @Override
    public void delete(Session session, Clinic clinic) {
        ClinicRepository.super.delete(session, clinic);
        LOGGER.debug("clinic repo delete {}", clinic);
    }

    @Override
    public void saveOrUpdate(Session session, Clinic clinic) {
        ClinicRepository.super.saveOrUpdate(session, clinic);
        LOGGER.debug("clinic repo saveOrUpdate {}", clinic);
    }

    @Override
    public boolean isExist(Session session, Long id) {
        LOGGER.debug("clinic repo is exist {}", id);
        return session.get(Clinic.class, id) != null;
    }

    @Override
    public Optional<List<Clinic>> findAllClinics(Session session) {
        LOGGER.debug("clinic repo find all clinics");
        return Optional.ofNullable(session.createQuery("from Clinic", Clinic.class).getResultList());
    }
}
