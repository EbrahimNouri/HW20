package ir.hospital.repository.secretaryRepository;

import ir.hospital.entity.Secretary;
import org.hibernate.Session;

public class SecretaryRepositoryImpl implements SecretaryRepository{
    @Override
    public void save(Session session, Secretary secretary) {
        SecretaryRepository.super.save(session, secretary);
    }

    @Override
    public Secretary findById(Session session, Long id) {
        return session.find(Secretary.class, id);
    }

    @Override
    public void update(Session session, Secretary secretary) {
        SecretaryRepository.super.update(session, secretary);
    }

    @Override
    public void delete(Session session, Secretary secretary) {
        SecretaryRepository.super.delete(session, secretary);
    }

    @Override
    public void saveOrUpdate(Session session, Secretary secretary) {
        SecretaryRepository.super.saveOrUpdate(session, secretary);
    }
}
