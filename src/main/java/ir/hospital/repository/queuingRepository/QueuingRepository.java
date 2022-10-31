package ir.hospital.repository.queuingRepository;

import ir.hospital.entity.Queuing;
import ir.hospital.repository.BaseRepository;
import org.hibernate.Session;


public interface QueuingRepository extends BaseRepository<Queuing> {
    boolean checkQueuing(Session session, Queuing queuing);
}
