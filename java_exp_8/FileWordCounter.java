package java_exp_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileWordCounter {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the file name to analyze: ");
        String fileName = inputScanner.nextLine();
        
        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            
            int wordCount = 0;
            int charCount = 0;
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] words = line.split("\\s+");
                wordCount += words.length;
                
                for (String word : words) {
                    charCount += word.length();
                }
            }
            
            System.out.println("Total words: " + wordCount);
            System.out.println("Total characters (excluding whitespace): " + charCount);
            
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + fileName + "' was not found.");
        } finally {
            inputScanner.close();
        }
    }
}
