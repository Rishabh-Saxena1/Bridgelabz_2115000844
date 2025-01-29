import java.time.LocalDate;//Handles date-related operations without time.
import java.time.format.DateTimeFormatter;//Formats dates for output.
import java.util.Scanner;
public class DateArithmatic {
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
      
       // Prompt user for input date
       System.out.print("Enter a date (yyyy-MM-dd): ");
       String Date = sc.nextLine();
      
       //Converts the input String into a LocalDate object.
       LocalDate date = LocalDate.parse(Date);
      
       // Perform date arithmetic
       LocalDate modifiedDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
      
       // Define a formatter for output
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       System.out.println("Modified Date: " + modifiedDate.format(formatter));
   }
}
