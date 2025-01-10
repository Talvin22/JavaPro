package com.gmail.dzhaparov.homework32_1;

import com.gmail.dzhaparov.homework32_1.dao.OrderDao;
import com.gmail.dzhaparov.homework32_1.dao.OrderDaoImpl;
import com.gmail.dzhaparov.homework32_1.entity.CoffeeOrderBoard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hillel-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        OrderDao orderDao = new OrderDaoImpl(entityManager);
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard(orderDao);

        orderBoard.add("Alen");
        orderBoard.add("Yoda");
        orderBoard.add("Obi-van");
        orderBoard.add("John Snow");

        orderBoard.draw();

        orderBoard.deliver();
        orderBoard.draw();

        orderBoard.deliver(3);
        orderBoard.draw();

        orderBoard.deliver(100); // This will trigger an error log

        entityManager.close();
        entityManagerFactory.close();
    }
}