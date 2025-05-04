package java_exp_8;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingExample {
    public static void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            Scanner fileScanner = new Scanner(new java.io.File(fileName));
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            throw e;
        } finally {
            System.out.println("File operation attempted");
        }
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
    }
}
