package java_exp_9;


import java.util.HashMap;

public class ProductInventory {
    public static void main(String[] args) {
        HashMap<Integer, Integer> inventory = new HashMap<>();

        // Add products
        inventory.put(101, 50);
        inventory.put(102, 30);
        inventory.put(103, 70);

        // Update quantity of product 102
        inventory.put(102, 45);

        // Remove product 101
        inventory.remove(101);

        // Display inventory
        for (Integer productId : inventory.keySet()) {
            System.out.println("Product ID: " + productId + ", Quantity: " + inventory.get(productId));
        }
    }
}
