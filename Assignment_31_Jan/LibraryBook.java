import java.util.*;
public class LibraryBook{
       String title;
       String author;
       int price;
       int availability;
       public LibraryBook(String title, String author, int price, int availability){
             this.title=title;
             this.author=author;
             this.price=price;
             this.availability=availability;
       }
       public void borrowBook(){
             System.out.println("Book to be borrowed is "+title);
             System.out.println("Book's author is "+author);
             System.out.println("Book's price is "+price);
             System.out.println("No of book's available are "+availability);
       }
       public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter book's title:");
            String title=sc.nextLine();
            System.out.println("Enter book's author:");
            String author=sc.nextLine();
            System.out.println("Enter book's price:");
            int price=sc.nextInt();
            System.out.println("Enter available number of book's :");
            int availability=sc.nextInt();
            LibraryBook LB1=new LibraryBook(title,author,price,availability);
            LB1.borrowBook();
       }
}
