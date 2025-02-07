package com.gmail.dzhaparov.homework38_1.service.product;


import com.gmail.dzhaparov.homework38_1.entity.Cart;

import com.gmail.dzhaparov.homework38_1.entity.Product;
import com.gmail.dzhaparov.homework38_1.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Scope("prototype")
public class CartService {
    private final Cart cart;
    private final ProductRepository productRepository;

    public CartService(@Qualifier("productRepository") ProductRepository productRepository) {
        this.cart = new Cart();
        this.productRepository = productRepository;
    }

    public void addProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        product.ifPresent(cart::addProduct);
    }

    public void removeProduct(Long productId) {
        cart.removeProduct(productId);
    }

    public Cart getCart() {
        return cart;
    }
}