import java.util.*;
public class BankingSystem {
    private Map<Integer, Double> accounts;
    private TreeMap<Double, Integer> sortedAccounts;
    private Queue<Integer> withdrawalQueue;
    public BankingSystem() {
        accounts = new HashMap<>();
        sortedAccounts = new TreeMap<>();
        withdrawalQueue = new LinkedList<>();
    }

    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
        System.out.println("Account created: " + accountNumber + " with balance: " + balance);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal requested for account: " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    public void displaySortedAccounts() {
        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " - Balance: " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 1500.75);
        bank.createAccount(102, 2300.50);
        bank.createAccount(103, 1200.30);
        bank.createAccount(104, 5000.00);
        bank.createAccount(105, 800.90);

        bank.requestWithdrawal(102);
        bank.requestWithdrawal(104);
        bank.processWithdrawals();
        bank.displaySortedAccounts();
    }
}
