package com.gmail.dzhaparov.homework32_1.entity;


import jakarta.persistence.*;



@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(nullable = false)
    private String name;

    public Order() {
    }

    public Order(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return number + " | " + name;
    }
}