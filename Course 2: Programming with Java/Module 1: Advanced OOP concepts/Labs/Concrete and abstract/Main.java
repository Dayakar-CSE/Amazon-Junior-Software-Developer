import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = in.nextLine();
        Subject subject1=new Subject("Java", 4);
        Subject subject2=new Subject("Java Online", 4);
        Subject subject3=new Subject("JavaScript", 6);
        Subject subject4=new Subject("JavaScript Online", 6);
        Course course1=null;
        System.out.println("Available courses");
        System.out.println("1. Java");
        System.out.println("2. Java Online");
        System.out.println("3. JavaScript");
        System.out.println("4. JavaScript Online");
        System.out.println("Enter course code :");
        int ch=in.nextInt();
        if (ch==1 || ch==3)
            course1= new ClassroomCourse(subject1, "Mark", 1000, "Cambridge", "Winter");
        if (ch==2 || ch==4)
            course1= new OnlineCourse(subject2, "Mark", 1000);
        Learner learner = new Learner(name, course1);
        System.out.println("Enter assignment marks (max 100 for classroom course, 30 for online course)");
        int mark1 = in.nextInt();
        System.out.println("Enter quiz marks (max 30 for classroom course, 10 for online course)");
        int mark2 = in.nextInt();
        learner.assignmentScore(mark1);
        learner.quizScore(mark2);
        String title=learner.course.subject.title;
        System.out.println("Grade score: " + learner.calculateGrade());
        if (learner.gradeScore>=5)
            System.out.println("Congratulations "+learner.name
                    +" you have successfully passed the "+title+" course");
        else
            System.out.println(learner.name
                    +" you have Failed the "+title+" course");
        
        
        /*
        Scanner sc = new Scanner(System.in);
        Subject subject = new Subject("CSE",1.5)
        //TODO 8: declare and initialize the object of ClassroomCourse class
        ClassroomCourse classroomCourse = new ClassroomCourse(subject,"ramesh",1000,"stanford","moring");
        //TODO 9: declare and initialize the Learner object
        Learner learner = new Learner("Ram",classroomCourse);
        //TODO 18: display course list and accept user choice
        System.out.println("**** Courses available **** \n1.Java \n2.Java Online \n3.JavaScript \n4.JavaScript Online");
        System.out.println("Enter course code: ");
        int courseChoice = sc.nextInt();
        //TODO 19: initialize object of chose course
        //TODO 20: accept user input for learner's name
        System.out.println("enter name: ");
        learner.name = sc.next();
        //TODO 21: call assignmentScore() method and quizScore() methods
        learner.assignmentScore(10);
        learner.quizScore(8);
        //TODO 22: call assignmentScore() method. Display the result as described
        double grade= learner.calculateGrade();
        System.out.println("Grade Score: "+ grade);
        if(grade >= 5){
            System.out.println("Successfully passed");
        }
        else{
            System.out.println("Failed");
        }
        
         */

    }
}
