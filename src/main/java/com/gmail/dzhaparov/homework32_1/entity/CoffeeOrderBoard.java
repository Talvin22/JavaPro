package com.gmail.dzhaparov.homework32_1.entity;


import com.gmail.dzhaparov.homework32_1.dao.OrderDao;
import org.apache.log4j.Logger;


public class CoffeeOrderBoard {
    private static final Logger logger = Logger.getLogger(CoffeeOrderBoard.class);
    private final OrderDao orderDao;

    public CoffeeOrderBoard(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void add(String name) {
        Order order = new Order(name);
        orderDao.add(order);
    }

    public void deliver() {
        orderDao.deliver();
    }

    public void deliver(int orderNumber) {
        orderDao.deliver(orderNumber);
    }

    public void draw() {
        logger.info("Drawing the current state of the order queue:");
        System.out.println("Num | Name");
        for (Order order : orderDao.getAllOrders()) {
            System.out.println(order);
        }
    }
}
