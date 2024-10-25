package com.gmail.dzhaparov.homework17_1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        Map<String, Double> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("Середня ціна по категоріям: " + result);


        Map<String, List<String>> groupedCategories = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())));

        System.out.println("Резульатат групування продуктів за категорією: " + groupedCategories);


        String categoryWithHighestAveragePrice = result.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Не знайдено");

        System.out.println("Категорія з найвищою середньою ціною: " + categoryWithHighestAveragePrice);
    }


}
