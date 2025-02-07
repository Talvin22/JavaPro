package com.gmail.dzhaparov.homework38_1.repository.product;

import com.gmail.dzhaparov.homework38_1.entity.Product;
import com.gmail.dzhaparov.homework38_1.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends BaseRepository<Long, Product> {
    public void save(Product t);
    public void delete(Product t);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Optional<Product> update(Long id, Product t);
}

