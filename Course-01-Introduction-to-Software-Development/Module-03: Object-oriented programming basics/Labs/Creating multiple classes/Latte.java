// TODO 14: inherit from Coffee using the extends keyword
public class Latte extends Coffee{

    // TODO 15: declare two attributes to store the milk type and syrup flavor (String)
    String milkType;
    String syrupFlavor;

    // TODO 16: constructor to initialize all attributes
    public Latte(String name, String roast, double price, String milkType, String syrupFlavor) {
        // TODO 17: use super to call the Coffee constructor
        super(name,roast,price);

        // TODO 18: initialize milkType and syrupFlavor using this
        this.milkType =milkType;
        this.syrupFlavor = syrupFlavor;
    }

    // TODO 19: define a method to print the details of milk type and syrup flavor along with the total bill
    public void  printLatteDetails(){
        System.out.println("Your latte has "+milkType+" and "+syrupFlavor+".");
        System.out.println("Your total bill is "+price+"$");
    }

}
