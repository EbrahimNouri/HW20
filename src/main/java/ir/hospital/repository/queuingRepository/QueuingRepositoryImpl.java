package ir.hospital.repository.queuingRepository;

import ir.hospital.entity.Queuing;
import ir.hospital.entity.QueuingCheck;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class QueuingRepositoryImpl implements QueuingRepository {
    @Override
    public void save(Session session, Queuing queuing) {
        QueuingRepository.super.save(session, queuing);
    }

    @Override
    public Optional<Queuing> findById(Session session, Long id) {
        return Optional.ofNullable(session.find(Queuing.class, id));
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

    @Override
    public boolean checkQueuing(Session session, Queuing queuing) {
        return session.createQuery("from Queuing q where q.localDate = :day", Queuing.class)
                .setParameter("day", queuing.getLocalDate()).getResultList().stream().
                map((queuingOfList) ->
                        queuingOfList.getDoctor() == queuing.getDoctor()
                                && queuingOfList.getLocalDate().getYear() == queuing.getLocalDate().getYear()
                                && queuingOfList.getLocalDate().getDayOfYear() == queuing.getLocalDate().getDayOfYear()
                                && queuingOfList.getLocalDateType() == queuing.getLocalDateType()
                                && queuingOfList.getQueuingCheck() == QueuingCheck.RESERVED).toList().isEmpty();
    }
}
