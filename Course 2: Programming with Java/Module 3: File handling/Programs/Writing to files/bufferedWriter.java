import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class bufferedWriter {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");
        String fileName = keyboard.next();
        keyboard.close();

        File file = new File("src/" + fileName + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("This is a sample string content for the file.");
            System.out.println("Data written to file successfully!");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File Not Found!");
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }
}
