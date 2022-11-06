package ir.hospital.service.prescriptionService;

import ir.hospital.entity.Prescription;
import ir.hospital.repository.prescriptionRepository.PrescriptionRepositoryImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.List;

public class PrescriptionServiceImpl implements PrescriptionService {

    private static final Logger LOGGER = LogManager.getLogger(PrescriptionServiceImpl.class);

    private final PrescriptionRepositoryImpl PRESCRIPTION_REPOSITORY = ApplicationContext.getPRESCRIPTION_REPOSITORY();

    @Override
    public void save(Prescription prescription) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PRESCRIPTION_REPOSITORY.save(session, prescription);
                session.getTransaction().commit();
                LOGGER.debug("saved {} ", prescription);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("error save {} ", prescription, e);
            }
        }
    }

    @Override
    public void saveOrUpdate(Prescription prescription) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PRESCRIPTION_REPOSITORY.saveOrUpdate(session, prescription);
                session.getTransaction().commit();
                LOGGER.debug("save or update {} ", prescription);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("error save or update {} ", prescription, e);
            }
        }
    }

    @Override
    public void update(Prescription prescription) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PRESCRIPTION_REPOSITORY.update(session, prescription);
                session.getTransaction().commit();
                LOGGER.debug("update {} ", prescription);
            } catch (Exception e) {
                session.getTransaction().rollback();

            }
        }
    }

    @Override
    public Prescription findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("find by id {} ", id);
                return PRESCRIPTION_REPOSITORY.findById(session, id).orElseThrow();
            } catch (Exception e) {
                LOGGER.error("error find by id {} ", id, e);
                return null;
            }

        }
    }

    @Override
    public void delete(Prescription prescription) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PRESCRIPTION_REPOSITORY.delete(session, prescription);
                session.getTransaction().commit();
                LOGGER.debug("delete {} ", prescription);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("delete {} ", prescription, e);
            }
        }
    }

    @Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("is exist {} ", id);
                return PRESCRIPTION_REPOSITORY.isExist(session, id);
            } catch (Exception e) {
                LOGGER.error("error is exist {} ", id, e);
                return false;
            }
        }
    }


    //TODO
    @Override
    public List<Prescription> findByPatientId(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.getCurrentSession()) {
            try {
                LOGGER.debug("find by patient id {} ", id);
                return PRESCRIPTION_REPOSITORY.findByPatientId(session, id).orElseThrow();
            } catch (Exception e) {
                LOGGER.error("error find by patient id {} ", id, e);
                return null;
            }
        }
    }
}
