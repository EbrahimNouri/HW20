package ir.hospital.repository.queuingRepository;

import ir.hospital.entity.Queuing;
import org.hibernate.Session;

public class QueuingRepositoryImpl implements QueuingRepository{
    @Override
    public void save(Session session, Queuing queuing) {
        QueuingRepository.super.save(session, queuing);
    }

    @Override
    public Queuing findById(Session session, Long id) {
        return session.find(Queuing.class, id);
    }

    @Override
    public void update(Session session, Queuing queuing) {
        QueuingRepository.super.update(session, queuing);
    }

    @Override
    public void delete(Session session, Queuing queuing) {
        QueuingRepository.super.delete(session, queuing);
    }

    @Override
    public void saveOrUpdate(Session session, Queuing queuing) {
        QueuingRepository.super.saveOrUpdate(session, queuing);
    }
}
