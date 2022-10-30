package ir.hospital.repository.doctorRepository;

import ir.hospital.entity.Doctor;
import org.hibernate.Session;

public class DoctorRepositoryImpl implements DoctorRepository {
    @Override
    public void save(Session session, Doctor doctor) {
        session.save(doctor);
    }

    @Override
    public Doctor findById(Session session, Long id) {
        return session.find(Doctor.class, id);
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
}
