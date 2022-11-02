package ir.hospital.service.prescriptionService;

import ir.hospital.entity.Prescription;
import ir.hospital.repository.prescriptionRepository.PrescriptionRepositoryImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.hibernate.Session;

import java.util.List;

public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionRepositoryImpl PRESCRIPTION_REPOSITORY = ApplicationContext.getPRESCRIPTION_REPOSITORY();
    @Override
    public void save(Prescription prescription) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PRESCRIPTION_REPOSITORY.save(session, prescription);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
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
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
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
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Prescription findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return PRESCRIPTION_REPOSITORY.findById(session, id).orElseThrow();
        }
    }

    @Override
    public void delete(Prescription prescription) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PRESCRIPTION_REPOSITORY.delete(session, prescription);
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
            return PRESCRIPTION_REPOSITORY.isExist(session, id);
        }
    }


    //TODO
    @Override
    public List<Prescription> findByPatientId(Long id) {
        return null;
    }
}
