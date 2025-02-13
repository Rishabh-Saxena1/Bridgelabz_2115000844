class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;
 
    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
 }
 
 class StudentRecordSystem{
    private Student head;
 public StudentRecordSystem(){
 this.head=null;
 }
 
    void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }
 
    void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }
 
    void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position) {
        if (position <= 0) {
            addStudentAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addStudentAtEnd(rollNumber, name, age, grade);
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }
 
    void deleteStudent(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
 
    Student searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
 
    void displayStudents() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
 
    void updateGrade(int rollNumber, String newGrade) {
        Student temp = searchStudent(rollNumber);
        if (temp != null) {
            temp.grade = newGrade;
        }
    }
public static void main(String[] args) {
        StudentRecordSystem recordManagement = new StudentRecordSystem();
        recordManagement.addStudentAtBeginning(101, "riya", 20, "A");
        recordManagement.addStudentAtEnd(102, "shaan", 21, "B");
        recordManagement.addStudentAtPosition(103, "Chetan", 22, "A+",2);
        recordManagement.displayStudents();
        recordManagement.updateGrade(102, "A");
        recordManagement.searchStudent(103);
        recordManagement.displayStudents();
    }  
}
