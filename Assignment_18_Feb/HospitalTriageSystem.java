import java.util.*;
class Patient {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.severity, p1.severity)
        );
        triageQueue.add(new Patient("Rahul", 3));
        triageQueue.add(new Patient("Riya", 5));
        triageQueue.add(new Patient("Chanchal", 1));
        triageQueue.add(new Patient("Rashi", 4));
        triageQueue.add(new Patient("Yash", 2));
        System.out.println("Hospital Triage Order:");
        while (!triageQueue.isEmpty()) {
            System.out.println("Treating: " + triageQueue.poll());
        }
    }
}
