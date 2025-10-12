package criticalThinking1;

import java.util.Scanner;

public class testClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Bank Account System!");

        // Account Information
        System.out.print("Enter your first name: ");
        String first = input.nextLine();

        System.out.print("Enter your last name: ");
        String last = input.nextLine();

        System.out.print("Enter your account ID number: ");
        int id = input.nextInt();

        subclassCheckingAccount userAccount = new subclassCheckingAccount();
        userAccount.setFirstName(first);
        userAccount.setLastName(last);
        userAccount.setAccountID(id);

        int choice;
        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Process Withdrawal (Overdraft Allowed)");
            System.out.println("4. View Account Summary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmt = input.nextDouble();
                    userAccount.deposit(depositAmt);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmt = input.nextDouble();
                    userAccount.withdrawal(withdrawAmt);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw (overdraft allowed): ");
                    double overdraftAmt = input.nextDouble();
                    userAccount.processWithdrawal(overdraftAmt);
                    break;

                case 4:
                    userAccount.displayAccount();
                    break;

                case 5:
                    System.out.println("Thank you for using our bank system!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);

        input.close();
    }
}

