package com.gmail.dzhaparov.homework31_1;

import com.gmail.dzhaparov.homework31_1.dao.LibraryDAO;
import com.gmail.dzhaparov.homework31_1.entity.Book;
import com.gmail.dzhaparov.homework31_1.entity.Library;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryTest {
    private static EntityManagerFactory emf;
    private static LibraryDAO libraryDAO;


    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hillel-persistence-unit");
        libraryDAO = new LibraryDAO(emf);
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        libraryDAO = null;
    }

    @Test
    @Order(1)
    public void addLibraryToDatabase() throws IllegalArgumentException {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Грокаем алгоритми", "32dw34", "Mark Lutz");

        Library library = new Library(books, "Wall Str. 21", "Hillel Library");
        library.addBook(book);
        libraryDAO.save(library);
        Assertions.assertArrayEquals(library.getBooks().toArray(), books.toArray());

    }

    @Test
    @Order(2)
    public void addNullLibraryToDatabase() throws IllegalArgumentException {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> libraryDAO.save(null));
        Assertions.assertEquals(illegalArgumentException.getMessage(), "Invalid data");
    }


    @Test
    @Order(3)
    void testFindAll() {
        Optional<List<Library>> libraries = libraryDAO.findAll();
        Assertions.assertTrue(libraries.isPresent());
        Assertions.assertFalse(libraries.get().isEmpty());
    }
    @Test
    @Order(4)
    void testUpdate() {
        Optional<Library> library = libraryDAO.findByName("Hillel Library");
        assertTrue(library.isPresent());

        Library updatedLibrary = library.get();
        updatedLibrary.setAddress("Neue Str. 20, 58135 Hagen");

        Assertions.assertDoesNotThrow(() -> libraryDAO.update(updatedLibrary));

        Optional<Library> result = libraryDAO.findByName("Hillel Library");
        assertTrue(result.isPresent());
        Assertions.assertEquals("Neue Str. 20, 58135 Hagen", result.get().getAddress());
    }

    @Test
    @Order(5)
    void testDeleteById() {
        Optional<Library> library = libraryDAO.findByName("Hillel Library");
        assertTrue(library.isPresent());

        Long id = library.get().getId();
        Assertions.assertDoesNotThrow(() -> libraryDAO.deleteById(id));

        Optional<Library> deletedLibrary = libraryDAO.findById(id);
        assertTrue(deletedLibrary.isEmpty());
    }


}
