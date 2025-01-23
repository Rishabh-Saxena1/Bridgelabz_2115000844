import java.util.*;
public class LeapYearOperator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year+" is a Leap Year.");
        }
        else if (year < 1582) {
            System.out.println("The year is before the Gregorian calendar was introduced.");
        }
        else {
            System.out.println(year+" is NOT a Leap Year.");
        }
    }
}
