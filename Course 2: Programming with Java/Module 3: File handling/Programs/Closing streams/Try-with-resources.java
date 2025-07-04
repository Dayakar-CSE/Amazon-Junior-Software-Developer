        try (
                FileInputStream inFile = new FileInputStream("input.txt");
                FileOutputStream outFile = new FileOutputStream("output.txt"))
        {
            int c;
            while ((c = inFile.read()) != -1) {
                outFile.write(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//When using a BufferedReader wrapped around a FileReader, both streams need to be closed. The try-with-resources statement handles this automatically.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
