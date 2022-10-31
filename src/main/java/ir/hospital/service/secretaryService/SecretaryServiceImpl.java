package ir.hospital.service.secretaryService;

import ir.hospital.entity.Secretary;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.hibernate.Session;

public class SecretaryServiceImpl implements SecretaryService {
    @Override
    public void save(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getSECRETARY_REPOSITORY().save(session, secretary);
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
                ApplicationContext.getSECRETARY_REPOSITORY().saveOrUpdate(session, secretary);
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
                ApplicationContext.getSECRETARY_REPOSITORY().update(session, secretary);
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
            return ApplicationContext.getSECRETARY_REPOSITORY().findById(session, id).orElseThrow();
        }
    }

    @Override
    public void delete(Secretary secretary) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getSECRETARY_REPOSITORY().delete(session, secretary);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Secretary findByNc(String nationalCode) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getSECRETARY_REPOSITORY().findByNc(session, nationalCode).orElseThrow();
        }
    }
}
