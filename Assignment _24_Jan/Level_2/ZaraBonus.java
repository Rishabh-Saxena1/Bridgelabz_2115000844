import java.util.Scanner;

public class ZaraBonus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays to store employee data
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        // Variables to store totals
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Get employee data (salary and years of service)
        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.print("Enter salary for employee " + (i + 1) + ": ");
                double salary = scanner.nextDouble();
                if (salary <= 0) {
                    System.out.println("Invalid salary. Please enter a positive value.");
                    continue; // Ask for input again
                }
                salaries[i] = salary;
                totalOldSalary += salary;
                break;
            }

            while (true) {
                System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                double years = scanner.nextDouble();
                if (years < 0) {
                    System.out.println("Invalid years of service. Please enter a non-negative value.");
                    continue; // Ask for input again
                }
                yearsOfService[i] = years;
                break;
            }
        }

        // Calculate bonuses and new salaries
        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05; // 5% bonus
            } else {
                bonuses[i] = salaries[i] * 0.02; // 2% bonus
            }
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalNewSalary += newSalaries[i];
        }

        // Print results
        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        scanner.close();
    }
}
