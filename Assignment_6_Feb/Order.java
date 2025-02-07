class Order{
    int orderId;
    String orderDate;
    public Order(int orderId, String orderDate){
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus(){
        return "Order placed on: " + orderDate;
    }
    public void showDetails(){
        System.out.println("Order ID: " + orderId + "Order Date: " + orderDate + " Status of the order is: "+ getOrderStatus());
    }
}
class ShippedOrder extends Order{
    int trackingNumber;
    public ShippedOrder(int orderId, String orderDate, int trackingNumber){
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    public String getOrderStatus(){
        return "Tracking Id of your placed order is: " + trackingNumber;
    }
}
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate, int trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    public String getOrderStatus() {
        return "Order will be deliverd on: " + deliveryDate;
    }
}
public class OnlineOrderManagement {
    public static void main(String[] args) {
        Order or = new Order(5588, "15-Jan-2025");
        System.out.println("Order details");
        or.showDetails();

        ShippedOrder SO = new ShippedOrder(5588, "15-Jan-2025", 88522258);
        System.out.println("Shipping Details of your order");
        SO.showDetails();

        DeliveredOrder DO = new DeliveredOrder(5588, "15-Jan-2025", 88522258, "25-Jan-2025");
        System.out.println("Delivery Details of your order");
        DO.showDetails();
    }
}
