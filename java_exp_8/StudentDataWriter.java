package java_exp_8;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentDataWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();
        
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        
        try (FileWriter writer = new FileWriter("student.txt", true)) {
            writer.write("Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + "\n");
            System.out.println("Data written to student.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}