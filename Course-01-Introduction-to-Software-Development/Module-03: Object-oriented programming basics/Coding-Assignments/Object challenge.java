// BMICalculator class is a utility class that's used to calculate the BMI value in both Imperial and Metric systems
public class BMICalculator {

    // Please declare 4 attributes/properties to represent weight in pounds, height in inches, weight in kilos and height in meters
    double weightInPounds;
    double heightInInches;
    double weightInKilos;
    double heightInMeters;


    // Please use this default no arguments constructor to initialize the 4 properties to some initial values
    public BMICalculator() {
        this.weightInPounds = 1.0;
        this.heightInInches = 1.0;
        try {
            this.weightInKilos = 1.0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.heightInMeters = 1.0;

    }

    // Please implement the calculateBmiImperial() method to take in weight and height to calculate and return the BMI value in the Imperial system
    public double calculateBmiImperial(double weightInPounds,double heightInInches) {
             return (703 * weightInPounds)/(heightInInches*heightInInches);
    }

    // Please implement the calculateBmiMetric() method to take in weight and height to calculate and return the BMI value in the Metric system
    public double calculateBmiMetric(double weightInKilos,double heightInMeters) {
        return weightInKilos/(heightInMeters*heightInMeters);

    }

    // Please implement the getBMICategory() method so that it takes the BMI value and returns the BMI category based on it
    public String getBMICategory(double bmi) {

        if(bmi < 18.5){
            return "Underweight";
        }
        else if(bmi <25){
            return "Normal weight";
        }
        else if(bmi < 30){
            return "Overweight";
        }
        else{
            return "Obese";
        }

    }
}


import java.util.Scanner;

// The UserInput class implements methods that are used to obtain user inputs for BMI calculation
public class UserInput {

    // Obtains user input for the preferred BMI system
    public String obtainBMISystem() {
        // Display the welcome message to the user
        System.out.println("Welcome to the BMI calculator app!");
        System.out.print("Please select the preferred BMI calculation system (Imperial/Metric):");

        // Scanner that captures user input for the preferred BMI system
        Scanner input = new Scanner(System.in);
        // Reading the line of user input from the Scanner in to a String variable
        String bmiSystem = input.next();

        // Checking if a valid BMI system has been entered by the user
        if (!(bmiSystem.equalsIgnoreCase("Imperial") ||
                bmiSystem.equalsIgnoreCase("Metric"))) {
            // If not, return an empty String from the method
            return "";
        }

        // Otherwise (if not invalid) return the user entered BMI system
        return bmiSystem;
    }

    // Obtains user input for the weight in Pounds or Kilos, based on the entered BMI system
    public double obtainWeight(String bmiSystem) {
        // Variable to store the weight value
        double weight = 0;
        // Variable to indicate if the user input is valid or not
        boolean isInvalidInput = true;

        // The loop that controls obtaining user input for weight until a valid value is entered
        while (isInvalidInput) {
            // Scanner that captures user input for the weight value
        Scanner input = new Scanner(System.in);
            // A Switch statement that determines if weight should be obtained in Pounds or Kilos based on the BMI system
            switch (bmiSystem.toUpperCase()) {
                // The case of IMPERIAL BMI system
                case "IMPERIAL":
                    // Display the message to obtain weight in Pounds
                    System.out.print("Enter weight in Pounds:");
                    // Break out of the switch statement
                    break;
                // The case of METRIC BMI system
                case "METRIC":
                    // Display the message to obtain weight in Kilos
                    System.out.print("Enter weight in Kilos:");
                    // Break out of the switch statement
                    break;
                // The case of empty BMI system due to invalid user input
                case "":
                    // Display the message to ask the user to enter a valid value for BMI system
                    System.out.println("Please Enter a valid BMI System as input");
                    // Break out of the switch statement
                    break;
            }

            // An if statement that checks if the user has entered a valid value (double value) for weight
            if (input.hasNextDouble()) {
                // Read the double weight value from the Scanner object "input"
                weight = input.nextDouble();
                // Set that the user input is not invalid
                isInvalidInput = false;
            } else {
                // Display a message asking the user to input a valid value, in case of invalid user input
                System.out.println("Please enter a valid weight");
                // Set the weight to 0
                weight = 0;
            }
        }

        // Return the weight value
        return weight;
    }

