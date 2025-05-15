public class Main {
    public static void main(String[] args) {

        Date dobOfStudent = new Date(1, 1, 2005); //dob of student
        Date dobOfTeacher = new Date(10, 10, 1995); //dob of teacher
        Date dobOfAppointment = new Date(1, 4, 2024); //dateOfAppointment of teacher

        Teacher teacher = new Teacher("Madhavan",dobOfTeacher,dobOfAppointment,"MTech","Electronics");
        teacher.setSalary(50000);

        Student student = new Student("Belinda",dobOfStudent,teacher,"Electronics");

        teacher.getDetails();
        student.getDetails();

    }
}
