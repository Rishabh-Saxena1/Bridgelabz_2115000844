import java.util.*;
public class reverseString{
     public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=sc.next();
        char [] charArray=str.toCharArray();
        int i=0, j=str.length()-1;
        while(i<j){
           char temp=charArray[i];
           charArray[i]=charArray[j];
           charArray[j]=temp;
           i++;
           j--;
        }
        String res=new String(charArray);
        System.out.println("The reverse string is: "+res);
     }
 }
