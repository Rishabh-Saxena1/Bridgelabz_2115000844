import java.util.*;
class Product {
   static double discount = 10.0;
   final int productID;
   String productName;
   double price;
   int quantity;

   Product(int productID, String productName, double price, int quantity) {
       this.productID = productID;
       this.productName = productName;
       this.price = price;
       this.quantity = quantity;
   }

   static void updateDiscount(double newDiscount) {
       discount = newDiscount;
   }

   void showDetails() {
           System.out.println("Product ID: " + productID);
           System.out.println("Product Name: " + productName);
           System.out.println("Price: " + price);
           System.out.println("Quantity: " + quantity);
           System.out.println("Discount: " + discount + "%");
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter product ID: ");
       int productID = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter product name: ");
       String productName = sc.nextLine();
       System.out.print("Enter product price: ");
       double price = sc.nextDouble();
       System.out.print("Enter quantity: ");
       int quantity = sc.nextInt();
       Product P = new Product(productID, productName, price, quantity);
       if(P instanceof Product){
            P.showDetails();
       }
       else{
        System.out.println("Not instance of");
       }
    }
}
