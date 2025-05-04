package Experiment6;

class Student {
    private String studentId;
    private String name;
    private char grade;

    public Student(String studentId, String name, char grade) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

public class StudentRecords {
    public static void main(String[] args) {
        Student student = new Student("S101", "Saurabh", 'A');
        student.displayStudentInfo();
    }
}