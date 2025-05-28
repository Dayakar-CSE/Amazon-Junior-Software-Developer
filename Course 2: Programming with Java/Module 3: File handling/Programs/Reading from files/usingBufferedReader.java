import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public static void usingBufferedReader(String[] args) {
    File myTest = new File("src/myTestFile.txt");
    try (BufferedReader inputStream = new BufferedReader(new FileReader(myTest))) {
        int character;
        while ((character = inputStream.read()) != -1) {
            System.out.print((char) character);
        }
    } catch (FileNotFoundException fileNotFoundException) {
        System.err.println("File Not Found!");
    } catch (IOException ioException) {
        System.err.println(ioException.getMessage());
    }
}
