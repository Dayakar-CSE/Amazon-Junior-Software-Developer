import java.util.Objects;

// Inherit from Coffee using the extends keyword
public class Latte extends Coffee {
    // Declare two attributes to store the milk type and syrup flavor (String)
    String milkType;
    String syrupFlavor;

    // Constructor to initialize all attributes
    public Latte(String name, String roast, double price, String milkType, String syrupFlavor) {
        // Use super to call the Coffee constructor
        super(name, roast, price);

        // Initialize milkType and syrupFlavor using this
        this.milkType = milkType;
        this.syrupFlavor = syrupFlavor;
    }

    // TODO 11: Override the grindBeans() method

    @Override
    public void grindBeans() {
       // super.grindBeans();
        System.out.println("Grinding coffee beans coarsely for a latte (medium grind)");
    }

    // TODO 12: Override the brewCoffee() method to simulate brewing coffee for latte, and all the other preparation steps

    @Override
    public void brewCoffee() {
       // super.brewCoffee();
        // TODO 12a: simulate brewing coffee for a latte
        System.out.println("Brewing coffee for a latte...");
        // TODO 12b: condition to check if syrupFlavor is selected
        if (!syrupFlavor.equals("no)")) {
         // TODO 12c: simulate adding the syrup
            System.out.println("Adding " + syrupFlavor + " syrup to the cup...");
        }

         // TODO 12d: simulate steaming milk
        System.out.println("steaming "+milkType+" milk....");

        // TODO 12e: simulate combining coffee and steamed milk
        System.out.println("combining coffee and steamed milk....");

        // TODO 12f: simulate adding a layer of foam on top
        System.out.println("Adding a layer of foam on top...");

    }

    // TODO 13: Override the printInfo() method to print the common and specific details of espresso including the bill
    @Override
    public void printInfo() {
        // TODO 14: Call the printInfo() method from the Coffee class using super
        super.printInfo();

        // TODO 15: Cut the print statements from the printLatteDetails() method and paste them here
        System.out.println("Your latte has " + milkType + " milk and " + syrupFlavor + " flavor.");
        System.out.println("Your total bill is " + price + "$.");

    }

    // TODO 16: Delete this method because it is not needed anymore
    /*
    public void printLatteDetails() {
        System.out.println("Your latte has " + milkType + " milk and " + syrupFlavor + " flavor.");
        System.out.println("Your total bill is " + price + "$.");
    }
     */
}
