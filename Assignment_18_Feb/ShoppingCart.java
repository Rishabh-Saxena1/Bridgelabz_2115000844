import java.util.*;
public class ShoppingCart {
    private Map<String, Double> productPrices;
    private LinkedHashMap<String, Double> cartOrder;
    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartOrder = new LinkedHashMap<>();
    }

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, price);
        System.out.println("Added to cart: " + product + " - " + price);
    }

    public void displayCartInOrder() {
        System.out.println("Cart Items in Order:");
        for (Map.Entry<String, Double> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void displayItemsSortedByPrice() {
        System.out.println("Items Sorted by Price:");
        TreeMap<Double, String> sortedMap = new TreeMap<>();
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            sortedMap.put(entry.getValue(), entry.getKey());
        }
        for (Map.Entry<Double, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getValue() + " - " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 12000.50);
        cart.addProduct("Mouse", 725.75);
        cart.addProduct("Keyboard", 1045.30);
        cart.addProduct("Monitor", 3000.00);
        cart.addProduct("USB Drive", 105.99);

        cart.displayCartInOrder();
        cart.displayItemsSortedByPrice();
    }
}
