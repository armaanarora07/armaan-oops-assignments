package Experiment2;
import java.util.Scanner;
public class AddSubDivMul {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);

        // Taking user input for the operator
        System.out.println("Enter operator (+, -, *, /, %):");
        char operator = ob.next().charAt(0);

        // Taking user input for numbers
        System.out.println("Enter two numbers:");
        int a = ob.nextInt();
        int b = ob.nextInt();

        // Performing operation based on user input
        switch (operator) {
            case '+':
                System.out.println("Sum: " + (a + b));
                break;
            case '-':
                System.out.println("Subtract: " + (a - b));
                break;
            case '*':
                System.out.println("Product: " + (a * b));
                break;
            case '/':
                // Checking for division by zero
                if (b != 0) {
                    System.out.println("Divide: " + (a / b));
                } else {
                    System.out.println("Division by zero is not allowed.");
                }
                break;
            case '%':
                // Checking for modulus by zero
                if (b != 0) {
                    System.out.println("Modulus: " + (a % b));
                } else {
                    System.out.println("Modulus by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operator! Please enter a valid on-e.");
        }

        ob.close(); 
    }
}
