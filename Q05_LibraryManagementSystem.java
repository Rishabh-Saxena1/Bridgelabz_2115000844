import java.util.Scanner;

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean available;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public abstract int getLoanDuration();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // Book loan duration is 14 days
    }

    @Override
    public void reserveItem() {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // Magazine loan duration is 7 days
    }

    @Override
    public void reserveItem() {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // DVD loan duration is 5 days
    }

    @Override
    public void reserveItem() {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class Q05_LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LibraryItem[] libraryItems = {
            new Book("B001", "Java Programming", "John Doe"),
            new Magazine("M001", "Tech Today", "Jane Smith"),
            new DVD("D001", "Inception", "Christopher Nolan")
        };

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. View Item Details");
            System.out.println("2. Reserve Item");
            System.out.println("3. Check Item Availability");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            if (choice == 1) {
                for (LibraryItem item : libraryItems) {
                    item.getItemDetails();
                    System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
                    System.out.println();
                }
            } else if (choice == 2) {
                System.out.print("Enter Item ID to reserve: ");
                String itemId = scanner.nextLine();
                boolean found = false;
                for (LibraryItem item : libraryItems) {
                    if (item.getItemId().equals(itemId)) {
                        found = true;
                        if (item instanceof Reservable) {
                            ((Reservable) item).reserveItem();
                        } else {
                            System.out.println("This item cannot be reserved.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Item not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter Item ID to check availability: ");
                String itemId = scanner.nextLine();
                boolean found = false;
                for (LibraryItem item : libraryItems) {
                    if (item.getItemId().equals(itemId)) {
                        found = true;
                        if (item instanceof Reservable) {
                            boolean available = ((Reservable) item).checkAvailability();
                            if (available) {
                                System.out.println("Item is available.");
                            } else {
                                System.out.println("Item is not available.");
                            }
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Item not found.");
                }
            } else if (choice == 4) {
                System.out.println("Exiting the system.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
