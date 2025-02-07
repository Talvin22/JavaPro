package com.gmail.dzhaparov.homework38_1.service.product;

import com.gmail.dzhaparov.homework38_1.entity.Product;
import com.gmail.dzhaparov.homework38_1.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface ProductService extends BaseService<Long, Product> {
    void save(Product t);
    void delete(Product t);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Optional<Product> update(Long id, Product t);
}
