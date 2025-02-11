package com.gmail.dzhaparov.homework39_1.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T, S> {
    boolean create(S request);
    Optional<List<T>> getAll();
    Optional<T> getById(Long id);
    boolean updateById(Long id, S request);
    boolean deleteById(Long id);

}
