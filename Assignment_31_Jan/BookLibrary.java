import java.util.*;
class BookLibrary {
   public String ISBN;
   protected String title;
   private String author;
   public BookLibrary(String ISBN, String title, String author) {
       this.ISBN = ISBN;
       this.title = title;
       this.author = author;
   }

   public void setAuthor(String author) {
       this.author = author;
   }

   public String getAuthor() {
       return author;
   }
}

class EBook extends BookLibrary {
   public EBook(String ISBN, String title, String author) {
       super(ISBN, title, author);
   }

   public void showDetails() {
       System.out.println("ISBN: " + ISBN);
       System.out.println("Title: " + title);
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter ISBN: ");
       String ISBN = sc.nextLine();
       System.out.print("Enter Title: ");
       String title = sc.nextLine();
       System.out.print("Enter Author: ");
       String author = sc.nextLine();
       EBook ebook = new EBook(ISBN, title, author);
       ebook.showDetails();
       System.out.println("Author: " + ebook.getAuthor());
   }
}
