package com.gmail.dzhaparov.homework31_1.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String address;
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Book> books;

    public Library(List<Book> books, String address, String name) {
        this.books = books;
        this.address = address;
        this.name = name;
    }
    public Library() {}

    public void addBook(Book book) {
        try {
            books.add(book);
            book.setLibrary(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean removeBook(Book book) {
        try {
            books.remove(book);
            book.setLibrary(null);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public List<Book> getBooks() {
        return books;
    }

    public int getBookCount() {
        return books.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", books=" + books +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
