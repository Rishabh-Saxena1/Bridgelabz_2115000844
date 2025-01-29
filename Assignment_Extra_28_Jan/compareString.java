import java.util.*;
public class compareString{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String str1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        String str2 = sc.nextLine();
        int res=compareLexicographically(str1, str2);
        if(res<0){
            System.out.println(str1 + " comes before " + str2 + " in lexicographical order.");
        }else if(res>0){
            System.out.println(str1 + " comes after " + str2 + " in lexicographical order.");
        }else{
            System.out.println(str1 + " is equal to " + str2 + " lexicographically.");
        }
    }
    public static int compareLexicographically(String str1, String str2) {
        int length1=str1.length();
        int length2=str2.length();
        int minLength=Math.min(length1,length2);
        for(int i=0;i<minLength;i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                return str1.charAt(i)-str2.charAt(i);
            }
        }
        return length1-length2;
    }
}
