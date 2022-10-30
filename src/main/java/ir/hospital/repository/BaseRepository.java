package ir.hospital.repository;

import org.hibernate.Session;

public interface BaseRepository<E> {
    default void save(Session session, E e){
        session.save(e);
    }

    E findById(Session session, Long id);

    default void update(Session session, E e){
        session.update(e);
    }

    default void delete(Session session, E e){
        session.delete(e);
    }
    default void saveOrUpdate(Session session, E e){
        session.merge(e);
    }
}
