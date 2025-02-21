import java.util.*;
public class CustomCatchBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();
            Integer[] array = new Integer[size];
           
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
            }
           
            System.out.print("Enter the index to retrieve value: ");
            int index = sc.nextInt();
           
            System.out.println("Value at index " + index + ": " + array[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        finally {
            sc.close();
        }
    }
}
