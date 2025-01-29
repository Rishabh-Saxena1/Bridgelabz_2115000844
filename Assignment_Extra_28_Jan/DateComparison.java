import java.time.LocalDate;
import java.util.Scanner;
public class DateComparison{
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
      
       System.out.print("first date (YYYY-MM-DD): ");
       LocalDate date1 = LocalDate.parse(sc.next());
      
       System.out.print("second date (YYYY-MM-DD): ");
       LocalDate date2 = LocalDate.parse(sc.next());
      
       if (date1.isBefore(date2)) {
           System.out.println("The first date is before the second date.");
       } else if (date1.isAfter(date2)) {
           System.out.println("The first date is after the second date.");
       } else {
           System.out.println("Both dates are the same.");
       }
   }
}
