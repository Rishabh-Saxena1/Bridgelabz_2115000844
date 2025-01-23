import java.util.*;
public class IntOperation{
     public static void main(String args[]){
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter the first number");
           int a = sc.nextInt();
           System.out.println("Enter the second number");
           int b = sc.nextInt();
           System.out.println("Enter the third number");
           int c = sc.nextInt();
           int result1 = a + b *c;
           int result2 = a * b + c;
           int result3 = c + a / b;
           int result4 = a % b + c;
           System.out.println("The result of above operations are"+ result1+","+result2+","+result3+","+result4);
     }
}
