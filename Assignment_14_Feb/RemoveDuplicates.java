import java.util.*;
public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> check = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!check.contains(c)) {
                sb.append(c);
                check.add(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        sc.close();
        System.out.println("String with duplicates: " + str);
        String newStr = removeDuplicates(str);
        System.out.println("String without duplicates: " + newStr);
    }
}
