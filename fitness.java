import java.util.Scanner;

// This class encapsulates the functionality of a fitness calculator.
class FitnessCalculator {

    // Encapsulated data members representing height, weight, and age.
    private double height;
    private double weight;
    private int age;

    // Constructor to initialize the FitnessCalculator object.
    public FitnessCalculator(double height, double weight, int age) {
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    // Method to calculate BMI.  This demonstrates abstraction by hiding the BMI formula.
    public double calculateBMI() {
        return weight / (((height / 100) * height) / 100); //Height in cm, needs to be converted to meters for BMI calculation.
    }

    // Method to calculate BMR. This also demonstrates abstraction.  The BMR formula is hidden, and different calculations are handled based on gender.
    public double calculateBMR(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            return (
                88.362 +
                (13.397 * weight) +
                ((4.799 * height) / 100) -
                (5.677 * age) //Height in cm, needs to be converted to meters for BMR calculation.
            );
        } else if (gender.equalsIgnoreCase("female")) {
            return (
                447.593 +
                (9.247 * weight) +
                ((3.098 * height) / 100) -
                (4.330 * age) //Height in cm, needs to be converted to meters for BMR calculation.
            );
        } else {
            return -1; // Indicate invalid gender
        }
    }

    // Main method where program execution begins.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your height in centimeters (e.g., 175): "); //Prompt changed for centimeters
        double height = input.nextDouble();

        System.out.print("Enter your weight in kilograms (e.g., 70): ");
        double weight = input.nextDouble();

        System.out.print("Enter your age in years: ");
        int age = input.nextInt();

        System.out.print("Enter your gender (male or female): ");
        String gender = input.next();

        // Creation of a FitnessCalculator object, demonstrating instantiation.
        FitnessCalculator person = new FitnessCalculator(height, weight, age);
        // Calling methods on the FitnessCalculator object.
        double bmi = person.calculateBMI();
        double bmr = person.calculateBMR(gender);

        System.out.println("\nYour Fitness Results:");
        System.out.printf("Body Mass Index (BMI): %.2f\n", bmi);
        if (bmr != -1) {
            System.out.printf(
                "Basal Metabolic Rate (BMR): %.2f calories per day\n",
                bmr
            );
        } else {
            System.out.println(
                "Invalid gender entered. Please enter 'male' or 'female'."
            );
        }

        input.close();
    }
}
