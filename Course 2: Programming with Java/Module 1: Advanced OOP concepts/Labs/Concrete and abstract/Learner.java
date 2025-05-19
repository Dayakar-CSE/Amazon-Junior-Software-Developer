//TODO 12: make Learner class implement Assessment interface
public class Learner implements Assessments {
    //TODO 1: declare instance variable

    String name;
    Course course;
    double gradeScore;

    Learner(String name, Course course) {
        //TODO 2: complete constructor
        this.name = name;
        this.course = course;
    }

    public String toString() {

        return "Name: " + this.name + " " + "Course: " + this.course.subject.title;
    }

    //TODO 13: override assignmentScore() method
    @Override
    public void assignmentScore(int marks) {

        this.course.assignmentMarks = marks;
    }

    //TODO 14: override quizScore() method
    @Override
    public void quizScore(int marks) {

        this.course.quizMarks = marks;
    }


public double calculateGrade() {

    int maxAssignmentMarks, maxQuizMarks;
    //TODO 17: calculate gradeScore as per the instructions above

    if(this.course.subject.title.contains("Online")){
        maxAssignmentMarks = 30;
        maxQuizMarks = 10;
    }
    else{
        maxAssignmentMarks = 100;
        maxQuizMarks = 30;
    }

    double assignmentGrade = (double) this.course.assignmentMarks*10/maxAssignmentMarks;
    double quizGrade = (double) this.course.quizMarks*10/maxQuizMarks;
    this.gradeScore = (assignmentGrade + quizGrade)/2;

    return this.gradeScore;
}
}
