package com.gmail.dzhaparov.homework38_1.controller;


import com.gmail.dzhaparov.homework38_1.entity.Cart;
import com.gmail.dzhaparov.homework38_1.service.product.CartService;
import org.springframework.stereotype.Component;

@Component("cartController")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    public String addProduct(Long id) {
        cartService.addProduct(id);
        return "Product added to cart!";
    }


    public String removeProduct(Long id) {
        cartService.removeProduct(id);
        return "Product removed from cart!";
    }


    public Cart viewCart() {
        return cartService.getCart();
    }
}
