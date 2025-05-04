package Experiment5;
class Employee {
    private String name;
    private int empid;
    private double salary;

    public Employee() {
        this.name = "Unknown";
        this.empid = 0;
        this.salary = 0.0;
    }

    public Employee(String name, int empid, double salary) {
        this.name = name;
        this.empid = empid;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getEmpid() {
        return empid;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double percentage) {
        salary += salary * (percentage / 100);
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, int empid, double salary, String department) {
        super(name, empid, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
 
class Main2 {
    public static void main(String[] args) {
        Employee emp = new Employee("John", 101, 50000);
        emp.increaseSalary(10);
        System.out.println("Employee Salary: " + emp.getSalary());
        System.out.println("Employee ID: " + emp.getEmpid());

        Manager mgr = new Manager("Alice", 102, 70000, "HR");
        mgr.increaseSalary(15);
        System.out.println("Manager Salary: " + mgr.getSalary());
        System.out.println("Manager Department: " + mgr.getDepartment());
    }
}