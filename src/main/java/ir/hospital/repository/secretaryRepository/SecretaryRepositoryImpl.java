package ir.hospital.repository.secretaryRepository;

import ir.hospital.entity.Doctor;
import ir.hospital.entity.Patient;
import ir.hospital.entity.Secretary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class SecretaryRepositoryImpl implements SecretaryRepository {

    private static final Logger LOGGER = LogManager.getLogger(SecretaryRepositoryImpl.class);

    @Override
    public void save(Session session, Secretary secretary) {
        LOGGER.debug("Secretary repo save {}", secretary);
        SecretaryRepository.super.save(session, secretary);
    }

    @Override
    public Optional<Secretary> findById(Session session, Long id) {
        LOGGER.debug("Secretary repo find by id {}", id);
        return Optional.ofNullable(session.find(Secretary.class, id));
    }

    @Override
    public void update(Session session, Secretary secretary) {
        LOGGER.debug("Secretary repo update {}", secretary);
        SecretaryRepository.super.update(session, secretary);
    }

    @Override
    public void delete(Session session, Secretary secretary) {
        LOGGER.debug("Secretary repo delete {}", secretary);
        SecretaryRepository.super.delete(session, secretary);
    }

    @Override
    public void saveOrUpdate(Session session, Secretary secretary) {
        LOGGER.debug("Secretary repo save or update {}", secretary);
        SecretaryRepository.super.saveOrUpdate(session, secretary);
    }

    @Override
    public Optional<Secretary> findByNc(Session session, String nationalCode) {
        LOGGER.debug("Secretary repo find by national code {}", nationalCode);
        return Optional.ofNullable(session.createQuery("from Secretary p where p.nationalCode = :ncode"
                        , Secretary.class)
                .setParameter("nscode", nationalCode).getSingleResult());
    }

    @Override
    public Optional<List<Patient>> showAllPatient(Session session, Secretary secretary) {
        LOGGER.debug("Secretary repo show all patient {}", secretary);

        return Optional.ofNullable(session.createQuery("from Patient p where p.clinic.id  = :cId "
                        , Patient.class)
                .setParameter("cId", secretary.getClinic().getId()).getResultList());
    }

    @Override
    public Optional<List<Doctor>> showAllDoctors(Session session, Secretary secretary) {
        LOGGER.debug("Secretary repo show all doctors {}", secretary);
        return Optional.ofNullable(session.createQuery("from Doctor p where p.clinic.id = :dId", Doctor.class)
                .setParameter("dId", secretary.getClinic().getId()).getResultList());
    }

    @Override
    public boolean isExist(Session session, Long id) {
        LOGGER.debug("Secretary repo is exist {}", id);
        return session.find(Secretary.class, id) != null;
    }
}
