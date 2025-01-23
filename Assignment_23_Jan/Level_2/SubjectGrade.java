import java.util.*;
public class SubjectGrade{
      public static void main(String args[]){
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter marks of Physics:");
           int marks1=sc.nextInt();
           System.out.println("Enter marks of Chemistry");
           int marks2=sc.nextInt();
           System.out.println("Enter marks of Maths");
           int marks3=sc.nextInt();
           int percent=((marks1 + marks2 + marks3)/3)*100;
           if(percent>=80){
                System.out.println("Level 4 - Above agency-normalized standards");
           }
          else if(percent>=70 && percent<=79){
                System.out.println("Level 3 - At agency normalized standards");
           }
          else if(percent>=60 && percent<=69){
                System.out.println("Level 2 - Below, but approaching normalized standards");
           }
          else if(percent>=50 && percent<=59){
                System.out.println("Level 1 - well Below agency normalized standards");
           }
          else if(percent>=40 && percent<=49){
                 System.out.println("Level 1- - too Below agency normalized standards");
           }
          else{
                 System.out.println("Remedial Standards");
           }
      }
}
