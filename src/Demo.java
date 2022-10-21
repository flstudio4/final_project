/**
 * This is a helper class. I created demo students and a teacher to show what output can be.
 * From main menu you need to press 0 to invoke printDemo() method that will eventually invoke createInstances() method,
 * and later on using loops print all Students' and Teachers' info to the console. FYI Array lists in this class are for
 * Demo purposes, so in the main() method for creating users manually I used different lists to not mess up main system
 * by fake users. f you want to test my application you can manually add anything, it's working.
 * <p>
 * Author Dmitrii Sumenko
 * Date: 10/12/2022
 */

import java.util.ArrayList;

public final class Demo {

    public static final ArrayList<Student> students = new ArrayList<>();
    public static final ArrayList<Teacher> teachers = new ArrayList<>();

    public static final int[] number = {101, 121, 140, 144, 181, 244, 281, 302};
    public static final int[] credits = {3, 4, 4, 3, 3, 4, 3, 6};
    public static final String[] departments = {"CIS", "HIS", "MAT", "LIT", "PHY", "ART", "BIO", "ENG"};

    public static void createInstances() {

        ArrayList<Course> forStud1 = new ArrayList<>();
        ArrayList<Course> forStud2 = new ArrayList<>();
        ArrayList<Course> forStud3 = new ArrayList<>();

        Course course1 = new Course(departments[2], number[0], credits[1]);
        Course course2 = new Course(departments[3], number[4], credits[1]);
        Course course3 = new Course(departments[5], number[6], credits[4]);
        Course course4 = new Course(departments[7], number[2], credits[2]);
        Course course5 = new Course(departments[3], number[3], credits[5]);
        Course course6 = new Course(departments[1], number[6], credits[1]);
        Course course7 = new Course(departments[6], number[4], credits[3]);
        Course course8 = new Course(departments[4], number[1], credits[1]);
        Course course9 = new Course(departments[2], number[0], credits[7]);

        Student student1 = new Student(1, "Alex", "Baldwin", forStud1);
        Student student2 = new Student(2, "Monica", "Adams", forStud2);
        Student student3 = new Student(3, "Angelina", "Jolie", forStud3);

        Teacher teacher = new Teacher(0, "Leonardo", "Da Vinci", departments[3], 4);
        teachers.add(teacher);

        forStud1.add(course1);
        forStud1.add(course2);
        forStud1.add(course3);

        forStud2.add(course4);
        forStud2.add(course5);
        forStud2.add(course6);
        forStud2.add(course3);

        forStud3.add(course7);
        forStud3.add(course8);
        forStud3.add(course9);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        student1.calculateTotalCredits(student1);
        student2.calculateTotalCredits(student2);
        student3.calculateTotalCredits(student3);
        student1.calculateDue(student1);
        student2.calculateDue(student2);
        student3.calculateDue(student3);
    }

}
