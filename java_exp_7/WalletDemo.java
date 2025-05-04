// Interface Wallet
interface Wallet {
    void addFunds(double amount);
    void spendFunds(double amount);
}

// Concrete class DigitalWallet
class DigitalWallet implements Wallet {
    private double balance;

    @Override
    public void addFunds(double amount) {
        balance += amount;
        System.out.println("Added $" + amount + " to the wallet. New balance: $" + balance);
    }

    @Override
    public void spendFunds(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Spent $" + amount + " from the wallet. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds in the wallet.");
        }
    }
}

// Main class
public class WalletDemo {
    public static void main(String[] args) {
        Wallet wallet = new DigitalWallet();

        wallet.addFunds(100.0);
        wallet.spendFunds(50.0);
        wallet.spendFunds(75.0);
    }
}
