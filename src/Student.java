/**
 * @author Dmitrii Sumenko
 * Date: 10/12/2022
 */


import java.util.ArrayList;

public class Student extends Employee {
    private static final int AMOUNT_PER_CREDIT = 146;
    private ArrayList<Course> classes;
    private Course course;
    private int due;
    private int totalCredits;

    public Student(int id, String firstName, String lastName, ArrayList<Course> pack) {
        super(id, firstName, lastName);
        this.classes = pack;
    }

    public void calculateTotalCredits(Student student) throws ArithmeticException {
        int totalCredits = 0;
        for (Course course : classes) {
            totalCredits = totalCredits + course.getCredits();
        }
        if (totalCredits < 0) {
            throw new ArithmeticException("Can't have negative value.");
        } else {
            student.totalCredits = totalCredits;
        }
    }

    public void calculateDue(Student student) {
        student.due = totalCredits * AMOUNT_PER_CREDIT;
    }

    @Override
    public void printEmployee(Employee employee) {
        super.printEmployee(employee);
        if (due > 0) {
            System.out.println("Total due: $" + due);
        } else if (due < 0) {
            System.out.println("Total due: Debt Free");
        }
        printClasses();
    }

    public void makePayment(Student student, int amount) {
        // This method is for future possible implementations
        student.due -= amount;
    }

    public void printClasses() {
        int count = 1;
        System.out.println("Classes:");
        for (Course course : classes) {
            System.out.println("\t" + count + ") " + course.getDepartment() + course.getNumber() + " Cred: " + course.getCredits());
            count++;
        }
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Course> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Course> classes) {
        this.classes = classes;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    @Override
    public String toString() {
        return "I am a Student!";
    }
}
