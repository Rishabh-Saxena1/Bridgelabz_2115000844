import java.util.Scanner;
public class toggleCases{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=sc.nextLine();// Read the string
        String toggledStr=toggleCase(str);// Toggle the case of the string
        System.out.println("Toggled string: " + toggledStr);
    }
    // Method to toggle the case of each character
    public static String toggleCase(String str){
        StringBuilder result=new StringBuilder();
        // Loop through each character in the string
        for(int i=0;i< str.length();i++){
            char ch=str.charAt(i);
            // Check if the character is uppercase
            if(Character.isUpperCase(ch)){
                // Convert it to lowercase
                result.append(Character.toLowerCase(ch));
            }
            // Check if the character is lowercase
            else if (Character.isLowerCase(ch)){
                // Convert it to uppercase
                result.append(Character.toUpperCase(ch));
            }else{
                // If it's neither, append as is (like numbers or punctuation)
                result.append(ch);
            }
        }
        return result.toString();// Return the toggled string
    }
}
