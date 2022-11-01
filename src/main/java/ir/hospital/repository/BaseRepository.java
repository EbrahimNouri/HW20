package ir.hospital.repository;

import org.hibernate.Session;

import java.util.Optional;

public interface BaseRepository<E> {
    default void save(Session session, E e){
        session.persist(e);
    }

    Optional<E> findById(Session session, Long id);

    default void update(Session session, E e){
        session.merge(e);
    }

    default void delete(Session session, E e){
        session.remove(e);
    }
    default void saveOrUpdate(Session session, E e){
        session.saveOrUpdate(e);
    }

    boolean isExist(Session session,Long id);
}
