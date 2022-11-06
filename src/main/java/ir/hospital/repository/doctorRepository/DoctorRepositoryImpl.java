package ir.hospital.repository.doctorRepository;

import ir.hospital.entity.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.Optional;

public class DoctorRepositoryImpl implements DoctorRepository {

    private static final Logger LOGGER = LogManager.getLogger(DoctorRepositoryImpl.class);


    @Override
    public void save(Session session, Doctor doctor) {
        LOGGER.debug("Doctor repo save {}", doctor);
        session.persist(doctor);
    }

    @Override
    public Optional<Doctor> findById(Session session, Long id) {
        LOGGER.debug("Doctor repo find bby id {}", id);
        return Optional.ofNullable(session.find(Doctor.class, id));
    }

    @Override
    public void update(Session session, Doctor doctor) {
        LOGGER.debug("Doctor repo update {}", doctor);
        session.merge(doctor);
    }

    @Override
    public void delete(Session session, Doctor doctor) {
        LOGGER.debug("Doctor repo remove {}", doctor);
        session.remove(doctor);
    }

    @Override
    public void saveOrUpdate(Session session, Doctor doctor) {
        LOGGER.debug("Doctor repo save or update {}", doctor);
        DoctorRepository.super.saveOrUpdate(session, doctor);
    }

    @Override
    public boolean isExist(Session session, Long id) {
        LOGGER.debug("Doctor repo is exist {}", id);
        return session.find(Doctor.class, id) != null;
    }

    @Override
    public Optional<Doctor> findByNc(Session session, String nationalCode) {
        LOGGER.debug("Doctor repo find by national code {}", nationalCode);
        return Optional.ofNullable(session.createQuery("from Doctor p where p.nationalCode = :ncode", Doctor.class)
                .setParameter("nscode", nationalCode).getSingleResult());
    }
}