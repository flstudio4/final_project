/**
 * This class is a parent class for Teacher and Student classes. It contains common logic and base constructor.
 * <p>
 * Author Dmitrii Sumenko
 * Date: 10/12/2022
 */


public abstract class Employee {
    private final int id;
    private String firstName;
    private String lastName;

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void printEmployee(Employee employee) {
        if (employee instanceof Student) {
            System.out.print("Student id: " + id);
        }
        if (employee instanceof Teacher) {
            System.out.print("Teacher id: " + id);
        }

        System.out.println();
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
