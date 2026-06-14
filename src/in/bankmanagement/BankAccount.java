package in.bankmanagement;

public class BankAccount {

    private final String accountNumber;

    private final String accountHolderName;

    private double balance = 0.0;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        this.balance += amt;
    }

    public void withdraw(double amt) {
        this.balance -= amt;
    }

    @Override
    public String toString() {
        return "-------------------------------\n"
                + "Account Number: " + accountNumber
                + "\nAccount Holder Name: " + accountHolderName
                + "\nAccount Balance: " + balance + "\n"
                + "-------------------------------\n";
    }
}
