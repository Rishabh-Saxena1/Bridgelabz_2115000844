import java.util.*;
public class removeSpecificChar{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=sc.nextLine();
        System.out.println("Enter the character to remove:");
        char charToRemove=sc.next().charAt(0);

        String newStr = removeChar(str, charToRemove);
        System.out.println("New String: " + newStr );
    }

    public static String removeChar(String str, char charToRemove) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != charToRemove) {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
