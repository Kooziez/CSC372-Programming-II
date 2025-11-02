package criticalThinking2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankAccountGUI extends JFrame implements ActionListener {
    private double balance = 0.0;

    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton showBalanceButton;
    private JButton exitButton;

    public BankAccountGUI() {
        super("Bank Account Application");

        // Panel for UI
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Components
        panel.add(new JLabel("Enter amount:"));
        amountField = new JTextField();
        panel.add(amountField);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        showBalanceButton = new JButton("Show Balance");
        exitButton = new JButton("Exit");

        balanceLabel = new JLabel("Current Balance: $0.00");
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add components to panel
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(showBalanceButton);
        panel.add(exitButton);
        panel.add(balanceLabel);

        // Add Action Listeners
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        showBalanceButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Add panel to frame
        add(panel);

        // Frame setup
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == depositButton) {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    balance += amount;
                    balanceLabel.setText(String.format("Current Balance: $%.2f", balance));
                } else {
                    JOptionPane.showMessageDialog(this, "Enter a positive amount!");
                }
            } 
            else if (e.getSource() == withdrawButton) {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    balanceLabel.setText(String.format("Current Balance: $%.2f", balance));
                } else if (amount > balance) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds!");
                } else {
                    JOptionPane.showMessageDialog(this, "Enter a positive amount!");
                }
            } 
            else if (e.getSource() == showBalanceButton) {
                balanceLabel.setText(String.format("Current Balance: $%.2f", balance));
            } 
            else if (e.getSource() == exitButton) {
                JOptionPane.showMessageDialog(this, String.format("Final Balance: $%.2f", balance));
                System.exit(0);
            }

            amountField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankAccountGUI::new);
    }
}

