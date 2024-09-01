import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String isbn) throws Exception {
        Optional<Book> book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn) && !b.isBorrowed())
                .findFirst();
        if (book.isPresent()) {
            book.get().borrow();
        } else {
            throw new Exception("Book not available");
        }
    }

    public void returnBook(String isbn) throws Exception {
        Optional<Book> book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn) && b.isBorrowed())
                .findFirst();
        if (book.isPresent()) {
            book.get().returnBook();
        } else {
            throw new Exception("Book not found or not borrowed");
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
