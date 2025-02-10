import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;
    private double discountRate;

    public Product(int productId, String name, double price, double discountRate) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    abstract double calculateDiscount();

    void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
    }
}

class Electronics extends Product implements Taxable {
    private double taxRate;

    public Electronics(int productId, String name, double price, double taxRate, double discountRate) {
        super(productId, name, price, discountRate);
        this.taxRate = taxRate;
    }

    @Override
    double calculateDiscount() {
        return getPrice() * getDiscountRate() / 100;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate / 100;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + taxRate + "%";
    }
}

class Clothing extends Product implements Taxable {
    private double taxRate;

    public Clothing(int productId, String name, double price, double taxRate, double discountRate) {
        super(productId, name, price, discountRate);
        this.taxRate = taxRate;
    }

    @Override
    double calculateDiscount() {
        return getPrice() * getDiscountRate() / 100;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate / 100;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + taxRate + "%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price, double discountRate) {
        super(productId, name, price, discountRate);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * getDiscountRate() / 100;
    }
}

public class Q02_ECommercePlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine();

        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");

            System.out.print("Enter product type (Electronics/Clothing/Groceries): ");
            String type = scanner.nextLine();

            System.out.print("Enter product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter discount rate (in %): ");
            double discountRate = scanner.nextDouble();

            if (type.equalsIgnoreCase("Electronics")) {
                System.out.print("Enter tax rate for Electronics: ");
                double taxRate = scanner.nextDouble();
                productList.add(new Electronics(productId, name, price, taxRate, discountRate));
            } else if (type.equalsIgnoreCase("Clothing")) {
                System.out.print("Enter tax rate for Clothing: ");
                double taxRate = scanner.nextDouble();
                productList.add(new Clothing(productId, name, price, taxRate, discountRate));
            } else if (type.equalsIgnoreCase("Groceries")) {
                productList.add(new Groceries(productId, name, price, discountRate));
            } else {
                System.out.println("Invalid product type. Skipping...");
            }
            scanner.nextLine();
        }

        for (Product product : productList) {
            product.displayDetails();

            double tax = 0;
            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
            }

            double discount = product.calculateDiscount();
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("<<----->>");
        }

        scanner.close();
    }
}
