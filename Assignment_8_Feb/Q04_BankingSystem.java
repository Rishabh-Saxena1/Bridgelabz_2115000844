import java.util.*;

interface Loanable {
    boolean applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    abstract double calculateInterest();

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    double calculateInterest() {
        return getBalance() > 0 ? getBalance() * 0.05 : 0; 
    }
}

class LoanAccount extends BankAccount implements Loanable {
    private double loanAmount;

    public LoanAccount(String accountNumber, String holderName, double balance, double loanAmount) {
        super(accountNumber, holderName, balance);
        this.loanAmount = loanAmount;
    }

    @Override
    public boolean applyForLoan(double amount) {
        if (amount <= getBalance() * 2) {
            loanAmount = amount;
            System.out.println("Loan applied successfully: " + amount);
            return true;
        }
        System.out.println("Loan application failed. Amount exceeds eligibility.");
        return false;
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000; 
    }

    @Override
    double calculateInterest() {
        return loanAmount * 0.1; 
    }
}

public class Q04_BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter number of accounts: ");
        int numberOfAccounts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println("\nEnter details for Account " + (i + 1) + ":");
            System.out.print("Enter account type (Savings/Current/Loan): ");
            String type = scanner.nextLine();

            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Enter account holder name: ");
            String holderName = scanner.nextLine();

            System.out.print("Enter balance: ");
            double balance = scanner.nextDouble();

            if (type.equalsIgnoreCase("Savings")) {
                System.out.print("Enter interest rate: ");
                double interestRate = scanner.nextDouble();
                accounts.add(new SavingsAccount(accountNumber, holderName, balance, interestRate));
            } else if (type.equalsIgnoreCase("Current")) {
                System.out.print("Enter overdraft limit: ");
                double overdraftLimit = scanner.nextDouble();
                accounts.add(new CurrentAccount(accountNumber, holderName, balance, overdraftLimit));
            } else if (type.equalsIgnoreCase("Loan")) {
                accounts.add(new LoanAccount(accountNumber, holderName, balance, 0));
            } else {
                System.out.println("Invalid account type. Skipping...");
            }
            scanner.nextLine();  
        }

        for (BankAccount account : accounts) {
            account.displayDetails();
            double interest = account.calculateInterest();
            System.out.println("Interest: " + interest);

            if (account instanceof Loanable) {
                Loanable loanAccount = (Loanable) account;
                if (loanAccount.calculateLoanEligibility()) {
                    System.out.print("Enter loan amount to apply: ");
                    double loanAmount = scanner.nextDouble();
                    loanAccount.applyForLoan(loanAmount);
                } else {
                    System.out.println("Loan eligibility not met.");
                }
            }

            System.out.println(" ");
        }

        scanner.close();
    }
}
