package ir.hospital.repository.patientRepository;

import ir.hospital.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.Optional;

public class PatientRepositoryImpl implements PatientRepository{

    private static final Logger LOGGER = LogManager.getLogger(PatientRepositoryImpl.class);
    @Override
    public void save(Session session, Patient patient) {
        LOGGER.debug("Patient repo save {}", patient);
        PatientRepository.super.save(session, patient);
    }

    @Override
    public Optional<Patient> findById(Session session, Long id) {
        LOGGER.debug("Patient repo find by id {}", id);
        return Optional.ofNullable(session.find(Patient.class, id));
    }

    @Override
    public void update(Session session, Patient patient) {
        LOGGER.debug("Patient repo save update {}", patient);
        PatientRepository.super.update(session, patient);
    }

    @Override
    public void delete(Session session, Patient patient) {
        LOGGER.debug("Patient repo delete {}", patient);
        PatientRepository.super.delete(session, patient);
    }

    @Override
    public void saveOrUpdate(Session session, Patient patient) {
        LOGGER.debug("Patient repo save or update {}", patient);
        PatientRepository.super.saveOrUpdate(session, patient);
    }

    @Override
    public Optional<Patient> findByNc(Session session, String nationalCode) {
        LOGGER.debug("Patient repo find by national code {}", nationalCode);
        return Optional.ofNullable(session.createQuery("from Patient p where p.nationalCode = :ncode", Patient.class)
                .setParameter("nscode", nationalCode).getSingleResult());
    }

    @Override
    public boolean isExist(Session session, Long id) {
        LOGGER.debug("Patient repo is exist {}", id);
        return session.find(Patient.class, id) != null;
    }
}
