import java.util.ArrayList;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayLibraryBooks() {
        System.out.println("\nLibrary: " + name);
        for (Book book : books) {
            book.displayBook();
        }
    }
}

public class Q1_Library {
    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki");
        Book book3 = new Book("1984", "George Orwell");

        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");

        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2);
        library2.addBook(book3);

        library1.displayLibraryBooks();
        library2.displayLibraryBooks();
    }
}
