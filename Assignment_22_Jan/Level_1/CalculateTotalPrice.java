import java.util.*;
public class CalculateTotalPrice{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the unit price of an item :");
        double unitPrice = sc.nextDouble();
        System.out.print("Enter the quantity to be bought :");
        int quantity = sc.nextInt(); 
        double totalPrice = unitPrice*quantity;
        System.out.print("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is " + unitPrice);
    }
}
