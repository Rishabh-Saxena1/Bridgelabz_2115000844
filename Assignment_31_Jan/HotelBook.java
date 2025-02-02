import java.util.Scanner;
class HotelBook{
    String guestName;
    String roomType;
    int noOfNights;
    public HotelBook() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.noOfNights = 1;
    }
    public HotelBook(String guestName, String roomType, int noOfNights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.noOfNights = noOfNights;
    }
    public HotelBook(HotelBook differ) {
        this.guestName = differ.guestName;
        this.roomType = differ.roomType;
        this.noOfNights = differ.noOfNights;
    }
    public void showBooking() {
        System.out.println("Guest's Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("No Of Nights: " + noOfNights);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Guest Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Room Type: ");
        String roomType = sc.nextLine();
        System.out.print("Enter Number of Nights to spend: ");
        int noOfNights = sc.nextInt();
        HotelBook HB1 = new HotelBook(name, roomType, noOfNights);
        HotelBook HB2 = new HotelBook(HB1);
        System.out.println(" Booking Details:");
        HB1.showBooking();
        System.out.println(" Different Booking Details:");
        HB2.showBooking();
    }
}
