abstract class Employee extends Person{

    Date dateOfAppointment;
    int salary;

    abstract void setSalary(int sal);
    abstract int getSalary();
}
