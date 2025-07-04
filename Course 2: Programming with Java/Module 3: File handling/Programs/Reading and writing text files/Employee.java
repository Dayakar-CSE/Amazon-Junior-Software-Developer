public class Employee {
   String name;
   int age;
   double salary;

   public Employee(String name, int age, double salary) {
       this.name = name;
       this.age = age;
       this.salary = salary;
   }

   @Override
   public String toString() {
       return "Employee{" +
               "name='" + this.name + '\'' +
               ", age=" + this.age +
               ", salary= $" + this.salary +
               '}';
   }
}
