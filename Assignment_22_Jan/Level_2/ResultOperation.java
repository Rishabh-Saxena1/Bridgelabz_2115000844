import java.util.*;
class ResultOperation{
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.print("traveler's name: ");
String name=sc.nextLine();
System.out.print("starting city: ");
String fromCity=sc.nextLine();
System.out.print("via city: ");
String viaCity=sc.nextLine();
System.out.print("Enter the destination city: ");
String toCity=sc.nextLine();
System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in km: ");
double distanceFromToVia=sc.nextDouble();
System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in km: ");
double distanceViaToFinalCity=sc.nextDouble();
System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " (hours and minutes separately):\n");
System.out.print("Hrs: ");
int hours1=sc.nextInt();
System.out.print("Min: ");
        int minutes1=sc.nextInt();
 System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " (hours and minutes separately):\n");
        System.out.print("Hours: ");
        int hours2=sc.nextInt();
        System.out.print("Minutes: ");
        int minutes2=sc.nextInt();
        // Calculating total distance
        double totalDistance=distanceFromToVia+distanceViaToFinalCity;
        // Calculating total time in minutes
        int timeFromToVia=hours1*60+minutes1;
        int timeViaToFinalCity=hours2*60+minutes2;
               int totalTime=timeFromToVia+timeViaToFinalCity;
        // Converting total time to hours and minutes
        int totalHours = totalTime/60;
        int remainingMinutes=totalTime%60;
        // Printing the travel details
        System.out.println("\nTravel Details:");
        System.out.println("The Total Distance travelled by " + name + " from " +
                fromCity + " to " + toCity + " via " + viaCity +
                " is " + totalDistance + " km.");
        System.out.println("The Total Time taken is " + totalHours + " hours and " +
                remainingMinutes + " minutes.");
    }
}
