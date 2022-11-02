package ir.hospital.repository.queuingRepository;

import ir.hospital.entity.Queuing;
import ir.hospital.repository.BaseRepository;
import org.hibernate.Session;

import java.util.List;


public interface QueuingRepository extends BaseRepository<Queuing> {
    boolean checkQueuing(Session session, Queuing queuing);

    List<Queuing> getAllAfterNow(Session session);
}
