/** TODO 1: Import the Scanner **/
import java.util.Scanner;

// Beginning of the main class. The name of the main class and the file should be same.
public class Main {

    // Beginning of main method - a program starts from this method and ends here
    public static void main(String []args) {

        /** TODO 2: Create a Scanner variable named "keyboard" **/
        Scanner keyboard = new Scanner(System.in);
        int subChoice;

        /** TODO 3: A variable for getting the day of the week is given below **/
        /**         Initialize the variable to have the value 1 **/
        /** 1- is Monday, 2- is Tuesday and so on **/
        int dayOfTheWeek = 1;

        /** TODO 4: Display a menu to get the day of the week from the user **/
        /**

         ********** MENU *****************
         These are the choices for week of the day. \n Please enter only values from 1-7:
         1. MONDAY
         2. TUESDAY
         3. WEDNESDAY
         4. THURSDAY
         5. FRIDAY
         6. SATURDAY
         7. SUNDAY
         ***********************************

         **/
        System.out.println("********** MENU *****************");
        System.out.println("These are the choices for week of the day. ");
        System.out.println("Please enter only values from 1-7:");
        System.out.println("1. MONDAY \n 2. TUESDAY \n 3. WEDNESDAY\n 4. THURSDAY\n 5. FRIDAY\n 6. SATURDAY\n 7. SUNDAY");
        System.out.println("**********************************");


        /** TODO 5: Prompt Toni for input. Also let Toni know the valid choices like (1-7). **/
        System.out.println("Enter your choice of the day (1-7):");
        dayOfTheWeek = keyboard.nextInt();

        /** TODO 6: Create a switch with case values from 1-7 to handle the schedule **/
        /**         for the input in "dayOfTheWeek" **/
        switch (dayOfTheWeek) {
            case 1:
                System.out.println("Monday: It is back to work.....");
                System.out.println("*********** SUB MENU FOR MONDAY ******");
                System.out.println("1. Yes, I had my breakfast");
                System.out.println("2. No, I would like one");
                System.out.println("*************************************");
                System.out.println("enter your subChoice");
                subChoice = keyboard.nextInt();
                if(subChoice==1)
                    System.out.println("Good. Now you have a catchup meeting at 9AM Prepare your notes");
                else if(subChoice==2)
                    System.out.println("Lets us divert on Highway 54 and have a Burger on the drive in");
                else
                    System.out.println("NO such choice available");
                break;
            case 2:
                System.out.println("Tuesday: Continue work");
                break;
            case 3:
                System.out.println("Wednesday: Planning ");
                break;
            case 4:
                System.out.println("Thursday: analysis");
                break;
            case 5:
                System.out.println("Friday: development of code");
                break;
            case 6:
                System.out.println("Saturday: Deployment and maintaince of product");
                break;
            case 7:
                System.out.println("Sunday: Holiday");
                break;
            default :
                System.out.println("Enter a valid number 1-7");
                break;


            /** TODO 6(a): Implement all other cases for Tuesday to Sunday **/

            /** TODO 6(b): Implement "default" to handle Toni entering  **/
            /**            values less than 1 or more than 7 **/
        }

        /** TODO 7: Introduce a "break" after each case code, except the last  **/

        /** TODO 8: Go below the TODO 2 after the creation of Scanner variable  **/
        /**         and declare a variable "subChoice" **/

        /** TODO 9: Move below the display "Monday: It is back to work....." **/
        /**         in case 1 and create a menu  **/
        /** The sub-menu inside case 1 show appear as below:

         *********** SUB MENU FOR MONDAY ******
         * 1. Yes, I had my breakfast
         2. No, I would like one
         **************************************

         **/

        /** TODO 10: After the sub-menu inside case 1, prompt for input on choice **/
        /**         from Toni and store it in the variable subChoice **/

        /** TODO 11: Display appropriate response to Toni, based on value in **/
        /**          variable subChoice using if, if-else, else **/
        /**
         1. When subChoice has value of 1 display -
         Good. Now you have a catchup meeting at 9AM Prepare your notes

         2. When subChoice has value of 2 display -
         Lets us divert on Highway 54 and have a Burger on the drive in

         3. When subChoice has any other value then 1 or 2 display -
         NO such choice available
         **/


    } //end of main method

} //end of the main class
