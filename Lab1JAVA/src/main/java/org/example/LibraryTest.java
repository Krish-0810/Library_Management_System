import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        Book book = new Book("978-3-16-148410-0", "Clean Code", "Robert C. Martin", 2008);
        library.addBook(book);
        assertEquals(1, library.getAvailableBooks().size());
        assertTrue(library.getAvailableBooks().contains(book));
    }


    @Test
    void testBorrowBookUnavailable() {
        Book book = new Book("978-3-16-148410-0", "Clean Code", "Robert C. Martin", 2008);
        library.addBook(book);
        assertThrows(Exception.class, () -> {
            library.borrowBook("978-3-16-148410-0");
            library.borrowBook("978-3-16-148410-0");
        });
    }
    @Test
    void testReturnBook() throws Exception {
        Book book = new Book("978-3-16-148410-0", "Clean Code", "Robert C. Martin", 2008);
        library.addBook(book);
        library.borrowBook("978-3-16-148410-0");
        library.returnBook("978-3-16-148410-0");
        assertEquals(1, library.getAvailableBooks().size());
        assertTrue(library.getAvailableBooks().contains(book))
    }
    @Test
    void testViewAvailableBooks() {
        Book book1 = new Book("978-3-16-148410-0", "Clean Code", "Robert C. Martin", 2008);
        Book book2 = new Book("978-0-321-35668-0", "Refactoring", "Martin Fowler", 1999);
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getAvailableBooks().size());
        assertTrue(library.getAvailableBooks().contains(book1));
        assertTrue(library.getAvailableBooks().contains(book2));
    }
}