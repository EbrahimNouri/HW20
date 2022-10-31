package ir.hospital.service.queuingService;

import ir.hospital.entity.Queuing;
import ir.hospital.service.BaseService;

import java.util.List;

public interface QueuingService extends BaseService<Queuing> {
    boolean checkQueuing(Queuing queuing);
}
