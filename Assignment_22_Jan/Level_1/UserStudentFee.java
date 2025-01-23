import java.util.*;
public class UserStudentFee{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the total student fee : ");
        double fee = sc.nextDouble();
        System.out.print("Enter the university discount percentage: ");
        double discountPer =sc.nextDouble();
        double discount = (discountPer / 100) * fee;
        double finalFee = fee - discount;
        System.out.println("The discount amount is "+ discount+ " and the final discounted fee is INR "+finalFee);
    }
}
