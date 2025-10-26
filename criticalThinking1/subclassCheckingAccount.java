package criticalThinking1;

public class subclassCheckingAccount extends superclassBankAccount {
    private final double INTEREST_RATE = 8.0; // Fixed interest rate of 8%
    private final double OVERDRAFT_FEE = 30.0;

    public subclassCheckingAccount() {
        super();
    }

    // processWithdrawl including overdraft fee
    public void processWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Overdraft! A $" + OVERDRAFT_FEE + " fee has been applied.");
            balance -= (amount + OVERDRAFT_FEE); // Deducts withdraw and overdraft fee
            System.out.println("Withdrawal amount: $" + amount);
            System.out.println("New Balance: $" + String.format("%.2f", balance));
        } else {
            withdrawal(amount); // normal withdrawal
        }
    }

    // displayAccount info and interest rate
    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + INTEREST_RATE + "%");
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }
}
