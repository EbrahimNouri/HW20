package ir.hospital.service.doctorService;

import ir.hospital.entity.Doctor;
import ir.hospital.repository.doctorRepository.DoctorRepositoryImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.hibernate.Session;

public class DoctorServiceImpl implements DoctorService {
private final DoctorRepositoryImpl DOCTOR_REPOSITORY = ApplicationContext.getDOCTOR_REPOSITORY();

    @Override
    public void save(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                DOCTOR_REPOSITORY.save(session, doctor);
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
                DOCTOR_REPOSITORY.saveOrUpdate(session, doctor);
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
                DOCTOR_REPOSITORY.update(session, doctor);
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
            return DOCTOR_REPOSITORY.findById(session, id).orElseThrow();

        }
    }

    @Override
    public void delete(Doctor doctor) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                DOCTOR_REPOSITORY.delete(session, doctor);
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
            return DOCTOR_REPOSITORY.findByNc(session, nationalCode).orElseThrow();
        }
    }
@Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return DOCTOR_REPOSITORY.isExist(session, id);
        }
    }
}