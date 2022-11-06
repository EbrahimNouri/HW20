package ir.hospital.service.doctorService;

import ir.hospital.entity.Doctor;
import ir.hospital.repository.doctorRepository.DoctorRepositoryImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class DoctorServiceImpl implements DoctorService {

    private static final Logger LOGGER = LogManager.getLogger(DoctorServiceImpl.class);

    private final DoctorRepositoryImpl DOCTOR_REPOSITORY = ApplicationContext.getDOCTOR_REPOSITORY();

    @Override
    public void save(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                DOCTOR_REPOSITORY.save(session, doctor);
                session.getTransaction().commit();
                LOGGER.debug("saved {}", doctor);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("can't save {}", doctor, e);}
        }
    }

    @Override
    public void saveOrUpdate(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                DOCTOR_REPOSITORY.saveOrUpdate(session, doctor);
                session.getTransaction().commit();
                LOGGER.debug("saved or updated {}", doctor);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("can't save or update {}", doctor, e);
            }
        }
    }

    @Override
    public void update(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                DOCTOR_REPOSITORY.update(session, doctor);
                session.getTransaction().commit();
                LOGGER.debug("updated {}", doctor);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("cant update {}", doctor, e);
            }
        }
    }

    @Override
    public Doctor findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("find by id {}", id);
                return DOCTOR_REPOSITORY.findById(session, id).orElseThrow();
            }catch (Exception e){
                LOGGER.error("cant find by id {}", id, e);
                return null;
            }
        }
    }

    @Override
    public void delete(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                DOCTOR_REPOSITORY.delete(session, doctor);
                session.getTransaction().commit();
                LOGGER.debug("deleted {}", doctor);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("cant delete {}", doctor, e);
            }
        }
    }

    @Override
    public Doctor findByNc(String nationalCode) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("found by national code {}", nationalCode);
                return DOCTOR_REPOSITORY.findByNc(session, nationalCode).orElseThrow();
            }catch (Exception e){
                LOGGER.error("cant find by national code {}", nationalCode, e);
                return null;
            }
        }
    }

    @Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("Doctor updated {}", id);
                return DOCTOR_REPOSITORY.isExist(session, id);
            } catch (Exception e) {
                LOGGER.error("cant check is exist {}", id, e);
                return false;
            }
        }
    }
}