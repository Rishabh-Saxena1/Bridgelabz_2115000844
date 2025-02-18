import java.util.*;

// Abstract class for Warehouse Items
abstract class WarehouseItem {
    private String name;
    private int id;

    public WarehouseItem(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return getClass().getSimpleName() + "ID: " + id + ", Name: " + name ;
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name, int id) {
        super(name, id);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, int id) {
        super(name, id);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, int id) {
        super(name, id);
    }
}

// Generic:- Bounded Type Parameter
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    // Method to get all items
    public List<T> getItems() {
        return items;
    }
}

// Wildcard Method
class WarehouseManager {
    public static void displayStorage(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        // Creating different storage units
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceryStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop", 223));
        electronicsStorage.addItem(new Electronics("Smartphone", 875));

        groceryStorage.addItem(new Groceries("Flour", 201));
        groceryStorage.addItem(new Groceries("Milk", 202));

        furnitureStorage.addItem(new Furniture("Chair", 301));
        furnitureStorage.addItem(new Furniture("Table", 302));

        // Displaying stored items using wildcard method
        System.out.println("Electronic Items:");
        WarehouseManager.displayStorage(electronicsStorage.getItems());

        System.out.println("Grocery Items:");
        WarehouseManager.displayStorage(groceryStorage.getItems());

        System.out.println("Furniture Items:");
        WarehouseManager.displayStorage(furnitureStorage.getItems());
    }
}
