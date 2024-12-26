package com.gmail.dzhaparov.homework30_1.dao;

import com.gmail.dzhaparov.homework30_1.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.transaction.Transactional;

import java.util.List;


public class StudentDao implements GenericDao<Student, Long> {

    private final EntityManagerFactory entityManagerFactory;

    public StudentDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    @Override
    public void save(Student entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Student findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Student.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Student findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Student> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Transactional
    @Override
    public Student update(Student entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student updated = entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return updated;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Transactional
    @Override
    public boolean deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student student = findById(id);
            if (student != null) {
                entityManager.remove(student);
                entityManager.getTransaction().commit();
                return true;
            }
            entityManager.getTransaction().rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }
}