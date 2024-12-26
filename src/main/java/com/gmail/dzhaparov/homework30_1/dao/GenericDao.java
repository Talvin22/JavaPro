package com.gmail.dzhaparov.homework30_1.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID> {
    void save(T entity);
    T findByEmail(String email);

    T findById(ID id);

    T update(T entity);

    boolean deleteById(ID id);

    List<T> findAll();
}