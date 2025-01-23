import java.util.*;
public class KiloToMiles{
    public static void main(String args[]){
        double kilometers = 10.8;
        // 1 km = 1.6 miles
        double kiloToMiles = 1.6;
        double miles = kilometers / kiloToMiles;
        System.out.print("The distance " + kilometers + " km in miles is "+ kiloToMiles);
    }
}
