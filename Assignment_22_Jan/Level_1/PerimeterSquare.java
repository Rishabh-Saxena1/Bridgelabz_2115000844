public class PerimeterSquare{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the perimeter of the square : ");
        int perimeter = sc.nextInt();
        int side = perimeter / 4;
        System.out.print("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
}
