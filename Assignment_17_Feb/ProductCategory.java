import java.util.*;

abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class BookCategory extends ProductCategory {
    public BookCategory() {
        super(" Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super(" Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super(" Gadgets");
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public String toString() {
        return name + category.getCategoryName() + price;
    }
}

// Utility class with Generic Method
class Marketplace {
    // Generic Method to apply a discount
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("New price of " + product.getName() + ": " + product.getPrice());
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetCategory gadgetCategory = new GadgetCategory();

        Product<BookCategory> book = new Product<>("Rich Dad Poor Dad ",  20.0, bookCategory);
        Product<ClothingCategory> tshirt = new Product<>("Printed Flower tshirt for women ", 15.0, clothingCategory);
        Product<GadgetCategory> smartphone = new Product<>("Smartphone" , 500.0, gadgetCategory);

        System.out.println("Available Products:");
        System.out.println(book);
        System.out.println(tshirt);
        System.out.println(smartphone);

        System.out.println("Discounts:");
        Marketplace.applyDiscount(book, 10);
        Marketplace.applyDiscount(tshirt, 20);
        Marketplace.applyDiscount(smartphone, 18);

        System.out.println("Updated Prices:");
        System.out.println(book);
        System.out.println(tshirt);
        System.out.println(smartphone);
    }
}
