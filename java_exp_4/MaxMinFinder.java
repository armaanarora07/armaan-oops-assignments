package Experiment3;
import java.util.*;

public class MaxMinFinder {
    public static int[] findMaxMin(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = ob.nextInt(); 
        int nums[] = new int[n]; 
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = ob.nextInt(); 
        }
        int[] result = findMaxMin(nums);
        System.out.println("Max: " + result[0] + ", Min: " + result[1]);
        ob.close();
    }
}
