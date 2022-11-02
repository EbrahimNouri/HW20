package ir.hospital.service.secretaryService;

import ir.hospital.dto.SecretaryDto;
import ir.hospital.entity.Secretary;
import ir.hospital.repository.secretaryRepository.SecretaryRepositoryImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.hibernate.Session;

public class SecretaryServiceImpl implements SecretaryService {

    private final SecretaryRepositoryImpl SECRETARY_REPOSITORY = ApplicationContext.getSECRETARY_REPOSITORY();
    @Override
    public void save(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                SECRETARY_REPOSITORY.save(session, secretary);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
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
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
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
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Secretary findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return SECRETARY_REPOSITORY.findById(session, id).orElseThrow();
        }
    }

    @Override
    public void delete(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                SECRETARY_REPOSITORY.delete(session, secretary);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return SECRETARY_REPOSITORY.isExist(session, id);
        }
    }

    @Override
    public Secretary findByNc(String nationalCode) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return SECRETARY_REPOSITORY.findByNc(session, nationalCode).orElseThrow();
        }
    }

    @Override
    public SecretaryDto ShowAllData(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return new SecretaryDto
                    (SECRETARY_REPOSITORY.showAllPatient(session, secretary).orElseThrow()
                    , SECRETARY_REPOSITORY.showAllDoctors(session, secretary).orElseThrow());
        }
    }
}
