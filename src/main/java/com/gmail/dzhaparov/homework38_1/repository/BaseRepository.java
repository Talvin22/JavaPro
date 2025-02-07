package com.gmail.dzhaparov.homework38_1.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<I,T> {
     void save(T t);
     void delete(T t);
     List<T> findAll();
     Optional<T> findById(Long id);
     Optional<T> update(I id, T t);
}
