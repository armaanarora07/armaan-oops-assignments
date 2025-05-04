package Experiment2;

import java.util.Scanner;

public class ElectricityBill {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);

        int units;
        int tbill = 0;

        // Taking input from the user
        System.out.println("Input the total units consumed:");
        units = obj.nextInt();

        // Calculating electricity bill based on given conditions
        if (units <= 100) {
            tbill = units * 5;
        } else if (units <= 200) {
            tbill = (100 * 5) + ((units - 100) * 7);
        } else if (units <= 300) {
            tbill = (100 * 5) + (100 * 7) + ((units - 200) * 10);
        } else {
            tbill = (100 * 5) + (100 * 7) + (100 * 10) + ((units - 300) * 15);
        }

        // Displaying the total electricity bill
        System.out.println("The Total Electricity Bill is: Rs " + tbill);

        obj.close();
    }
}
