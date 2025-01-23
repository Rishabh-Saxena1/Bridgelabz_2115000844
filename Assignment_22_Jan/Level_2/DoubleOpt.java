import java.util.*;
public class DoubleOpt{
     public static void main(String args[]){
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter the first number");
           double a = sc.nextDouble();
           System.out.println("Enter the second number");
           double b = sc.nextDouble();
           System.out.println("Enter the third number");
           double c = sc.nextDouble();
           double result1 = a + b *c;
           double result2 = a * b + c;
           double result3 = c + a / b;
           double result4 = a % b + c;
           System.out.println("The result of above operations are"+ result1+","+result2+","+result3+","+result4);
     }
}
