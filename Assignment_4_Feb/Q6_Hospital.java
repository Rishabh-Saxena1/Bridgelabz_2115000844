import java.util.ArrayList;

class Patient {
    private String name;
    private ArrayList<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void consultDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.consult(this);
    }

    public void displayConsultations() {
        System.out.println("Patient: " + name + " - Consulted Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  " + doctor.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Doctor {
    private String name;
    private ArrayList<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " consulted " + patient.getName());
    }

    public void displayPatients() {
        System.out.println("Doctor: " + name + " - Patients:");
        for (Patient patient : patients) {
            System.out.println("  " + patient.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayHospitalDetails() {
        System.out.println("\nHospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  " + doctor.getName());
        }
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println("  " + patient.getName());
        }
    }
}

public class Q6_Hospital {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Care Hospital");

        Doctor doctor1 = new Doctor("Dr. Kanishk");
        Doctor doctor2 = new Doctor("Dr. Aryan");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        Patient patient1 = new Patient("Riya");
        Patient patient2 = new Patient("Ankit");

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        patient1.consultDoctor(doctor1);
        patient1.consultDoctor(doctor2);
        patient2.consultDoctor(doctor1);

        hospital.displayHospitalDetails();

        doctor1.displayPatients();
        doctor2.displayPatients();

        patient1.displayConsultations();
        patient2.displayConsultations();
    }
}
