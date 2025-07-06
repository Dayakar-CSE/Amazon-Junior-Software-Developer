public class Person {
    //TODO 1: declare instance variables
    String name;
    int age;
    double weight;

    Person(String name,int age,double weight) {
        //TODO 2: complete the constructor
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String toString() {
       //TODO 3: use the String.format() method to return string representation of the object
        return String.format("Name: %s Age: %d Weight: %.2f ",this.name,this.age,this.weight);
    }


}
