import java.util.*;
 public class SpringSeason {
 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);

     	// Input the month and day from the user
     	System.out.print("Enter the month: ");
     	int month = sc.nextInt();
     	System.out.print("Enter the day: ");
     	int day = sc.nextInt();
     	if (isSpringSeason(month, day)) {
         	System.out.println("It's a Spring Season.");
     	}
 	else {
 	        System.out.println("Not a Spring Season.");
     	}
 	}

 	// Method to check if the date falls in the spring season
 	public static boolean isSpringSeason(int month, int day) {
     	// Check for March
     	if (month == 3 && day >= 20 && day <= 31) {
         	return true;
     	}
     	// Check for April
     	else if (month == 4 && day >= 1 && day <= 30) {
         	return true;
     	}
     	// Check for May
     	else if (month == 5 && day >= 1 && day <= 31) {
         	return true;
 	}
     	// Check for June
     	else if (month == 6 && day >= 1 && day <= 20) {
         	return true;
     	}

     	// If not in spring range, return false
     	return false;
 	}
 }
