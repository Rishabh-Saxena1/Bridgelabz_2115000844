import java.util.*;
public class Circle {
    private double rad;
    public Circle() {
        this(1.0);
    }
    public Circle(double rad) {
        this.rad = rad;
    }
    public double calculateArea() {
        return Math.PI * rad * rad;
    }
    public double calculateCircum() {
        return 2 * Math.PI * rad;
    }
    public void showDetails() {
        System.out.println("Area of Circle is : " + calculateArea());
        System.out.println("Circumference of circle is : " + calculateCircum());
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
        System.out.println("Enter the radius :");
    double rad = sc.nextDouble();
        Circle C = new Circle();
        C.showDetails();
        System.out.println();
        Circle C2 = new Circle();
        C2.showDetails();
    }
}
