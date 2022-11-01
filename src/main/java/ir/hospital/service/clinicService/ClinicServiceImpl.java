package ir.hospital.service.clinicService;

import ir.hospital.entity.Clinic;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.hibernate.Session;

import java.util.List;

public class ClinicServiceImpl implements ClinicService {
    @Override
    public void save(Clinic clinic) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getCLINIC_REPOSITORY().save(session, clinic);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void saveOrUpdate(Clinic clinic) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getCLINIC_REPOSITORY().saveOrUpdate(session, clinic);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void update(Clinic clinic) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getCLINIC_REPOSITORY().update(session, clinic);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Clinic findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getCLINIC_REPOSITORY().findById(session, id).orElseThrow();
        }
    }

    @Override
    public void delete(Clinic clinic) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getCLINIC_REPOSITORY().delete(session, clinic);
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
            return ApplicationContext.getCLINIC_REPOSITORY().isExist(session, id);
        }
    }

    @Override
    public List<Clinic> clinics() {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getCLINIC_REPOSITORY().findAllClinics(session).orElseThrow();
        }
    }
}
