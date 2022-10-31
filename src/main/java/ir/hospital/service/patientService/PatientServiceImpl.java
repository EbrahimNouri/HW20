package ir.hospital.service.patientService;

import ir.hospital.entity.Patient;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.hibernate.Session;

public class PatientServiceImpl implements PatientService {
    @Override
    public void save(Patient patient) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getPATIENT_REPOSITORY().save(session, patient);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void saveOrUpdate(Patient patient) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getPATIENT_REPOSITORY().saveOrUpdate(session, patient);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void update(Patient patient) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getPATIENT_REPOSITORY().update(session, patient);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Patient findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getPATIENT_REPOSITORY().findById(session, id).orElseThrow();
        }
    }

    @Override
    public void delete(Patient patient) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getPATIENT_REPOSITORY().delete(session, patient);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Patient findByNc(String nationalCode) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getPATIENT_REPOSITORY().findByNc(session, nationalCode).orElseThrow();
        }
    }
}
