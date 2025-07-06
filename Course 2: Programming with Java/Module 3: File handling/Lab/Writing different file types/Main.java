import java.io.*;
import java.util.Scanner;

public class Main {
    //TODO 3: add a static method here. Use textFileWrite() as name, it won't return any value.
    //Inside the method, declare an object of Person class and use the toString() method to obtain
    //the string representation
    public static void textFileWrite() {
        Person person = new Person("Ram", 25, 75.0);
        //System.out.println(person.toString());
        String message = person.toString();

        //TODO 4: create object of FileWriter class, it points to file1.txt
        //call the write() method of FileWriter to save the data of the Person object in the file
        try{
            FileWriter fileObj = new FileWriter("src/file1.txt");
            fileObj.write(message);
            System.out.println("File written with FileWriter...");
            fileObj.close();
            //TODO 5: put the file writing code in try block, and catch the IO exception
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
//TODO 6: Define printWrite() method, a static method that doesn’t return any data.
//TODO 7: Take inputs from the user with Scanner class, for name, age and weight.
//  Instantiate Person object with the inputs
//TODO 8: Declare object of PrintWriter class, which refers to file2.txt file in the current folder.
//   Call its println() method, to write the object string returned by toString() method
//TODO 9: Put the code in try catch block for IOException
    public static void printWrite(){
        String data;
        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter name: ");
            String name = keyboard.nextLine();
            System.out.println("Enter Age: ");
            int age = keyboard.nextInt();
            System.out.println("Enter Weight: ");
            double weight = keyboard.nextDouble();
            Person person = new Person(name,age,weight);
            PrintWriter fileObj = new PrintWriter("src/file2.txt");
            data = person.toString();
            fileObj.println(data);
            fileObj.close();
            System.out.println("File written with PrintWriter...");
        }catch (IOException e){
            //System.out.println(e.getMessage());
            e.getStackTrace();
        }

    }

//TODO 10: Declare a byte array to store a list of numbers.
//TODO 11: Open a FileOutputStream object, pointing towards file3.txt file
//TODO 12: call the write() method of FileOutputStream object to print each element in the array.
// Use for loop for the purpose
//TODO 13: Place all the file activity inside the try-catch block.
    public static void binaryFileWriter(){
        byte[] num = {12,2,13,3,4,14};
        try(FileOutputStream fileOutputStream = new FileOutputStream("src/file3.txt")){
            for(int i=0;i<num.length;i++)
                fileOutputStream.write(num[i]);

            //for (byte b : num) fileOutputStream.write(b);
            System.out.println("File written with FileOutputStream...");

        }catch (IOException e){
            //System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

//TODO 14: Declare an object of DataOutputStream class.
// Use object of FileOutputStream class as argument to its constructor.
// The FileOutputStream object refers to file4.dat
//TODO 15: Use Scanner class to read name, age, and weight.
// Instantiate a Person object from the inputs.
//TODO 16: Call writeUTF(), writeInt(), and writeDouble() methods of DataOutputStream object
// to write respectively the name, age and weight attributes of the Person object.
//TODO 17: Place the entire file writing code in try-catch block
    public static void streamWriter(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = keyboard.nextLine();
        System.out.println("Enter Age: ");
        int age = keyboard.nextInt();
        System.out.println("Enter Weight: ");
        double weight = keyboard.nextDouble();
        Person person = new Person(name,age,weight);
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/file4.dat"))){
            dos.writeUTF(person.name);
            dos.writeInt(person.age);
            dos.writeDouble(person.weight);
            System.out.println("File written with DataOutputStream...");

        }catch (IOException e){
            //System.out.println(e.getMessage());
            e.getStackTrace();
        }

    }

    public static void main(String[] args) throws Exception{
        //TODO 18: call the static methods from main() method
        textFileWrite();
        printWrite();
        binaryFileWriter();
        streamWriter();

    }
}
