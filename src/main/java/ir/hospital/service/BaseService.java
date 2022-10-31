package ir.hospital.service;


public interface BaseService <E>{
     void save(E e);
     void saveOrUpdate(E e);
     void update(E e);
     E findById(Long id);
     void delete(E e);
}
