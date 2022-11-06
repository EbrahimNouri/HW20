package ir.hospital.repository.queuingRepository;

import ir.hospital.entity.Queuing;
import ir.hospital.entity.QueuingCheck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class QueuingRepositoryImpl implements QueuingRepository {

    private static final Logger LOGGER = LogManager.getLogger(QueuingRepositoryImpl.class);

    @Override
    public void save(Session session, Queuing queuing) {
        LOGGER.debug("Queuing repo save run {}", queuing);
        QueuingRepository.super.save(session, queuing);
    }

    @Override
    public Optional<Queuing> findById(Session session, Long id) {
        LOGGER.debug("Queuing repo find by id {}", id);
        return Optional.ofNullable(session.find(Queuing.class, id));
    }

    @Override
    public void update(Session session, Queuing queuing) {
        LOGGER.debug("Queuing repo update {}", queuing);
        QueuingRepository.super.update(session, queuing);
    }

    @Override
    public void delete(Session session, Queuing queuing) {
        LOGGER.debug("Queuing repo delete {}", queuing);
        QueuingRepository.super.delete(session, queuing);
    }

    @Override
    public void saveOrUpdate(Session session, Queuing queuing) {
        LOGGER.debug("Queuing repo save or update {}", queuing);
        QueuingRepository.super.saveOrUpdate(session, queuing);
    }

    @Override
    public boolean checkQueuing(Session session, Queuing queuing) {
        LOGGER.debug("Queuing repo check queuing {}", queuing);
        return session.createQuery("from Queuing q where q.localDate = :day", Queuing.class)
                .setParameter("day", queuing.getLocalDate()).getResultList().stream().
                map((queuingOfList) ->
                        queuingOfList.getDoctor() == queuing.getDoctor()
                                && queuingOfList.getLocalDate().getYear() == queuing.getLocalDate().getYear()
                                && queuingOfList.getLocalDate().getDayOfYear() == queuing.getLocalDate().getDayOfYear()
                                && queuingOfList.getLocalDateType() == queuing.getLocalDateType()
                                && queuingOfList.getQueuingCheck() == QueuingCheck.RESERVED).toList().isEmpty();
    }

    @Override
    public List<Queuing> getAllAfterNow(Session session) {
        LOGGER.debug("Queuing repo get all after now run");
        return session.createQuery("from Queuing ", Queuing.class).stream()
                .filter((q) -> q.getLocalDate().isAfter(LocalDate.now())).toList();
    }

    @Override
    public boolean isExist(Session session, Long id) {
        LOGGER.debug("Queuing repo is exist {}", id);
        return session.find(Queuing.class, id) != null;
    }
}
