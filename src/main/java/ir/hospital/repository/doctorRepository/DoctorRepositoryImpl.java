package ir.hospital.repository.doctorRepository;

import ir.hospital.entity.Doctor;
import ir.hospital.entity.Patient;
import org.hibernate.Session;

import java.util.Optional;

public class DoctorRepositoryImpl implements DoctorRepository {
    @Override
    public void save(Session session, Doctor doctor) {
        session.save(doctor);
    }

    @Override
    public Optional<Doctor> findById(Session session, Long id) {
        return Optional.ofNullable(session.find(Doctor.class, id));
    }

    @Override
    public void update(Session session, Doctor doctor) {
        session.update(doctor);
    }

    @Override
    public void delete(Session session, Doctor doctor) {
        session.delete(doctor);
    }

    @Override
    public void saveOrUpdate(Session session, Doctor doctor) {
        DoctorRepository.super.saveOrUpdate(session, doctor);
    }

    @Override
    public Optional<Doctor> findByNc(Session session, String nationalCode) {
        return Optional.ofNullable(session.createQuery("from Doctor p where p.nationalCode = :ncode", Doctor.class)
                .setParameter("nscode", nationalCode).getSingleResult());
    }
}