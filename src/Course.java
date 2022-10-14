/**
 * Author Dmitrii Sumenko
 * Date: 10/12/2022
 */

public class Course {
    private String department;
    private int number;
    private int credits;

    public Course() {
        department = "XXX";
        number = 777;
        credits = 0;
    }

    public Course(String department, int number, int credits) {
        this.department = department;
        this.number = number;
        this.credits = credits;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Here is my course info!";
    }
}
