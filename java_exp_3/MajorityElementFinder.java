package Experiment3;
import java.util.*;

public class MajorityElementFinder {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                ans = nums[i];
            }
            if (ans == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = ob.nextInt(); 
        int arr[] = new int[n]; 
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = ob.nextInt();
        }
        System.out.println("Majority Element: " + majorityElement(arr));
        ob.close();
    }
}
