package com.gmail.dzhaparov.homework32_1.dao;

import com.gmail.dzhaparov.homework32_1.entity.Order;
import jakarta.persistence.EntityManager;
import org.apache.log4j.Logger;


import java.util.List;


public class OrderDaoImpl implements OrderDao {

    private static final Logger logger = Logger.getLogger(OrderDaoImpl.class);
    private final EntityManager entityManager;

    public OrderDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Order order) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(order);
            entityManager.getTransaction().commit();
            logger.info("Order added: {} " + order);
        } catch (Exception e) {
            logger.error("Failed to add order: {} " +  e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Order deliver() {
        try {
            entityManager.getTransaction().begin();
            List<Order> orders = entityManager.createQuery("FROM Order", Order.class).getResultList();
            if (orders.isEmpty()) {
                logger.warn("Attempted to deliver an order, but the queue is empty.");
                entityManager.getTransaction().commit();
                return null;
            }
            Order order = orders.getFirst();
            entityManager.remove(order);
            entityManager.getTransaction().commit();
            logger.info("Order delivered: {} " + order);
            return order;
        } catch (Exception e) {
            logger.error("Failed to deliver order: {} " + e.getMessage());
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Order deliver(int orderNumber) {
        try {
            entityManager.getTransaction().begin();
            Order order = entityManager.find(Order.class, orderNumber);
            if (order != null) {
                entityManager.remove(order);
                entityManager.getTransaction().commit();
                logger.info("Order delivered by number: {} "+ order);
                return order;
            } else {
                logger.error("Order with number {} not found. " + orderNumber);
                entityManager.getTransaction().commit();
                return null;
            }
        } catch (Exception e) {
            logger.error("Failed to deliver order by number: {} " + e.getMessage());
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return entityManager.createQuery("FROM Order", Order.class).getResultList();
    }
}
