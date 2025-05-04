package Experiment3;

import java.util.StringTokenizer;
import java.util.*;
public class ReverseWords {
    public static String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.insert(0, st.nextToken() + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        String s;
        System.out.println("Enter the String");
        s=ob.nextLine();
        System.out.println("Reversed: " + reverseWords(s));
        ob.close();
    }
}
