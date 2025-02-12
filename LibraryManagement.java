class Book {
    String title, author, genre;
    int bookID;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class LibraryManagement {
    Book head, tail;
    int count;

    public void addBook(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else if (position == 0) {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        } else if (position >= count) {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        } else {
            Book temp = head;
            for (int i = 0; i < position - 1; i++) temp = temp.next;
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
        }
        count++;
    }
    public void removeBook(int bookID) {
        Book temp = head;
        while (temp != null && temp.bookID != bookID) temp = temp.next;
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        count--;
    }
    public Book searchBook(String key) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(key) || temp.author.equalsIgnoreCase(key)) return temp;
            temp = temp.next;
        }
        return null;
    }
    public void updateAvailability(int bookID, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }
    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + "," + temp.author + "," + temp.genre + "," + temp.bookID + "," + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }
    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + "," + temp.author + "," + temp.genre + "," + temp.bookID + "," + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }
    public int countBooks() {
        return count;
    }
 
    public static void main(String[] args) {
        LibraryManagement l = new LibraryManagement();
        l.addBook("Book A", "Author X", "Fiction", 101, true, 0);
        l.addBook("Book B", "Author Y", "Non-Fiction", 102, true, 1);
        l.addBook("Book C", "Author Z", "Sci-Fi", 103, false, 2);
       
        l.displayForward();
        System.out.println("No. of Books: " + l.countBooks());
       
        l.removeBook(102);
        l.displayForward();
        Book found = l.searchBook("Book A");
        if (found != null) System.out.println("Found: " + found.title);
       
        l.updateAvailability(101, false);
        l.displayReverse();
       
        System.out.println("Total Books: " + l.countBooks());
    }
}
