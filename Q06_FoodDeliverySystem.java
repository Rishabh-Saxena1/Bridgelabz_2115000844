import java.util.*;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    private double discountPercentage;

    public VegItem(String itemName, double price, int quantity, double discountPercentage) {
        super(itemName, price, quantity);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * (discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on Veg Item: " + discountPercentage + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discountPercentage;

    public NonVegItem(String itemName, double price, int quantity, double discountPercentage) {
        super(itemName, price, quantity);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateTotalPrice() {
        double additionalCharge = 1.5;  // Non-veg items have an additional charge
        return (getPrice() * getQuantity()) + additionalCharge;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * (discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on Non-Veg Item: " + discountPercentage + "%";
    }
}

public class Q06_FoodDeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<FoodItem> foodItems = new ArrayList<>();

        System.out.println("Enter details for food items:");

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter item type (1 for Veg, 2 for Non-Veg): ");
            int itemType = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Item Name: ");
            String itemName = scanner.nextLine();

            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();

            System.out.print("Enter Discount Percentage: ");
            double discountPercentage = scanner.nextDouble();

            if (itemType == 1) {
                foodItems.add(new VegItem(itemName, price, quantity, discountPercentage));
            } else if (itemType == 2) {
                foodItems.add(new NonVegItem(itemName, price, quantity, discountPercentage));
            } else {
                System.out.println("Invalid item type. Skipping this item.");
            }
        }

        double totalOrderPrice = 0;

        for (FoodItem item : foodItems) {
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());
            if (item instanceof Discountable) {
                System.out.println(((Discountable) item).getDiscountDetails());
                System.out.println("Discount Applied: " + ((Discountable) item).applyDiscount());
            }
            totalOrderPrice += item.calculateTotalPrice();
        }

        System.out.println("\nTotal Order Price: " + totalOrderPrice);
        scanner.close();
    }
}
