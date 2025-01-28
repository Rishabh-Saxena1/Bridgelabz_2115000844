import java.util.*;
 public class Calendar {
 	private static final String[] MONTHS = {
     	"January", "February", "March", "April", "May", "June",
     	"July", "August", "September", "October", "November", "December"
 	};
 	private static final int[] DAYS_IN_MONTH = {
     	31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
 	};
 	public static boolean isLeapYear(int year) {
     	return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
 	}
 	public static int getDaysInMonth(int month, int year) {
     	if (month == 2 && isLeapYear(year)) {
         	return 29;
     	}
     	return DAYS_IN_MONTH[month - 1];
 	}
 	public static int getFirstDayOfMonth(int month, int year) {
     	int y0 = year - (14 - month) / 12;
     	int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
     	int m0 = month + 12 * ((14 - month) / 12) - 2;
     	return (1 + x + (31 * m0) / 12) % 7;
 	}
 	public static void displayCalendar(int month, int year) {
     	String monthName = MONTHS[month - 1];
     	int daysInMonth = getDaysInMonth(month, year);
     	int firstDay = getFirstDayOfMonth(month, year);
     	System.out.print(monthName + year);
     	System.out.println("Su Mo Tu We Th Fr Sa");
     	for (int i = 0; i < firstDay; i++) {
         	System.out.print("   ");
     	}
     	for (int day = 1; day <= daysInMonth; day++) {
         	System.out.printf("%3d", day);
         	if ((day + firstDay) % 7 == 0) {
             	System.out.println();
         	}
     	}
 	    System.out.print("");
 	}

 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
     	System.out.print("Enter month (1-12): ");
     	int month = sc.nextInt();
     	System.out.print("Enter year: ");
     	int year = sc.nextInt();
     	if (month < 1 || month > 12) {
         	System.out.println("Please enter a value between 1 and 12.");
     	}
 	else {
         	displayCalendar(month, year);
     	}
 	}
 }
