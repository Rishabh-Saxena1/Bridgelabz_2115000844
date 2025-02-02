import java.util.*;
class ProductInventory {
   String productName;
   double price;
   private static int totalProducts = 0;

   public ProductInventory(String productName, double price) {
       this.productName = productName;
       this.price = price;
       totalProducts++;
   }

   public void showDetails() {
       System.out.println("Product Name: " + productName);
       System.out.println("Price: " + price);
   }

   public static void TotalProducts() {
       System.out.println("Total Products Created: " + totalProducts);
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter the number of products: ");
       int numProducts = sc.nextInt();
       sc.nextLine();

       ProductInventory[] products = new ProductInventory[numProducts];

       for (int i = 0; i < numProducts; i++) {
           System.out.print("Enter product name: ");
           String name = sc.nextLine();
           System.out.print("Enter product price: ");
           double price = sc.nextDouble();
           sc.nextLine();
           products[i] = new ProductInventory(name, price);
       }

       System.out.println("\nProduct Details:");
       for (ProductInventory product : products) {
           product.showDetails();
           System.out.println();
       }
       ProductInventory.TotalProducts();
   }
}
