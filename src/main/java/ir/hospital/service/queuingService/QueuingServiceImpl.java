package ir.hospital.service.queuingService;

import ir.hospital.entity.Queuing;
import ir.hospital.repository.queuingRepository.QueuingRepositoryImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class QueuingServiceImpl implements QueuingService {

    private static final Logger LOGGER = LogManager.getLogger(QueuingService.class);

    QueuingRepositoryImpl QUEUING_REPOSITORY = ApplicationContext.getQUEUING_REPOSITORY();

    @Override
    public void save(Queuing queuing) {
        if (checkQueuing(queuing)) {

            saveExtracted(queuing);
        } LOGGER.warn("{} time is not available ", queuing);
    }


    @Override
    public void saveOrUpdate(Queuing queuing) {
        if (queuing.getId() == null) {
            if (checkQueuing(queuing))
                saveExtracted(queuing);
        } else {
            updateExtracted(queuing);
        }
    }


    @Override
    public void update(Queuing queuing) {
        updateExtracted(queuing);
    }

    @Override
    public Queuing findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("find by id {}", id);
                return QUEUING_REPOSITORY.findById(session, id).orElseThrow();
            } catch (Exception e) {
                LOGGER.error("error find by id {} ", id, e);
                return null;
            }
        }
    }

    @Override
    public void delete(Queuing queuing) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                QUEUING_REPOSITORY.delete(session, queuing);
                session.getTransaction().commit();
                LOGGER.debug("delete {} ", queuing);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("error delete {} ", queuing, e);
            }
        }
    }

    @Override
    public boolean checkQueuing(Queuing queuing) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("check queuing {} ", queuing);
                return QUEUING_REPOSITORY.checkQueuing(session, queuing);
            } catch (Exception e) {
                LOGGER.error("error check queuing {} ", queuing, e);
                return false;
            }
        }
    }

    private void updateExtracted(Queuing queuing) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                QUEUING_REPOSITORY.update(session, queuing);
                session.getTransaction().commit();
                LOGGER.debug("update {} ", queuing);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("error update {} ", queuing, e);
            }
        }
    }

    private void saveExtracted(Queuing queuing) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                QUEUING_REPOSITORY.save(session, queuing);
                session.getTransaction().commit();
                LOGGER.debug("save {} ", queuing);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("error save {} ", queuing, e);
            }
        }
    }

    @Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("is exist {} ", id);
            return QUEUING_REPOSITORY.isExist(session, id);
            }catch (Exception e){
                LOGGER.error("error is exist {} ", id, e);
                return false;
            }
        }
    }
}
