package com.gmail.dzhaparov.homework39_1.service;

import java.util.List;

public interface BaseService<T, S> {
    T create(S request);
    List<T> readAll();
    T getById(Long id);
    T updateById(Long id, S request);
    boolean deleteById(Long id);


}
