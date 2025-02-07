package com.gmail.dzhaparov.homework38_1.repository.product;

import com.gmail.dzhaparov.homework38_1.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("productRepository")
public class ProductRepositoryImpl implements ProductRepository {
    private final static List<Product> products = new ArrayList<Product>();


    @Override
    public void save(Product t) {
        products.add(t);
    }

    @Override
    public void delete(Product t) {
        products.remove(t);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Product> update(Long id, Product t) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(t.getName());
                p.setPrice(t.getPrice());
                return Optional.of(p);
            }
        }
        return Optional.empty();

    }
}
