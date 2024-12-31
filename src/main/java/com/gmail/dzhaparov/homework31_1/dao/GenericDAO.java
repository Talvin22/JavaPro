package com.gmail.dzhaparov.homework31_1.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    void save(T entity) throws IllegalAccessException;
    Optional<T> findById(Long id);

    Optional<T> findByName(String name);

    T update(T entity);

    boolean deleteById(ID id);

    Optional<List<T>> findAll();
}
