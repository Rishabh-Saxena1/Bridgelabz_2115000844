import java.util.*;
public class AreaOfTriangle{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the base of the triangle :");
        int base = sc.nextInt();
        System.out.print("Enter the height of the triangle :");
        int height = sc.nextInt();
        // Area of a triangle = 1/2*base*height
        int area = (base * height) /2;
        System.out.print("Area of a triangle is " + area + " where base of a triangle is " + base + " and height of a triangle is " + height);
    }
}
