import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int days;
    private List<String> medicalRecords = new ArrayList<>();

    public InPatient(int patientId, String name, int age, double dailyRate, int days) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.days = days;
    }

    @Override
    public double calculateBill() {
        return dailyRate * days;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for In-Patient " + getName() + ":");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords = new ArrayList<>();

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for Out-Patient " + getName() + ":");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

public class Q07_HospitalPatientManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Patient> patients = new ArrayList<>();

        System.out.println("Enter patient details:");

        // Create In-Patient
        System.out.print("Enter Patient Type (1 for In-Patient, 2 for Out-Patient): ");
        int patientType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (patientType == 1) {
            System.out.print("Enter Daily Rate: ");
            double dailyRate = scanner.nextDouble();
            System.out.print("Enter Number of Days: ");
            int days = scanner.nextInt();
            InPatient inPatient = new InPatient(patientId, name, age, dailyRate, days);
            patients.add(inPatient);

            System.out.println("Enter Medical Records for In-Patient (enter 'stop' to end):");
            scanner.nextLine();
            String record;
            while (!(record = scanner.nextLine()).equals("stop")) {
                inPatient.addRecord(record);
            }
        } else if (patientType == 2) {
            System.out.print("Enter Consultation Fee: ");
            double consultationFee = scanner.nextDouble();
            OutPatient outPatient = new OutPatient(patientId, name, age, consultationFee);
            patients.add(outPatient);

            System.out.println("Enter Medical Records for Out-Patient (enter 'stop' to end):");
            scanner.nextLine();
            String record;
            while (!(record = scanner.nextLine()).equals("stop")) {
                outPatient.addRecord(record);
            }
        } else {
            System.out.println("Invalid patient type.");
        }

        System.out.println("\nPatient Details and Billing:");
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: " + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println();
        }

        scanner.close();
    }
}
