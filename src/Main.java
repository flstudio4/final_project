/**
 * ***************************************************
 * ***** COLLEGE EMPLOYEE MANAGEMENT APPLICATION *****
 * ****************** Beta v.1.0 *********************
 * ***************************************************
 * <p>
 * This class contains main logic
 * <p>
 * @Author Dmitrii Sumenko
 * Date: 10/12/2022
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static final ArrayList<Teacher> teachers = new ArrayList<>();
    private static final int[] numbers = {101, 121, 140, 144, 181, 244, 281, 302};
    private static final int[] credits = {3, 4, 4, 3, 3, 4, 3, 6};
    private static final String[] departments = {"CIS", "HIS", "MAT", "LIT", "PHY", "ART", "BIO", "ENG"};
    private static int globalId = 1;
    private static final int TOTAL_CLASSES_ALLOWED = 5;
    public static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);

        int choice;     // Main switch control var
        int choice2;    // Teachers' menu control var
        int choice3;    // Students' menu control var
        int choice4;    // Add more classes or not var
        int choice5;    // Student delete control var
        int choice6;    // Teacher delete control var
        int total = 0;  // Total classes count control var

        printGreeting();

        do {

            printMainMenu();
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0 -> printDemo();
                case 1 -> {
                    do {
                        printTeacherMenu();
                        choice2 = input.nextInt();
                        input.nextLine();

                        if (choice2 == 0) {
                            // creating a new Teacher and adding to database
                            addEmployee(createTeacher());
                            System.out.println("Teacher successfully added.\n");
                            globalId++;
                        } else if (choice2 == 1) {
                            // Deleting a Teacher
                            System.out.print("Enter Teacher ID to delete: ");
                            choice6 = input.nextInt();
                            input.nextLine();

                            if (!teachers.isEmpty()) {
                                int index = 0;
                                for (Teacher teacher : teachers) {
                                    if (teacher.getId() == choice6) {
                                        //teachers.remove(teacher);
                                        index = teachers.indexOf(teacher);
                                        break;
                                    }
                                }
                                teachers.remove(index);
                                System.out.println("Teacher successfully deleted.\n");
                            } else
                                System.out.println("<<<<<< Deleting error...Teacher with id: " + choice6 + " does not exist >>>>>>\n");
                        } else if (choice2 == 2) {
                            // Printing all the Teachers
                            if (!teachers.isEmpty()) {
                                for (Teacher teacher : teachers) {
                                    teacher.printEmployee(teacher);
                                }
                            } else System.out.println("<<<<<<<< Teachers list is empty yet >>>>>>>\n");
                        }

                    } while (choice2 != 3);
                }
                case 2 -> {
                    do {
                        printStudentMenu();
                        choice3 = input.nextInt();
                        input.nextLine();

                        if (choice3 == 0) {
                            //Adding a Student
                            addEmployee(createStudent());
                            globalId++;
                            System.out.println("Add some courses: ");
                            addCourse(students.get(students.size() - 1).getClasses(), createCourse());

                            do {
                                System.out.println("Want to add more classes? (1 - yes, 2 - no)");
                                choice4 = input.nextInt();
                                input.nextLine();

                                if (choice4 == 1) {
                                    addCourse(students.get(students.size() - 1).getClasses(), createCourse());
                                } else if (choice4 == 2) {
                                    break;
                                }
                                // cannot add more than 5 classes

                                for (int i = 0; i < students.size(); i++) {
                                    total = students.get(students.size() - 1).getClasses().size();
                                }
                            } while (total < TOTAL_CLASSES_ALLOWED && choice4 < 1 || choice4 > 2);

                            System.out.println("Student successfully added.\n");
                        } else if (choice3 == 1) {
                            System.out.print("Enter Student ID to delete: ");
                            choice5 = input.nextInt();
                            input.nextLine();

                            // Deleting a Student
                            if (!students.isEmpty()) {
                                int index = 0;
                                for (Student student : students) {
                                    if (student.getId() == choice5) {
                                        index = students.indexOf(student);
                                        break;
                                    }
                                }
                                students.remove(index);
                                System.out.println("Student successfully deleted.\n");
                            } else
                                System.out.println("<<<<<< Deleting error...Student with id: " + choice5 + " does not exist >>>>>>\n");

                        } else if (choice3 == 2) {
                            if (!students.isEmpty()) {
                                for (Student student : students) {
                                    student.calculateTotalCredits(student);
                                    student.calculateDue(student);
                                }
                                // Printing all the Students
                                for (Student student : students) {
                                    student.printEmployee(student);
                                }
                            } else System.out.println("<<<<< There are no students yet >>>>>>\n");
                        }

                    } while (choice3 != 3);
                }
                case 3 -> System.out.println("End of the program, exiting...");
                default -> System.out.println("Some error occurred");
            }

        } while (choice != 3);

        input.close();
    }

    public static void addEmployee(Student student) {
        students.add(student);
    }

    public static Student createStudent() {
        String name;
        String lastName;

        do {
            System.out.print("Enter First Name: ");
            name = input.nextLine();

        } while (name.equals(""));

        do {
            System.out.print("Enter Last Name: ");
            lastName = input.nextLine();

        } while (lastName.equals(""));
        return new Student(globalId, name, lastName, createClasses());
    }

    public static void addEmployee(Teacher teacher) {
        teachers.add(teacher);
    }

    public static Teacher createTeacher() {
        String first;
        String last;
        int dept;
        int exp;

        do {
            System.out.println("Enter First Name: ");
            first = input.nextLine();

        } while (first.equals(""));

        do {
            System.out.println("Enter Last Name: ");
            last = input.nextLine();

        } while (last.equals(""));

        do {
            System.out.println("Enter Department: (0-CIS, 1-HIS, 2-MAT, 3-LIT, 4-PHY, 5-ART, 6-BIO, 7-ENG)");
            dept = input.nextInt();
            input.nextLine();

        } while (dept < 0 || dept > 7);

        do {
            System.out.println("Enter Years of Experience: 0 - 50: ");
            exp = input.nextInt();
            input.nextLine();

        } while (exp < 0);

        return new Teacher(globalId, first, last, departments[dept], exp);
    }

    public static Course createCourse() {
        int dept;
        int number;
        int credit;

        do {

            System.out.print("Enter number for course(0-CIS, 1-HIS, 2-MAT, 3-LIT, 4-PHY, 5-ART, 6-BIO, 7-ENG): ");
            dept = input.nextInt();
            input.nextLine();

        } while (dept < 0 || dept > 7);

        do {
            System.out.print("Enter number for class(0-101, 1-121, 2-140, 3-144, 4-181, 5-244, 6-281, 7-302): ");
            number = input.nextInt();
            input.nextLine();

        } while (number < 0 || number > 7);

        credit = credits[number];
        return new Course(departments[dept], numbers[number], credit);
    }

    public static ArrayList<Course> createClasses() {
        return new ArrayList<>();
    }

    public static void addCourse(ArrayList<Course> classes, Course course) {
        classes.add(course);
    }

    public static void printDemo() {
        Demo.createInstances();

        Demo.students.get(0).makePayment(Demo.students.get(0), 1950);
        for (Employee employee : Demo.students) {
            employee.printEmployee(employee);
            System.out.println();
        }

        for (Employee employee : Demo.teachers) {
            employee.printEmployee(employee);
        }
    }

    public static void printGreeting() {
        String stars = "***************************************************";
        String welcome = "***************** WELCOME TO **********************";
        String college = "***** COLLEGE EMPLOYEE MANAGEMENT APPLICATION *****";
        String version = "************* BETA VERSION 1.0 ********************";

        System.out.println();
        System.out.println(stars);
        System.out.println(welcome);
        System.out.println(college);
        System.out.println(version);
        System.out.println(stars);
        System.out.println();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException exc) {
            System.out.println("Interrupted");
        }
    }

    public static void printMainMenu() {
        System.out.println("-------------------------------");
        System.out.println("---------- Main menu ----------");
        System.out.println("------Enter your choice -------");
        System.out.println("-------------------------------");
        System.out.println("(0) Print Demo\n(1) Display Teacher Menu\n(2) Display Student Menu\n(3) Exit ");
        System.out.println("-------------------------------");
    }

    public static void printTeacherMenu() {
        System.out.println("-------------------------------");
        System.out.println("    This is a Teacher Menu.");
        System.out.println("-------------------------------");
        System.out.println("(0) Add a Teacher\n(1) Delete a Teacher\n(2) Print all Teachers\n(3) Return to Main Menu ");
        System.out.println("-------------------------------");
    }

    public static void printStudentMenu() {
        System.out.println("-------------------------------");
        System.out.println("    This is a Student Menu.");
        System.out.println("-------------------------------");
        System.out.println("(0) Add a Student\n(1) Delete a Student\n(2) Print all Students\n(3) Return to Main Menu ");
        System.out.println("-------------------------------");
    }
}
