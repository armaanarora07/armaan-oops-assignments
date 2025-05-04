package java_exp_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentDataReader {
    public static void main(String[] args) {
        try {
            File file = new File("student.txt");
            Scanner scanner = new Scanner(file);
            
            System.out.println("Student records:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'student.txt' was not found. Please add some student data first.");
        }
    }
}