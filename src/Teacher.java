/**
 * ****Teacher class*****
 * <p>
 * <p>
 * @author Dmitrii Sumenko
 * Date: 10/12/2022
 */

public class Teacher extends Employee {

    private String department;
    private int salary;
    private int yearsOfExperience;
    public final static int BASE_SALARY = 45_000;
    public final static int BRACKET = 10_000;
    public static final int MAX_SALARY = 140_000;

    public Teacher(int id, String firstName, String lastName, String department, int yearsOfExperience) {
        super(id, firstName, lastName);
        this.department = department;
        if (yearsOfExperience == 0) {
            salary = BASE_SALARY;
        } else if (yearsOfExperience > 15) {
            salary = MAX_SALARY;
        } else {
            salary = BASE_SALARY + BRACKET * yearsOfExperience;
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void printEmployee(Employee employee) {
        super.printEmployee(employee);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int yearsOfExperience) {
        salary = BASE_SALARY + yearsOfExperience * BRACKET;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void giveRise() {
        // This method is for future possible implementations
        ++yearsOfExperience;
        salary += BRACKET;
    }

    @Override
    public String toString() {
        return "I am a Teacher!";
    }
}
