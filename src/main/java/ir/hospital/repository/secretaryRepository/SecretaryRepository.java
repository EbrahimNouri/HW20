package ir.hospital.repository.secretaryRepository;

import ir.hospital.entity.Patient;
import ir.hospital.entity.Secretary;
import ir.hospital.repository.BaseRepository;
import org.hibernate.Session;

import java.util.Optional;

public interface SecretaryRepository extends BaseRepository<Secretary> {
    Optional<Secretary> findByNc(Session session, String nationalCode);

}
