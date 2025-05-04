package Experiment2;
import java.util.Scanner;

public class ShapeArea {
    
    // Method to calculate the area of a rectangle
    double area(double length, double breadth) {
        return length * breadth;
    }

    // Method to calculate the area of a square
    double area(double side) {
        return side * side;
    }

    // Method to calculate the area of a circle
    double area(float radius) {
        return 3.1416 * radius * radius; // Approximate π
    }

    // Method to calculate the area of a triangle
    double area(double base, int height) {
        return 0.5 * base * height;
    }

    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        ShapeArea shape = new ShapeArea();

        // Calling function for Rectangle
        System.out.println("Enter length and breadth of Rectangle:");
        double length = ob.nextDouble();
        double breadth = ob.nextDouble();
        System.out.println("Area of Rectangle: " + shape.area(length, breadth));

        // Calling function for Square
        System.out.println("\nEnter side length of Square:");
        double side = ob.nextDouble();
        System.out.println("Area of Square: " + shape.area(side));

        // Calling function for Circle
        System.out.println("\nEnter radius of Circle:");
        float radius = ob.nextFloat();
        System.out.println("Area of Circle: " + shape.area(radius));

        // Calling function for Triangle
        System.out.println("\nEnter base and height of Triangle:");
        double base = ob.nextDouble();
        int height = ob.nextInt();
        System.out.println("Area of Triangle: " + shape.area(base, height));

        ob.close();
    }
}
