import java.util.Scanner;
class BankAccount {
   public String accountNumber;
   protected String accountHolder;
   private double balance;

   public BankAccount(String accountNumber, String accountHolder, double balance) {
       this.accountNumber = accountNumber;
       this.accountHolder = accountHolder;
       this.balance = balance;
   }

   public void deposit(double amount) {
       if (amount > 0) {
           balance += amount;
       }
   }

   public void withdraw(double amount) {
       if (amount > 0 && amount <= balance) {
           balance -= amount;
       }
   }

   public double getBalance() {
       return balance;
   }
}

class SavingsAccount extends BankAccount{
   public SavingsAccount(String accountNumber, String accountHolder, double balance) {
       super(accountNumber, accountHolder, balance);
   }

   public void showDetails() {
       System.out.println("Account Number: " + accountNumber);
       System.out.println("Account Holder: " + accountHolder);
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter Account Number: ");
       String accountNumber = sc.nextLine();
       System.out.print("Enter Account Holder: ");
       String accountHolder = sc.nextLine();
       System.out.print("Enter Initial Balance: ");
       double balance = sc.nextDouble();
       SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolder, balance);
       savingsAccount.showDetails();
       System.out.println("Balance: " + savingsAccount.getBalance());
       System.out.print("Enter deposit amount: ");
       double depositAmount = sc.nextDouble();
       savingsAccount.deposit(depositAmount);
       System.out.println("Updated Balance: " + savingsAccount.getBalance());

       System.out.print("Enter withdrawal amount: ");
       double withdrawalAmount = sc.nextDouble();
       savingsAccount.withdraw(withdrawalAmount);
       System.out.println("Updated Balance: " + savingsAccount.getBalance());
   }
}
