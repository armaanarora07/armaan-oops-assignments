package ECommerce;

public class Product {
    private String productName;
    private double price;
    private int stock;

    public Product(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public void getProductDetails() {
        System.out.println("Product: " + productName + ", Price: $" + price + ", Stock: " + stock);
    }

    protected void applyDiscount(double discountRate) {
        price = price * (1 - discountRate);
        System.out.println("Discount applied. New Price: $" + price);
    }

    void updateStock(int newStock) {
        stock = newStock;
        System.out.println("Stock updated. New Stock: " + stock);
    }

    private void calculateProfit() {
        double profit = price * stock * 0.2; 
        System.out.println("Calculated Profit: $" + profit);
    }
}