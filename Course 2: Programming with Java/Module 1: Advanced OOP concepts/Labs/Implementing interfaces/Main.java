
public class Main {
    public static void main(String[] args) {
        //TODO 15: instantiate Student class
        Student student = new Student("Charlie",20,"Electronics",75);
        student.getDetails();
        //TODO 16: call result() and fee() methods
        student.result();
        student.fee(50000);

        //TODO 17: declare object of Employee class
        Employee employee = new Employee("Steve",35,50000);
        employee.getDetails();
        //TODO 18: call computeSalary() and computeTax() methods
        employee.computeSalary();
        employee.computeTax();
    }
}
