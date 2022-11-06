package ir.hospital.service.clinicService;

import ir.hospital.entity.Clinic;
import ir.hospital.repository.clinicRepository.ClinicRepositoryImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.List;

public class ClinicServiceImpl implements ClinicService {

    private static final Logger LOGGER = LogManager.getLogger(ClinicServiceImpl.class);

    private final ClinicRepositoryImpl CLINIC_REPOSITORY = ApplicationContext.getCLINIC_REPOSITORY();

    @Override
    public void save(Clinic clinic) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                CLINIC_REPOSITORY.save(session, clinic);
                session.getTransaction().commit();
                LOGGER.debug("clinic saved {}", clinic);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("cant save data {}", clinic, e);
            }
        }
    }

    @Override
    public void saveOrUpdate(Clinic clinic) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                CLINIC_REPOSITORY.saveOrUpdate(session, clinic);
                session.getTransaction().commit();
                LOGGER.debug("clinic saved or updated {}", clinic);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("cant save data {}", clinic, e);
            }
        }
    }

    @Override
    public void update(Clinic clinic) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                CLINIC_REPOSITORY.update(session, clinic);
                session.getTransaction().commit();
                LOGGER.debug("clinic updated {}", clinic);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("cant save {}", clinic, e);
            }
        }
    }

    @Override
    public Clinic findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("found {}", id);
                return CLINIC_REPOSITORY.findById(session, id).orElseThrow();
            } catch (Exception e) {
                LOGGER.error("cant find {}", id, e);
                return null;
            }
        }
    }

    @Override
    public void delete(Clinic clinic) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                CLINIC_REPOSITORY.delete(session, clinic);
                session.getTransaction().commit();
                LOGGER.debug("found {}", clinic);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("cant find {}", clinic, e);

            }
        }
    }

    @Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("is exist is running {}", id);
                return CLINIC_REPOSITORY.isExist(session, id);
            } catch (Exception e) {
                LOGGER.error("cant complete is exist{}", id, e);
                return false;
            }
        }
    }

    @Override
    public List<Clinic> clinics() {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("get all clinics");
                return CLINIC_REPOSITORY.findAllClinics(session).orElseThrow();
            } catch (Exception e) {
                LOGGER.error("cant fetch clinics", e);
                return null;
            }
        }
    }
}
