package com.gmail.dzhaparov.homework38_1.repository;

import com.gmail.dzhaparov.homework38_1.entity.Product;

public interface ProductRepository extends BaseRepository<Product> {
    public String save(Product t);
    public String delete(Product t);

}
