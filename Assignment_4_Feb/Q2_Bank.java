import java.util.ArrayList;

class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getName() + " has opened an account in " + name);
    }

    public void displayCustomers() {
        System.out.println("\nBank: " + name + " - Customers List:");
        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getName());
        }
    }
}

class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void viewBalance() {
        System.out.println(name + "'s Account Balance: $" + balance);
    }
}

public class Q2_Bank {
    public static void main(String[] args) {
        Bank bank = new Bank("ABC Bank");

        Customer customer1 = new Customer("Kanishk", 5000.0);
        Customer customer2 = new Customer("Aryan", 7500.0);

        bank.openAccount(customer1);
        bank.openAccount(customer2);

        customer1.viewBalance();
        customer2.viewBalance();

        bank.displayCustomers();
    }
}
