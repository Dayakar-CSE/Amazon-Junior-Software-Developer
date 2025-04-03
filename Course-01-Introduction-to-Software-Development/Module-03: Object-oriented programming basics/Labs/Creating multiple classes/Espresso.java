// TODO 2: inherit from Coffee using the extends keyword
public class Espresso extends Coffee {

    // TODO 3: declare an attribute to store the number of shots (int)
       int numberOfShots;
    // TODO 4: constructor to initialize all attributes
    public Espresso(String name, String roast, double price, int numberOfShots) {
        // TODO 5: use super to call the Coffee constructor
          super(name,roast,price);
        // TODO 6: initialize numberOfShots using this
        this.numberOfShots = numberOfShots;
    }

    // TODO 7: define a method to print a message about the number of servings, cost per serving, and total bill
    public void printEspressoDetails(){

        System.out.println("You asked for " + numberOfShots+ " servings!");
        System.out.println("Every serving of Espresso costs "+price+"$. Your total bill is "+ (numberOfShots*price)+"$");
    }

}
