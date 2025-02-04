import java.util.*;
class Book{
   static String libraryName = "Central Library";
   final String isbn;
   String title;
   String author;

   Book(String title, String author, String isbn) {
       this.title = title;
       this.author = author;
       this.isbn = isbn;
   }

   static void displayLibraryName() {
       System.out.println("Library Name: " + libraryName);
   }

   void showDetails() {
           System.out.println("Title: " + title);
           System.out.println("Author: " + author);
           System.out.println("ISBN: " + isbn);
       }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter book title: ");
       String title = sc.nextLine();
       System.out.print("Enter author: ");
       String author = sc.nextLine();
       System.out.print("Enter ISBN: ");
       String isbn = sc.nextLine();
       Book b = new Book(title, author, isbn);
       if(b instanceof Book){
        b.showDetails();
            Book.displayLibraryName();
    }
    else{
        System.out.println("Not instanceOf");
    }
    }
}
