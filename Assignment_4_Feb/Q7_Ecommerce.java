import java.util.List;
import java.util.Arrays;

public class Q7_Ecommerce {

    // Product class
    public static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String displayProductInfo() {
            return String.format("Product: %s, Price: %.2f, Quantity: %d", name, price, quantity);
        }
    }

    // Order class
    public static class Order {
        private int orderId;
        private String orderDate;
        private Customer customer;
        private List<Product> products;

        public Order(int orderId, String orderDate, Customer customer, List<Product> products) {
            this.orderId = orderId;
            this.orderDate = orderDate;
            this.customer = customer;
            this.products = products;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public double calculateTotal() {
            double total = 0;
            for (Product product : products) {
                total += product.getPrice() * product.getQuantity();
            }
            return total;
        }

        public void displayOrderDetails() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Order Date: " + orderDate);
            System.out.println("Customer: " + customer.getName());
            System.out.println("Products in the Order:");
            for (Product product : products) {
                System.out.println(product.displayProductInfo());
            }
            System.out.println("Total: " + calculateTotal());
        }
    }

    // Customer class
    public static class Customer {
        private String name;
        private String email;
        private List<Order> orders;

        public Customer(String name, String email, List<Order> orders) {
            this.name = name;
            this.email = email;
            this.orders = orders;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }

        public void displayCustomerInfo() {
            System.out.println("Customer: " + name);
            System.out.println("Email: " + email);
            System.out.println("Orders placed:");
            for (Order order : orders) {
                order.displayOrderDetails();
            }
        }
    }

    public static void main(String[] args) {
        // Creating products
        Product product1 = new Product("Laptop", 800, 1);
        Product product2 = new Product("Headphones", 50, 2);

        // Creating an order
        Order order1 = new Order(1001, "2025-02-05", null, Arrays.asList(product1, product2));

        // Creating a customer and assigning the order
        Customer customer = new Customer("John Doe", "john.doe@example.com", Arrays.asList(order1));
        
        // Assigning the customer to the order
        order1.setCustomer(customer);

        // Displaying the customer information with order details
        customer.displayCustomerInfo();
    }
}
