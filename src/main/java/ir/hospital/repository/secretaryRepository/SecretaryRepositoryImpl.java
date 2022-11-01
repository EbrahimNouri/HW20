package ir.hospital.repository.secretaryRepository;

import ir.hospital.entity.Secretary;
import org.hibernate.Session;

import java.util.Optional;

public class SecretaryRepositoryImpl implements SecretaryRepository{
    @Override
    public void save(Session session, Secretary secretary) {
        SecretaryRepository.super.save(session, secretary);
    }

    @Override
    public Optional<Secretary> findById(Session session, Long id) {
        return Optional.ofNullable(session.find(Secretary.class, id));
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

    @Override
    public Optional<Secretary> findByNc(Session session, String nationalCode) {
        return Optional.ofNullable(session.createQuery("from Secretary p where p.nationalCode = :ncode", Secretary.class)
                .setParameter("nscode", nationalCode).getSingleResult());
    }

    @Override
    public boolean isExist(Session session, Long id) {
        return session.find(Secretary.class, id) != null;
    }
}
