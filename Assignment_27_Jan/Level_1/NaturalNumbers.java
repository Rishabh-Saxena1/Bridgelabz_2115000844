import java.util.*;
 public class NaturalNumbers{
 	public static void main(String args[]){
     	Scanner sc=new Scanner(System.in);
     	System.out.println("Enter the number:");
     	int number=sc.nextInt();
     	int ans=calculateSum(number);
     	System.out.println(ans);
 	}
 	public static int calculateSum(int n){
    	int sum=0;
    	for(int i=1;i<=n;i++){
       	sum+=i;
    	}
    	return sum;
 	}
 }

