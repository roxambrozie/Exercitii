package inheritance;

import java.math.BigDecimal;

public class Emploeey extends Person {
    private String title;
    private String employer;
    private int employeeGrade;
    private BigDecimal salary;

    public Emploeey(String name, String title) {
        super(name);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public int getEmployeeGrade() {
        return employeeGrade;
    }

    public void setEmployeeGrade(int employeeGrade) {
        this.employeeGrade = employeeGrade;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String toString() {
        return title + "#" + employer + "#" + employeeGrade + " #"
                + super.getEmail() + " #" + super.getName() ;

    }
}
