import java.util.*;
public class ReverseString {
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Original String: " + str);
        String reversedStr = reverseString(str);
        System.out.println("Reversed string: " + reversedStr);
    }
}
