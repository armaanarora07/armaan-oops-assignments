package Experiment2;
public class Pattern 
    {
        public static void main(String[] args) {
            int n = 5; // Number of rows
    
            for (int i = 0; i < n; i++) {
                // Print spaces
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                // Print stars
                for (int j = 0; j < n - i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
    