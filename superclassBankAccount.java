package criticalThinking1;

public class superclassBankAccount {
    // Fields
    private String firstName;
    private String lastName;
    private int accountID;
    double balance; // Protected so subclasses can modify it directly

    // Constructor initialize balance to zero
    public superclassBankAccount() {
        this.balance = 0.0;
    }

    // Deposit funds
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdrawal funds
    public void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Group of Setters for accountSummary
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    // Group of Getters for accountSummary
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    // accountSummary displays account info and interest rate
    public void accountSummary() {
        System.out.println("\n=== Account Summary ===");
        System.out.println("Account Holder: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("========================\n");
    }
}

