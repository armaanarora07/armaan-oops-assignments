package java_exp_9;

import java.util.ArrayList;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alice", 101, 50000));
        employees.add(new Employee("Bob", 102, 60000));
        employees.add(new Employee("Charlie", 103, 55000));

        // Update salary of employee with id 102
        for (Employee e : employees) {
            if (e.id == 102) {
                e.salary = 65000;
            }
        }

        // Remove employee with id 101
        employees.removeIf(e -> e.id == 101);

        // Print remaining employees
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
