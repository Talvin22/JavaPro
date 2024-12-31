package com.gmail.dzhaparov.homework31_1.dao;

import com.gmail.dzhaparov.homework31_1.entity.Library;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

public class LibraryDAO implements GenericDAO<Library, Long> {
    private final EntityManagerFactory factory;

    public LibraryDAO(EntityManagerFactory factory) {
        this.factory = factory;
    }


    @Override
    public void save(Library entity) throws IllegalArgumentException {
        if (entity == null) {

            throw new IllegalArgumentException("Invalid data");

        }
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Library> findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cant be null");
        }
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Library library = em.createQuery("SELECT l FROM Library l WHERE l.name = :name", Library.class)
                    .setParameter("name", name)
                    .getSingleResult();
            em.getTransaction().commit();
            return Optional.of(library);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Library> findById(Long id) {
        if (id == null) {
            try {
                throw new IllegalAccessException("id cant be null");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Library library = em.find(Library.class, id);
            return Optional.ofNullable(library);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Library update(Library entity) {
        if (entity == null) {
            try {
                throw new IllegalAccessException("argument cant be null");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Library updatedLibrary = em.merge(entity);
            em.getTransaction().commit();
            return updatedLibrary;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteById(Long aLong) {
        if (aLong == null) {
            try {
                throw new IllegalAccessException("id cant be null");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Library library = em.find(Library.class, aLong);
            em.remove(library);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<List<Library>> findAll() {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            List<Library> libraries = em.createQuery("SELECT l FROM Library l", Library.class).getResultList();
            em.getTransaction().commit();
            return Optional.of(libraries);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
