import java.util.*;
public class removeDuplicates{
   public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String result=removeDup(str);
        System.out.println("String after removing duplicates: " + result);
    }
    // Method to remove duplicate characters
    public static String removeDup(String str){
        LinkedHashSet<Character> set=new LinkedHashSet<>();//Maintains insertion order
        StringBuilder sb=new StringBuilder();
        for(char ch:str.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
