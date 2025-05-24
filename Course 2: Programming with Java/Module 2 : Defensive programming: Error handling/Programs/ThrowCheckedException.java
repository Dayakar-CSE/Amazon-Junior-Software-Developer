import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowCheckedException {
    public static void main(String[] args) {
        // method m2() to be called here
       try {
            m2();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    

    private static void m2() throws FileNotFoundException {
        // method m1() to be called here
        
        m1();
    
    }

    private static void m1() throws FileNotFoundException {
        try {
            FileInputStream inputStream = new FileInputStream("test.txt");
        } catch(FileNotFoundException e) {
            throw e;
        }
    }
}
