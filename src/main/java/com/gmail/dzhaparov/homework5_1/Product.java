package com.gmail.dzhaparov.homework5_1;

public class Product {

    private String name;
    private int quota;
    private double price;


    public Product(String name, int quota, double price) {
        this.name = name;
        this.quota = quota;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuota() {
        return quota;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + name +
                ", quota is " + quota + " " +
                Constants.MEASURE +
                ", price is " + Constants.CURRENCY +
                " " + price + ".";
    }


}
