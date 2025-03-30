//Rectangle.java
public class Rectangle {

    // member variables to store the length and width of a rectangle
    double length;
    double width;

    // No-argument constructor with default values
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // Parameterized constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}


//Circle.java
public class Circle {

    double radius;

    public Circle() {
        // Your code here..
        this.radius = 1.0;
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }


}


// ShapeMetricCalculator.java
public class ShapeMetricCalculator {


    // method to calculate the area of a rectangle object
    public static double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.length * rectangle.width;
    }

    // method to calculate the area of a circle object
    public static double calculateCircleArea(Circle circle) {
        // Write your logic for calculating the area of a circle
        // return the area of the circle
        return Math.PI * circle.radius * circle.radius;
    }
}


//Main.java
public class Main {

    public static void main(String[] args) {
        // Create a Rectangle object with specified length and width
        Rectangle rectangle = new Rectangle(5.0, 3.0);

        // Create a Circle object with specified radius
        // You code here..
        Circle circle = new Circle(2.0);

        // … (Rectangle and Circle objects defined as before)
        // Call the method to calculate the area of the rectangle, and store the result in a variable
        double areaOfRectangle = ShapeMetricCalculator.calculateRectangleArea(rectangle);
        //Call the method to calculate the area of the circle, and store the result in a variable
        // Your code here..
        double areaOfCircle = ShapeMetricCalculator.calculateCircleArea(circle);

        System.out.println("Area of rectangle : " + areaOfRectangle);
        System.out.println("Area of circle: "+ areaOfCircle);

    }
}



