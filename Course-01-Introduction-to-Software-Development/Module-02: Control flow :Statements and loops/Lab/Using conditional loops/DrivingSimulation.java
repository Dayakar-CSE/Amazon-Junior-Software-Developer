import java.util.Scanner;

public class DrivingSimulation {
    public static void main(String[] args) {

        // TODO 1: Declare the necessary variables for the car's state and add scanner object
        boolean isEngineOn = false;
        String gear = "P";
        int speed   = 0;
        int choice  = 0;
        Scanner keyBoard   = new Scanner(System.in);


        // TODO 2: Display the current state of the car (engine state, gear, speed)
        System.out.println("------ Car Dashboard ------");
        System.out.println("isEngineOn: " + isEngineOn);
        System.out.println("gear: " + gear);
        System.out.println("Speed: " + speed);



        // TODO 3: Add print statements for each variable you want to display or options available to the user
        // 1. Turn on/off the engine
        // 2. Change gear (P, D, R)
        // 3. Accelerate
        // 4. Brake
        // 5. Exit
        while(choice != 5) {


            System.out.println("Menu:");
            System.out.println("1. Turn on/off the engine");
            System.out.println("2. Change gear (P, D, R)");
            System.out.println("3. Accelerate");
            System.out.println("4. Brake");
            System.out.println("5. Exit");

            // TODO 4: Prompt the user for their choice and store it in the 'choice' variable
            System.out.print("Enter your choice: ");
            choice = keyBoard.nextInt();


            // TODO 5: Implement a switch statement to handle the different menu choices
            switch (choice) {
                case 1:
                    isEngineOn = !isEngineOn;
                    break;
                case 2:
                    System.out.print("Enter gear (P, D, R): ");
                    gear = keyBoard.next();
                    break;
                case 3:
                    if (isEngineOn && !gear.equals("P")) {
                        speed += 10; // speed = speed+10
                    } else {
                        System.out.println("Cannot accelerate while engine is off or in Park (P) gear.");
                    }
                    break;
                case 4:
                    if (isEngineOn && speed > 0) {
                        speed -= 5;
                    } else {
                        System.out.println("Cannot apply braking while engine is off or in Park (P) gear.");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("enter a valid choice 1 - 5");
                    break;
            }
        }



            // TODO 6: Make sure the program runs until the user decides it's time to stop. Consider enclosing TODO 2 -> TODO 5 above in a while loop!


    }
}
