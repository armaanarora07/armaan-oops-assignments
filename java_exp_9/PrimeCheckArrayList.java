package java_exp_9;


import java.util.ArrayList;

public class PrimeCheckArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        // Autoboxing
        for (int i = 2; i <= 10; i++) {
            numbers.add(i);
        }

        for (Integer num : numbers) {
            int n = num; // unboxing
            if (isPrime(n)) {
                System.out.println(n + " is a prime number.");
            } else {
                System.out.println(n + " is not a prime number.");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
