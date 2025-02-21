import java.io.*;
public class DataStream {
    private static final String FILENAME = "students.dat";
    public static void main(String[] args) {
        Student student1 = new Student(101, "Riya Bansal", 7.8);
        Student student2 = new Student(102, "Riya Saxena", 7.6);
        writeStudentData(student1, student2);
        readStudentData();
    }

    public static void writeStudentData(Student... students) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILENAME))) {
            for (Student student : students) {
                dos.writeInt(student.getRollNo());
                dos.writeUTF(student.getName());
                dos.writeDouble(student.getGpa());
            }
            System.out.println("Student data saved successfully.");
        }
        catch (IOException e) {
            System.err.println("Error writing student data: " + e.getMessage());
        }
    }

    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILENAME))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.printf("Roll Number: %d, Name: %s, GPA: %.2f%n", rollNumber, name, gpa);
            }
        }
        catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
        }
    }
}

class Student {
    private final int rollNo;
    private final String name;
    private final double gpa;

    public Student(int rollNo, String name, double gpa) {
        this.rollNo = rollNo;
        this.name = name;
        this.gpa = gpa;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}
