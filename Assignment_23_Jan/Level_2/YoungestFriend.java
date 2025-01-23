import java.util.*;
public class YoungestFriend{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
            System.out.print("Enter Amar's age: ");
            int ageAmar = sc.nextInt();
            System.out.print("Enter Amar's height: ");
            int heightAmar = sc.nextInt();

            System.out.print("Enter Akbar's age: ");
            int ageAkbar = sc.nextInt();
            System.out.print("Enter Akbar's height: ");
            int heightAkbar = sc.nextInt();

            System.out.print("Enter Anthony's age: ");
            int ageAnthony = sc.nextInt();
            System.out.print("Enter Anthony's height: ");
            int heightAnthony = sc.nextInt();

        // Youngest Friend
            int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
            String youngestFriend;
            if (youngestAge == ageAmar) {
                    youngestFriend = "Amar";
            }
        else if (youngestAge == ageAkbar) {
                    youngestFriend = "Akbar";
            }
        else {
                    youngestFriend = "Anthony";
            }

            // Tallest friend
            int tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
            String tallestFriend;
            if (tallestHeight == heightAmar) {
                    tallestFriend = "Amar";
            }
        else if (tallestHeight == heightAkbar) {
                    tallestFriend = "Akbar";
            }
        else {
                    tallestFriend = "Anthony";
            }
        System.out.println("The youngest friend among them is: " + youngestFriend + " with age " + youngestAge);
        System.out.println("The tallest friend among them is: " + tallestFriend + " with height " + tallestHeight + " cm");
}}