    // Please implement the obtainHeight() method to obtains user input for the height in Inches or Meters, based on the entered BMI system
    public double obtainHeight(String bmiSystem) {
        // Variable to store the weight value
        double height = 0;
        // Variable to indicate if the user input is valid or not
        boolean isInvalidInput = true;

        // The loop that controls obtaining user input for weight until a valid value is entered
        while (isInvalidInput) {
            // Scanner that captures user input for the weight value
            Scanner input = new Scanner(System.in);
            // A Switch statement that determines if weight should be obtained in Pounds or Kilos based on the BMI system
            switch (bmiSystem.toUpperCase()) {
                // The case of IMPERIAL BMI system
                case "IMPERIAL":
                    // Display the message to obtain weight in Pounds
                    System.out.print("Enter height in inches:");
                    // Break out of the switch statement
                    break;
                // The case of METRIC BMI system
                case "METRIC":
                    // Display the message to obtain weight in Kilos
                    System.out.print("Enter height in meters:");
                    // Break out of the switch statement
                    break;
                // The case of empty BMI system due to invalid user input
                case "":
                    // Display the message to ask the user to enter a valid value for BMI system
                    System.out.println("Please Enter a valid BMI System as input");
                    // Break out of the switch statement
                    break;
            }

            // An if statement that checks if the user has entered a valid value (double value) for weight
            if (input.hasNextDouble()) {
                // Read the double weight value from the Scanner object "input"
                height = input.nextDouble();
                // Set that the user input is not invalid
                isInvalidInput = false;
            } else {
                // Display a message asking the user to input a valid value, in case of invalid user input
                System.out.println("Please enter a valid height");
                // Set the weight to 0
                height = 0;
            }
        }

        // Return the weight value
        return height;

    }
}



public class Main {
    public static void main(String[] args) {
        // Variables to store the weight and height values
        double weight, height;
        // Variable to hold the BMI value
        double bmi = 0;
        // Variable to hold the BMI system value obtained from user input
        String bmiSystem;
        // Variable to hold the BMI category determined by this BMI Calculator
        String bmiCategory;

        // Please initialize this reference variable to create an object of the UserInput class
        UserInput userInput = new UserInput();
        // Please initialize this reference variable to create an object of the BMICalculator class
        BMICalculator bmiCalculator = new BMICalculator();

        // Invoke the obtainBMISystem() of the UserInput class
        bmiSystem = userInput.obtainBMISystem();

        // A Switch statement that determines how user input for weight and height should be obtained based on the BMI system
        switch (bmiSystem.toUpperCase()) {
            // The case of IMPERIAL BMI system
            case "IMPERIAL":
                // Please invoke the obtainWeight() method of the UserInput class and assign it to the variable weight
                weight = userInput.obtainWeight(bmiSystem);

                // Please invoke the obtainHeight() method of the UserInput class and assign it to the variable height
                height = userInput.obtainHeight(bmiSystem);

                // Please invoke the calculateBmiImperial() method of the BMICalculator class
               bmi =  bmiCalculator.calculateBmiImperial(weight,height);

                // Break out of the switch statement
                break;
            // The case of METRIC BMI system
            case "METRIC":
                // Please invoke the obtainWeight() method of the UserInput class and assign it to the variable weight
                weight = userInput.obtainWeight(bmiSystem);

                // Please invoke the obtainHeight() method of the UserInput class and assign it to the variable height
                height = userInput.obtainHeight(bmiSystem);

                // Please invoke the calculateBmiMetric() method of the BMICalculator class
                bmi = bmiCalculator.calculateBmiMetric(weight,height);

                // Break out of the switch statement
                break;
            // The case of empty BMI system due to invalid user input
            case "":
                // Please display a message asking the user to enter a valid BMI system in case of invalid input
                System.out.println("Please Enter a valid BMI System as input");
                // Break out of the switch statement
                break;
        }

        // Display the calculated BMI value to the user
        System.out.println("Your BMI is: " + bmi);

        // Please invoke the getBMICategory() method of the BMICalculator class and assign the result to the bmiCategory variable
        bmiCategory = bmiCalculator.getBMICategory(bmi);

        // Display the BMI category to the user
        System.out.println("Your BMI category is: " + bmiCategory);
    }
}


