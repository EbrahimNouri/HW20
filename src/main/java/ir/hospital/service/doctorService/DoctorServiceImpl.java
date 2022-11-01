package ir.hospital.service.doctorService;

import ir.hospital.entity.Doctor;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.hibernate.Session;

public class DoctorServiceImpl implements DoctorService {


    @Override
    public void save(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getDOCTOR_REPOSITORY().save(session, doctor);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void saveOrUpdate(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getDOCTOR_REPOSITORY().saveOrUpdate(session, doctor);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void update(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getDOCTOR_REPOSITORY().update(session, doctor);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Doctor findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getDOCTOR_REPOSITORY().findById(session, id).orElseThrow();

        }
    }

    @Override
    public void delete(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                ApplicationContext.getDOCTOR_REPOSITORY().delete(session, doctor);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Doctor findByNc(String nationalCode) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getDOCTOR_REPOSITORY().findByNc(session, nationalCode).orElseThrow();
        }
    }
@Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getDOCTOR_REPOSITORY().isExist(session, id);
        }
    }
}