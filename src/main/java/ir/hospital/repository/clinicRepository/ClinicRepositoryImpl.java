package ir.hospital.repository.clinicRepository;

import ir.hospital.entity.Clinic;
import org.hibernate.Session;

public class ClinicRepositoryImpl implements ClinicRepository{

    @Override
    public void save(Session session, Clinic clinic) {
        ClinicRepository.super.save(session, clinic);
    }

    @Override
    public Clinic findById(Session session, Long id) {
        return null;
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
}
