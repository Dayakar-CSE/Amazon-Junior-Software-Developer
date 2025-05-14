abstract class Shape {
    abstract void area();
}

class Rectangle extends Shape {
    private int width, height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    void area() {
        int areaOfRectangle = this.width * this.height;
        System.out.println("Area of rectangle: " + areaOfRectangle);
    }
}

class Circle extends Shape {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    void area() {
        double areaOfCircle = Math.PI * Math.pow(this.radius, 2);
        System.out.println("Area of Circle: " + areaOfCircle);
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape;
        shape = new Rectangle(10, 20);
        shape.area();
        
        shape = new Circle(5);
        shape.area();
    }
}
