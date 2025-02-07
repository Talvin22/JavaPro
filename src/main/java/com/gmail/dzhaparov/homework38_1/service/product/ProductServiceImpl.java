package com.gmail.dzhaparov.homework38_1.service.product;

import com.gmail.dzhaparov.homework38_1.entity.Product;
import com.gmail.dzhaparov.homework38_1.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(@Qualifier("productRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> update(Long id, Product t) {
        return productRepository.update(id, t);
    }
}
