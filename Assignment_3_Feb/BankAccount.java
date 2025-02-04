import java.util.*;
class BankAccount{
   static String bankName = "Yes Bank";
   static int totalAccounts = 0;
   String accountHolderName;
   final int accountNumber;
   double balance;
   public BankAccount(String accountHolderName, int accountNumber, double balance) {
       this.accountHolderName = accountHolderName;
       this.accountNumber = accountNumber;
       this.balance = balance;
       totalAccounts++;
   }
   public static int getTotalAccounts() {
       return totalAccounts;
   }
   public void showDetails() {
           System.out.println("Bank Name: " + bankName);
           System.out.println("Account Holder's Name: " + accountHolderName);
           System.out.println("Account Number: " + accountNumber);
           System.out.println("Balance: " + balance);
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter account holder name: ");
       String name = sc.nextLine();
       System.out.print("Enter account number: ");
       int number = sc.nextInt();
       System.out.print("Enter initial balance: ");
       double balance = sc.nextDouble();
       BankAccount BA = new BankAccount(name, number, balance);
       System.out.println(" Here is your Account Details:");
       if(BA instanceof BankAccount){
            BA.showDetails();
    }
    else{
        System.out.println("Not instance");
    }
        System.out.println("Total Number of Accounts: " + BankAccount.getTotalAccounts());
   }
}
