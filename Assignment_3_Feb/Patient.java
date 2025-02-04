import java.util.*;
class Patient {
   static String hospitalName = "City Hospital";
   static int totalPatients = 0;
   final int patientID;
   String name;
   int age;
   String ailment;

   Patient(int patientID, String name, int age, String ailment) {
       this.patientID = patientID;
       this.name = name;
       this.age = age;
       this.ailment = ailment;
       totalPatients++;
   }

   static void getTotalPatients() {
       System.out.println("Total Patients Admitted: " + totalPatients);
   }

   void displayDetails() {
           System.out.println("Patient ID: " + patientID);
           System.out.println("Name: " + name);
           System.out.println("Age: " + age);
           System.out.println("Ailment: " + ailment);
           System.out.println("Hospital: " + hospitalName);
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter patient ID: ");
       int patientID = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter patient name: ");
       String name = sc.nextLine();
       System.out.print("Enter patient age: ");
       int age = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter ailment: ");
       String ailment = sc.nextLine();
       Patient P = new Patient(patientID, name, age, ailment);
       if(P instanceof Patient){
        Patient.getTotalPatients();
        P.displayDetails();
       }
       else{
    System.out.println("Not an instance ");
       }
   }
}
