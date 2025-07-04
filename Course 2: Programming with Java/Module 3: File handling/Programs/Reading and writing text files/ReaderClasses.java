//Using InputStreamReader to read a text file

import java.io.FileInputStream;
FileInputStream inputStream = new FileInputStream("output.txt");
import java.io.InputStreamReader;
InputStreamReader reader = new InputStreamReader(inputStream);
int character;
while ((character = reader.read()) != -1) {
   System.out.print((char) character);
}


//Using FileReader
try {
   FileReader reader = new FileReader("EmployeeList.txt");
   int character;

   while ((character = reader.read()) != -1) {
       System.out.print((char) character);
   }
   reader.close();

} catch (IOException e) {
      System.out.println("Exception:" + e.getMessage());;
}


//BufferedReader to read a text file
try {
   FileReader reader = new FileReader("EmployeeList.txt");
   BufferedReader bufferedReader = new BufferedReader(reader);

   String line;

   while ((line = bufferedReader.readLine()) != null) {
       System.out.println(line);
   }
   reader.close();

} catch (IOException e) {
      System.out.println("Exception:" + e.getMessage());;
}

