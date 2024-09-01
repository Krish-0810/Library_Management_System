import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getUserChoice();
            handleUserChoice(choice);
        }
    }

    private static void printMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. View Available Books");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                viewAvailableBooks();
                break;
            case 5:
                System.out.println("Exiting the system.");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = Integer.parseInt(scanner.nextLine());

        Book book = new Book(isbn, title, author, year);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void borrowBook() {
        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();
        try {
            library.borrowBook(isbn);
            System.out.println("Book borrowed successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.print("Enter ISBN of the book to return: ");
        String isbn = scanner.nextLine();
        try {
            library.returnBook(isbn);
            System.out.println("Book returned successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewAvailableBooks() {
        List<Book> availableBooks = library.getAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Available books:");
            for (Book book : availableBooks) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
            }
        }
    }
}
