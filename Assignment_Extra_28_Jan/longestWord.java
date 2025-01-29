import java.util.*;
public class longestWord{
   public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the sentence:");
       String str=sc.nextLine();
       String[] words=str.split("\\s+");
       String longest="";
       for(String word:words){
          if(word.length()>longest.length()){
             longest=word;
          }
       }
       System.out.println("Longest word is: "+longest);
   }
}
