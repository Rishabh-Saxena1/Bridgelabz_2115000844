class BankAccountDetails{
    String accountNumber;
    double balance;
    public BankAccountDetails(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void display(){
        System.out.println("Account number for your bank account " + accountNumber + " and the current balance in your account is " + balance);
    }
}
class SavingsAccount extends BankAccountDetails{
    double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void display(){
        super.display();
        System.out.println("This is Details for Saving Account");
        System.out.println("Interest rate on your saving account is: " + interestRate);
    }
}
class CheckingAccount extends BankAccountDetails{
    int withdrawalLimit;
    public CheckingAccount(String accountNumber, double balance, int withdrawalLimit){
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    public void display(){
        super.display();
        System.out.println("This is the details for Checking Account");
        System.out.println("Your withdrawal limit is: " + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccountDetails{
    int depositAmount;
    public FixedDepositAccount(String accountNumber, double balance, int depositAmount){
        super(accountNumber, balance);
        System.out.println("This is the details for your Fixed Deposit Account");
        System.out.println("Your Deposited amount is: "+ depositAmount);
    }
}
public class BankAccount {
    public static void main(String[] args) {
        BankAccountDetails SA = new SavingsAccount("RAPU8520", 45800.58, 4.2);
        SA.display();

        BankAccountDetails CA = new CheckingAccount("RAPU8520", 45800.58, 10000);
        CA.display();

        BankAccountDetails FDA = new FixedDepositAccount("RAPUN8250", 1820963.00, 1500);
        FDA.display();
    }
}
