import java.util.*;
public class DivideChocolates{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Taking user inputs for the number of chocolates and children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates=sc.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren=sc.nextInt();
        // Calculating the number of chocolates each child gets and the remaining chocolates
        int chocolatesPerChild=numberOfChocolates/numberOfChildren;
        int remainingChocolates=numberOfChocolates%numberOfChildren;
        // Displaying the result
        System.out.println("The number of chocolates each child gets is "+ chocolatesPerChild+" and the number of remaining chocolates are "+remainingChocolates+ ".");
    }
}
