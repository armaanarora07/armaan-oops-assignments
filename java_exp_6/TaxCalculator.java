
package Experiment6;

class TaxCalculator {
    public static final double GST_RATE = 18.0;

    public final void displayGST() {
        System.out.println("GST Rate: " + GST_RATE + "%");
    }
}

class Invoice extends TaxCalculator {
    public double calculateTotalWithTax(double amount) {
        return amount + (amount * GST_RATE / 100);
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.displayGST(); 
        double totalAmount = invoice.calculateTotalWithTax(1000.0);
        System.out.println("Total Amount with GST: " + totalAmount);
    }
}