public class PenDistribution{
    public static void main(String args[]){
        int totalPens = 14;
        int numOfStudents = 3;
        // Division of pens per student
        int pensPerStudent = totalPens / numOfStudents;
        int remainPens = totalPens % numOfStudents;
        System.out.print("The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is " + remainPens);
    }
}
