package CustomerPortal;
import ECommerce.Product;

public class CustomerCart {
    public static void main(String[] args) {
        Product product = new Product("Laptop", 1000.0, 10);
        product.getProductDetails();
    }
}