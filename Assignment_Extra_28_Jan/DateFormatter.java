import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormatter{
   public static void main(String[] args){
       LocalDate Presentdate= LocalDate.now();
       DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
       System.out.println(Presentdate.format(format1));
       System.out.println(Presentdate.format(format2));
       System.out.println(Presentdate.format(format3));
   }
}
