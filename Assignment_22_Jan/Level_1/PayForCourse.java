public class PayForCourse{
    public static void main(String args[]){
        int fee = 125000;
        int discountPer = 10;
        double discount = (fee * discountPer) / 100.0;
        double final_fee = fee - discount;
        System.out.print("The discount amount is INR " + discount + " and final discounted fee is INR " + final_fee);
    }
}
