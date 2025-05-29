import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class CreateFile { 
public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");
        String fileName = keyboard.next();
        keyboard.close();
        File file = new File("src/" + fileName + ".txt");
        try {
            boolean isFileCreated = file.createNewFile();
            if (isFileCreated) {
                System.out.println("File \"" + fileName + ".txt\" created successfully!");
            }
        } catch (IOException ioException) {
            System.err.println("I/O Exception occurred!");
            System.err.println(ioException.getMessage());
        }
    }
}
