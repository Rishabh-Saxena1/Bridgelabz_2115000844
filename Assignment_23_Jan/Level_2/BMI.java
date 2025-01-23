import java.util.*;
public class BMI{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter your weight in kg: ");
            double weight = sc.nextDouble();

            System.out.print("Enter your height in cm: ");
            double heightCm = sc.nextDouble();

            double heightMeters = heightCm / 100;

            // Calculate BMI
            double bmi = weight / (heightMeters * heightMeters);

            // Determine weight status
            String weightStatus;
        if (bmi <= 18.4){
            weightStatus = "Underweight";
        }
        else if(bmi >= 18.5 && bmi <= 24.9){
            weightStatus = "Normal";
        }
        else if(bmi >= 25.0 && bmi <= 39.9){
            weightStatus = "Overweight";
        }
        else{
            weightStatus = "Obese";
        }
        System.out.println("Your BMI is : " + bmi);
        System.out.println("Your weight status is :" + weightStatus);
    }
}
