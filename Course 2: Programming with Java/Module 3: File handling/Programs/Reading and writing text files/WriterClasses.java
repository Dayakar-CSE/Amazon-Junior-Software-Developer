//BufferedWriter and OutputStreamWriter classes
try {
   FileOutputStream outputStream = new FileOutputStream("EmployeeList.txt");
   OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_16);
   BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

   Employee employee = new Employee("John", 23, 50000);
   bufferedWriter.write(employee.toString());
   bufferedWriter.newLine();

   bufferedWriter.close();
} catch (IOException e) {
   
   System.out.println("Exception:" + e.getMessage());
}


//Using FileWriter to write a text file
try {
   FileWriter writer = new FileWriter("EmployeeList.txt");
   Employee employee = new Employee("John", 23, 50000);
   writer.write(employee.toString());
   writer.write("\r\n");
   writer.close();
} catch (IOException e) {
      System.out.println("Exception:" + e.getMessage());;
}


//Using PrintWriter to write a text file
try {
     Employee employee = new Employee("John", 23, 50000);


     FileWriter fileWriter = new FileWriter("Employee.txt");


     PrintWriter printWriter = new PrintWriter(fileWriter);

     printWriter.println(employee);

     printWriter.close();

 } catch (IOException e) {
     System.out.println("Exception: " + e.getMessage());
 }


//But, if you want specific formatting like setting the decimal places, space between the name and age, then you can use the printf() method like System.out.printf().
try {
     Employee employee = new Employee("John", 23, 50000);

     FileWriter fileWriter = new FileWriter("Employee.txt");

     PrintWriter printWriter = new PrintWriter(fileWriter);

    printWriter.printf("Name: %s, Age: %d, Salary: %.2f%n",employee.getName(), employee.getAge(), employee.getSalary());
            
     printWriter.close();

 } catch (IOException e) {
     System.out.println("Exception: " + e.getMessage());
}


