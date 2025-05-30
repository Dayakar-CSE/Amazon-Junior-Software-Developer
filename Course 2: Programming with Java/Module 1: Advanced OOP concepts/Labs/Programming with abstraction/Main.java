import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // your code here

    	Scanner keyBoard = new Scanner(System.in);
        System.out.println("Calculating Area of Rectangle: ");
        System.out.print("Enter Width:");
        float w = keyBoard.nextFloat();
        System.out.print("Enter height: ");
        float h = keyBoard.nextFloat();
        System.out.println("Enter lineColor: ");
        String lineColor = keyBoard.next();
        
        Rectangle rct = new Rectangle(w, h,lineColor);
        
        rct.draw();
        System.out.println("Area: "+rct.calculateArea());
        System.out.println("Calculating perimeter of rectangle: ");
        System.out.println("Perimeter: "+rct.calculatePerimeter());
        rct.lineColor();
        
        System.out.println("Calculating Area of Circle: ");
        System.out.print("Enter radius:");
        float r = keyBoard.nextFloat();
        System.out.println("Enter line color: ");
        String lc = keyBoard.next();
        
        Circle cr = new Circle(r,lc);
        
        cr.draw();
        System.out.println("Area: "+cr.calculateArea());
        System.out.println("Calculating perimeter of a Circle: ");
        System.out.println("Perimeter: "+cr.calculatePerimeter());
        cr.lineColor();
        
                           
    }
}
