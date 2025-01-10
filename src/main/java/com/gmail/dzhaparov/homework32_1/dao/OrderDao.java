package com.gmail.dzhaparov.homework32_1.dao;

import com.gmail.dzhaparov.homework32_1.entity.Order;

import java.util.List;

public interface OrderDao {
    void add(Order order);
    Order deliver();
    Order deliver(int orderNumber);
    List<Order> getAllOrders();
}