package ir.hospital.service.secretaryService;

import ir.hospital.dto.SecretaryDto;
import ir.hospital.entity.Secretary;
import ir.hospital.repository.secretaryRepository.SecretaryRepositoryImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class SecretaryServiceImpl implements SecretaryService {

    private static final Logger LOGGER = LogManager.getLogger(SecretaryServiceImpl.class);

    private final SecretaryRepositoryImpl SECRETARY_REPOSITORY = ApplicationContext.getSECRETARY_REPOSITORY();

    @Override
    public void save(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                SECRETARY_REPOSITORY.save(session, secretary);
                session.getTransaction().commit();
                LOGGER.debug("save {} ", secretary);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("error save {} ", secretary, e);
            }
        }
    }

    @Override
    public void saveOrUpdate(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                SECRETARY_REPOSITORY.saveOrUpdate(session, secretary);
                session.getTransaction().commit();
                LOGGER.debug("save or update {} ", secretary);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("error save or update {} ", secretary, e);
            }
        }
    }

    @Override
    public void update(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                SECRETARY_REPOSITORY.update(session, secretary);
                session.getTransaction().commit();
                LOGGER.debug("update {} ", secretary);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("error update {} ", secretary, e);
            }
        }
    }

    @Override
    public Secretary findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("find by id {} ", id);
                return SECRETARY_REPOSITORY.findById(session, id).orElseThrow();
            } catch (Exception e) {
                LOGGER.error("error find by id {} ", id, e);
                return null;
            }
        }
    }

    @Override
    public void delete(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                SECRETARY_REPOSITORY.delete(session, secretary);
                session.getTransaction().commit();
                LOGGER.debug("delete {} ", secretary);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("error delete {} ", secretary, e);

            }
        }
    }

    @Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("is exist {}", id);
                return SECRETARY_REPOSITORY.isExist(session, id);
            } catch (Exception e) {
                LOGGER.error("error is exist {} ", id, e);
                return false;
            }
        }
    }

    @Override
    public Secretary findByNc(String nationalCode) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("find by national code {}", nationalCode);
                return SECRETARY_REPOSITORY.findByNc(session, nationalCode).orElseThrow();
            } catch (Exception e) {
                LOGGER.error("error national code {} ", nationalCode, e);
                return null;
            }
        }
    }

    @Override
    public SecretaryDto ShowAllData(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("show all data");
                return new SecretaryDto
                        (SECRETARY_REPOSITORY.showAllPatient(session, secretary).orElseThrow()
                                , SECRETARY_REPOSITORY.showAllDoctors(session, secretary).orElseThrow());
            } catch (Exception e) {
                LOGGER.error("error show all data", e);
                return null;
            }
        }
    }
}
