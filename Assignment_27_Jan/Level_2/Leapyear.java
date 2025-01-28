import java.util.*;
 public class Leapyear{
 public static boolean isLeap(int Y){
 if(Y>=1582){
 return (Y%4 == 0 && Y%100!= 0) || (Y%400 == 0);
 }
 return false;
 }
 public static void main(String[]args){
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter the Year: ");
 int Y=sc.nextInt();
 if (Y<1582){
 System.out.println("The LeapYear program only works for year >= 1582.");
 } else if (isLeap(Y)) {
 System.out.println("The year " +Y+ " is a Leap Year.");
 }else{
 System.out.println("The year " +Y+ " is not a Leap Year.");
 }
 }
 }
