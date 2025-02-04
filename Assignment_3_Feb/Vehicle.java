import java.util.*;
class Vehicle {
   static double registrationFee = 5000.0;
   final String registrationNumber;
   String ownerName;
   String vehicleType;
   Vehicle(String ownerName, String vehicleType, String registrationNumber) {
       this.ownerName = ownerName;
       this.vehicleType = vehicleType;
       this.registrationNumber = registrationNumber;
   }

   static void updateRegistrationFee(double newFee) {
       registrationFee = newFee;
   }

   void showDetails() {
           System.out.println("Owner Name: " + ownerName);
           System.out.println("Vehicle Type: " + vehicleType);
           System.out.println("Registration Number: " + registrationNumber);
           System.out.println("Registration Fee: " + registrationFee);
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter owner name: ");
       String ownerName = sc.nextLine();
       System.out.print("Enter vehicle type: ");
       String vehicleType = sc.nextLine();
       System.out.print("Enter registration number: ");
       String registrationNumber = sc.nextLine();
       Vehicle V = new Vehicle(ownerName, vehicleType, registrationNumber);
       if(V instanceof Vehicle){
        V.showDetails();
       }
       else{
    System.out.println("Mot an instance");
       }
   }
}
