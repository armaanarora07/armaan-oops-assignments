package java_exp_9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class UniqueSum {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(3, 5, 3, 8, 2, 5));

        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        int sum = 0;
        for (int num : uniqueNumbers) {
            sum += num;
        }

        System.out.println("Unique values: " + uniqueNumbers);
        System.out.println("Sum: " + sum);
    }
}
