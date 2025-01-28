import java.util.*;
 public class QuotientReminder{
 	public static void main(String args[]){
     	Scanner sc=new Scanner(System.in);
     	System.out.println("Enter the first number:");
     	int number=sc.nextInt();
     	System.out.println("Enter the second number:");
     	int divisor=sc.nextInt();
     	int ans[]=findRemainderQuotient(number,divisor);
     	System.out.println("The quotient is "+ans[0]+" & the remainder is "+ans[1]);
 	}
 	public static int[] findRemainderQuotient(int number, int divisor){
          int ans[]=new int[2];
      	ans[0]=number/divisor;
      	ans[1]=number%divisor;
      	return ans;

 	}
 }
