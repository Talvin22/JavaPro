package com.gmail.dzhaparov.homework5_1;


public class CalcCostBase {


    public double calcCost(Product product) {
        return product.getQuota() * product.getPrice();
    }
}