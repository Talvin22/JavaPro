package com.gmail.dzhaparov.homework38_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import com.gmail.dzhaparov.homework38_1.config.AppConfig;
import com.gmail.dzhaparov.homework38_1.service.product.CartService;
import com.gmail.dzhaparov.homework38_1.repository.product.ProductRepository;
import com.gmail.dzhaparov.homework38_1.entity.Product;
import java.util.Optional;
import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        CartService cartService = context.getBean(CartService.class);
        ConsoleApp consoleApp = new ConsoleApp(productRepository, cartService);
        consoleApp.run();
    }
}

class ConsoleApp {
    private final ProductRepository productRepository;
    private final CartService cartService;

    public ConsoleApp(ProductRepository productRepository, CartService cartService) {
        this.productRepository = productRepository;
        this.cartService = cartService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Show products");
            System.out.println("2. Add product");
            System.out.println("3. Remove product");
            System.out.println("4. Show cart");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> productRepository.findAll().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Enter product ID: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    Double price = scanner.nextDouble();
                    scanner.nextLine();
                    Product product = new Product(id, name, price);
                    productRepository.save(product);
                    System.out.println("Product added successfully!");
                }
                case 3 -> {
                    System.out.print("Enter product ID to remove: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    Optional<Product> product = productRepository.findById(id);
                    product.ifPresent(p -> {
                        productRepository.delete(p);
                        cartService.removeProduct(id);
                        System.out.println("Product removed successfully!");
                    });
                }
                case 4 -> System.out.println(cartService.getCart().getItems());
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
