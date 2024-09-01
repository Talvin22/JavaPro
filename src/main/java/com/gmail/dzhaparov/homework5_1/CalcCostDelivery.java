package com.gmail.dzhaparov.homework5_1;


public class CalcCostDelivery extends CalcCostBase {

    private final static double deliveryPrice = 7;


    @Override
    public double calcCost(Product product) {
        return product.getQuota() * product.getPrice()
                + deliveryPrice;
    }
}