public class CalculateProfit{
    public static void main(String args[]){
        int SP = 191;
        int CP = 129;
        int profit = SP - CP;
        double profit_per = (profit / (double) CP) * 100;
        System.out.println("The Cost Price is INR " + CP + " and Selling Price is INR " + SP);
        System.out.println("The profit in INR " + profit + " and the Profit Percentage is " + profit_per);
    }
}
