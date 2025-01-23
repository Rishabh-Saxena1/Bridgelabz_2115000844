import java.util.*;
 public class HarshadNum{
 public static void main(String[]args){
 Scanner sc=new Scanner(System.in);
 int num=sc.nextInt(); //integer input
 int sum=0;
 int originalnum=num;
 while(originalnum>0){
 int digit=originalnum%10;
 sum+=digit;
 originalnum/=10;
 } //accessing each digit of a number and adding to sum
 if(num%sum==0){
 System.out.println("Harshad Number");
 }else{
 System.out.println("Not a Harshad Number");
 }
 }
 }
