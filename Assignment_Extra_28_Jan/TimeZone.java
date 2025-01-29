import java.time.ZonedDateTime; //for handling date-time with time zone
import java.time.ZoneId;//for specifying different time zone
import java.time.format.DateTimeFormatter;//for custom formatting
public class TimeZone{
   public static void main(String[] args) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
       ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));//Fetches the current time in Greenwich Mean Time.
        //now() method to get the current time
       ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));//Fetches the current time in Indian Standard Time (IST).
       ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));//Fetches the current time in Pacific Standard Time (PST).
       System.out.println("GMT Time: " + gmtTime.format(formatter));
       System.out.println("IST Time: " + istTime.format(formatter));
       System.out.println("PST Time: " + pstTime.format(formatter));
   }
}
