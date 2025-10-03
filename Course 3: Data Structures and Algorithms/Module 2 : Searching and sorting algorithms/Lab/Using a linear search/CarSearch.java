import java.util.ArrayList;

public class CarSearch {
    ArrayList cars = new ArrayList();

    public CarSearch(){
        cars.add(new Car("Ford", "Mustang", "Blue", 38320.00, "IN STOCK"));

        cars.add(new Car("Toyota", "Camry", "Green", 28484.00, "DEALER TRADE"));
        cars.add(new Car("Honda", "Accord", "Red", 31984.00, "DEALER TRADE"));
        cars.add(new Car("Ford", "Mustang", "Red", 41000.00, "IN STOCK"));
        cars.add(new Car("Toyota", "Camry", "Blue", 31044.00, "DEALER TRADE"));
        cars.add(new Car("Honda", "Accord", "Green", 28484.00, "FACTORY ORDER"));
        cars.add(new Car("Ford", "Escort", "Blue", 30990.00,   "FACTORY ORDER"));
        cars.add(new Car("Toyota", "Corolla", "Green", 23450.00, "IN STOCK"));
        cars.add(new Car("Honda", "Civic", "Red", 25500.00, "IN STOCK"));
        cars.add(new Car("Ford", "Escort", "Red", 38849.00, "FACTORY ORDER"));
        cars.add(new Car("Toyota", "Corolla", "Blue", 28959.00, "IN STOCK"));
        cars.add(new Car("Honda", "Civic", "Green", 28462.00, "IN STOCK"));
        cars.add(new Car("Ford", "Mustang", "Blue", 70990.00, "IN STOCK"));
        cars.add(new Car("Toyota", "Camry", "Green", 32248.00, "DEALER TRADE"));
        cars.add(new Car("Honda", "Accord", "Red", 33984.00, "FACTORY ORDER"));
        cars.add(new Car("Ford", "Mustang", "Red", 55600.00, "DEALER TRADE"));
        cars.add(new Car("Toyota", "Camry", "Blue", 29755.00, "IN STOCK"));
        cars.add(new Car("Honda", "Accord", "Green", 29758.00, "FACTORY ORDER"));
        cars.add(new Car("Ford", "Escort", "Blue", 35838.00, "DEALER TRADE"));
        cars.add(new Car("Toyota", "Corolla", "Green", 25324.00, "IN STOCK"));
        cars.add(new Car("Honda", "Civic", "Red", 28484.00, "FACTORY ORDER"));
        cars.add(new Car("Ford", "Escort", "Red", 33000.00, "IN STOCK"));
        cars.add(new Car("Toyota", "Corolla", "Blue", 24428.00, "DEALER TRADE"));
        cars.add(new Car("Honda", "Civic", "Green", 28583.00, "FACTORY ORDER"));
    }


    public ArrayList searchAvailability(String availability) {

        // TODO 1: Create a results ArrayList to hold the search results

        /* TODO 2: Loop over the cars array, comparing the value of the
                   availability field to the method parameter. Save
                   matching cars to the results array list. */

        /* TODO 3: if the results is empty, print a message saying
                   nothing was found */

        // TODO 4: Return results ArrayList.
        ArrayList results = new ArrayList();
        for(Object obj : cars){
            Car car = (Car) obj;
            if(car.availability.equals(availability)){
                results.add(car);
            }
        }

        if(results.isEmpty()) {
            System.out.println("There are no cars marked '" + availability + "' \n");
        }
        return results;
    }


    public ArrayList search(String make, String model, String color){

        // TODO 5: Create a results ArrayList to hold the search results

        /* TODO 6: Loop over the cars array, comparing the value of the
                   make, model, and color fields to the method
                   parameters. */

        /* TODO 7: if the make, model, and color of the Car instance
                   match the method parameters, add it to the results
                   ArrayList. */

        // TODO 8: If the results is empty. Print a message.

        // TODO 9: Return the results ArrayList
        ArrayList results = new ArrayList();
        for(Object obj : cars){
            Car car = (Car) obj;
            if(car.make.equals(make) && car.model.equals(model) && car.color.equals(color)){
                results.add(car);
            }
        }

        if(results.isEmpty()) {
            System.out.println("There is no " + color + " " + make + " " + model + " available at this time. \n");
        }
        return results;
    }

    public ArrayList searchPrice(double priceLimit, boolean lowerThan){

        /* TODO 10: Create a results ArrayList to hold the search
                    results */

        /* TODO 11: Loop over the cars array, comparing the price field
                    to the method parameters. */

        /* TODO 12: If the lowerThan boolean is true, add all cars
                    whose price is less than the priceLimit to the
                    results */

        /* TODO 13: If the lowerThan boolean is false, add all the
                    cars whose price is greater than the priceLimit
                    to the results */

        // TODO 14: If the results is empty. Print a message.

        // TODO 15: Return the results ArrayList
        ArrayList results = new ArrayList();
        for(Object obj : cars){
            Car car = (Car) obj;
            if(lowerThan && car.price < priceLimit){
                results.add(car);
            } else if (!lowerThan && car.price > priceLimit) {
                results.add(car);
            }
        }
        if(results.isEmpty()){
            System.out.println("There are no cars priced " + (lowerThan ? "below" : "above") + " " + priceLimit + "\n");
        }
        return results;
    }


    public static void main(String [] args){


        CarSearch carSearch = new CarSearch();

        System.out.println("\nList cars IN STOCK");
        ArrayList carsFound = carSearch.searchAvailability("IN STOCK");
        if(carsFound != null) {
            for (Object obj : carsFound) {
                Car car = (Car) obj;
                System.out.println(car);
            }
        }

        System.out.println("\nList all Red, Ford Mustangs");
        carsFound = carSearch.search("Ford", "Mustang", "Red");
        if(carsFound != null) {
            for(Object obj : carsFound){
                Car car = (Car) obj;
                System.out.println(car);
            }
        }

        System.out.println("\nList all cars under $25,000.00");
        carsFound = carSearch.searchPrice(25000.00, true);
        if(carsFound != null) {
            for(Object obj : carsFound){
                Car car = (Car) obj;
                System.out.println(car);
            }
        }

        System.out.println();
    }
}
