package java_exp_9;


import java.util.HashSet;

public class UniqueNamesSet {
    public static void main(String[] args) {
        String[] names = {"Aman", "Varchasv", "Sourabh", "Varchasv", "Aman"};

        HashSet<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            uniqueNames.add(name);
        }

        // Check if a name exists
        String checkName = "Varchasv";
        if (uniqueNames.contains(checkName)) {
            System.out.println(checkName + " exists in the set.");
        }

        // Print unique names
        System.out.println("Unique names:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
