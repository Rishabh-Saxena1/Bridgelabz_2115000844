import java.util.*;
public class Armstrong{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
int num=sc.nextInt();
int sum=0;
int originalnum=num;
while(originalnum!=0){
int rem=originalnum%10;
sum+=Math.pow(rem,3);
originalnum=originalnum/10;
}
if(sum==num){
System.out.println(num+" is a Armstrong Number");
}else{
System.out.println(num+" is not a Armstrong Number");
}
}
}
