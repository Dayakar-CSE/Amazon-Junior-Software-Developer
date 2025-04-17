import java.util.Scanner;

public class SideKick extends Robot{
    Scanner keyboard;

    /** mode of operation  **/
  //  private int modeOfOperation;

    /** charge of battery  **/
  //  private int batteryCharge;

    /** TODO 9: Make this class a child class of
     *          the Robot class by using
     *          "extends Robot" after the
     *          "class SideKick" above.
     **/

    /** default constructor **/
    public SideKick() {
        keyboard = new Scanner(System.in);
        // initial charge of battery is 0
     //   batteryCharge = 0 ;

        // set default to cleaning or 1
     //   modeOfOperation = 1;
    }

    /*
    // accessor/getter method  for modeOfOperation
    public int getModeOfOperation() {
        return modeOfOperation;
    }

    // mutator/setter method for modeOfOperation
    public void setModeOfOperation(int modeOfOperation) {
        if(modeOfOperation>=1 && modeOfOperation<=3) {
            this.modeOfOperation = modeOfOperation;
        } else {
            this.modeOfOperation = 1;
        }
    }

     */

  /*
    // Getter method
    public int getBatteryCharge() {
        return batteryCharge;
    }

    // Setter method
    public void setBatteryCharge(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }
  */

    /*
    public void rechargeBattery() {
        System.out.println("Plug into socket.....");
        System.out.print("Charging ..");
        for (int i = 0; i <= 100; i += 10) {
            System.out.print(".");
            batteryCharge = i;

        }
        System.out.println("\nUnplug from socket.....");
        System.out.println("Fully charged.....");

    }

     */

    /*
    public void displayBatteryLevel() {
        System.out.println("The battery charge is at :" + batteryCharge + " %.");
    }

     */


    // method to set choice
    public void setChoice() {
        System.out.println("***** SideKick Menu *****");
        System.out.println("1. Cleaning");
        System.out.println("2. Cooking");
        System.out.println("3. Re-charge");

        System.out.println("Enter choice(1-3):");
        int choice = keyboard.nextInt();

        /** TODO 10: Replace the direct assignment of the
         *           property "modeOfOperation"
         *           to use the setter method
         */
       //  modeOfOperation =  choice;
        setModeOfOperation(choice);

    }

    // method to take action
    public void takeAction() {
        /** TODO 11: Replace the direct use of
         *           the property "modeOfOperation"
         *           in the switch to use the
         *           getter method
         */

        switch (getModeOfOperation()) {
            case 1:
                cleanHouse();
                System.out.println("SideKick cleaning completed.");
                break;
            case 2:
                cookFood();
                System.out.println("SideKick cooking completed.");
                break;
            case 3:
                rechargeBattery();
                System.out.println("SideKick recharged battery.");
                break;
            default:
                System.out.println("SideKick does not support the operation.");
        }
    }


    // method to clean
    private void cleanHouse() {
        System.out.println("Get the vacuum cleaner.....");
        System.out.println("Put the dust bag in vacuum.....");
        System.out.println("Go to Living room and clean.....");
        System.out.println("Go to bedroom and clean.....");
        System.out.println("Go to kitchen and clean.....");
        System.out.println("Go to bathroom and clean.....");
        System.out.println("Retrieve dust bag from vacuum cleaner and put in bin.....");
        System.out.println("Go back to Toni.....");
    }

    // method to cook
    private void cookFood() {
        System.out.println("Move to the kitchen...........");
        System.out.println("Get the vegetables...........");
        System.out.println("Cut the vegetables...........");
        System.out.println("Turn on the gas...........");
        System.out.println("Get the cooking pan and oil ready...........");
        System.out.println("Cook the food...........");
        System.out.println("Turn off the gas...........");
        System.out.println("Get it ready on the plate...........");
        System.out.println("Go back to Toni...........");
    }

}
