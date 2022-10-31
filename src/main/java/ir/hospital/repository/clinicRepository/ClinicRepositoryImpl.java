package ir.hospital.repository.clinicRepository;

import ir.hospital.entity.Clinic;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ClinicRepositoryImpl implements ClinicRepository{

    @Override
    public void save(Session session, Clinic clinic) {
        ClinicRepository.super.save(session, clinic);
    }

    @Override
    public Optional<Clinic> findById(Session session, Long id) {
        return Optional.ofNullable(session.find(Clinic.class, id));
    }

    @Override
    public void update(Session session, Clinic clinic) {
        ClinicRepository.super.update(session, clinic);
    }

    @Override
    public void delete(Session session, Clinic clinic) {
        ClinicRepository.super.delete(session, clinic);
    }

    @Override
    public void saveOrUpdate(Session session, Clinic clinic) {
        ClinicRepository.super.saveOrUpdate(session, clinic);
    }

    @Override
    public Optional<List<Clinic>> findAllClinics(Session session) {
        return Optional.ofNullable(session.createQuery("from Clinic", Clinic.class).getResultList());
    }
}
