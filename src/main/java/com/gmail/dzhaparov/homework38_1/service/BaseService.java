package com.gmail.dzhaparov.homework38_1.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<I, T> {
    void save(T t);
    void delete(T t);

}
