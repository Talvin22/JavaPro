package com.gmail.dzhaparov.homework38_1.repository;

public interface BaseRepository<T> {
    public String save(T t);
    public String delete(T t);
}
