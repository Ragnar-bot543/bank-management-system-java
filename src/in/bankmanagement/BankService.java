package in.bankmanagement;

import java.util.Scanner;

public class BankService {
    private static final int MAX_ACCOUNTS = 50;
    private final Scanner input;

    private final BankAccount[] accArr = new BankAccount[MAX_ACCOUNTS];
    private int accCount = 0;

    public BankService(Scanner input)   {
        this.input = input;
    }

    private boolean isEmpty(String str) {
        return str.trim().isEmpty() || str == null;
    }

    private int findAccountIndex(String accNum) {
        for (int i = 0; i < accCount; i++) {
            if (accArr[i].getAccountNumber().equals(accNum)) {
                return i;
            }
        }
        return -1;
    }

    public void createAccount() {
        System.out.print("\nAccount Number: ");
        String accNum = input.nextLine();

        if (isEmpty(accNum))  {
            System.out.println("\nAccount number cannot be empty!!");
            System.out.println("================================\n");
            return;
        }

        System.out.print("Account Holder Name: ");
        String accName = input.nextLine();

        if (isEmpty(accName))  {
            System.out.println("\nAccount Holder Name cannot be empty!!");
            System.out.println("=====================================\n");
            return;
        }

        int index = findAccountIndex(accNum);

        if (index != -1)    {
            System.out.println("\nAccount number already exists!!, Can't create your account.");
            System.out.println("===========================================================\n");
            return;
        }

        BankAccount bankAccount = new BankAccount(accNum, accName);
        System.out.println("\nAccount Created Successfully!!");
        System.out.println("==============================\n");
        accArr[accCount] = bankAccount;
        accCount++;
    }

    public void viewAccount()   {
        System.out.println("\n==================================");
        System.out.println("           ACCOUNT LIST         ");
        System.out.println("==================================\n");

        if (accCount == 0)  {
            System.out.println("No Accounts Available!!");
            System.out.println("========================\n");
            return;
        }

        for (int i = 0; i < accCount; i++)  {
            System.out.println(accArr[i]);
        }
    }

    public void searchAccount()  {
        System.out.print("\nEnter Account Number: ");
        String accNum = input.nextLine();

        if (isEmpty(accNum))  {
            System.out.println("\nAccount number cannot be empty!!");
            System.out.println("================================\n");
            return;
        }

        int index = findAccountIndex(accNum);

        if (index != -1)    {
            System.out.println("\nAccount Found Successfully!!");
            System.out.println("============================\n");
            System.out.println(accArr[index]);
            return;
        }

        System.out.println("\nAccount Not Found!!");
        System.out.println("===================\n");
    }

    public void depositMoney()  {
        System.out.print("\nEnter Account Number: ");
        String accNum = input.nextLine();

        if (isEmpty(accNum))  {
            System.out.println("\nAccount number cannot be empty!!");
            System.out.println("================================\n");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = input.nextDouble();
        input.nextLine();

        if (amt <= 0)  {
            System.out.println("\nAmount is invalid!!");
            System.out.println("===================\n");
            return;
        }

        int index = findAccountIndex(accNum);

        if (index != -1)    {
            accArr[index].deposit(amt);
            System.out.println("\nDeposit Successfully!!");
            System.out.println("======================\n");
            System.out.println(accArr[index]);
            return;
        }

        System.out.println("\nAccount Not Found!!");
        System.out.println("===================\n");
    }

    public void withdrawMoney() {
        System.out.print("\nEnter Account Number: ");
        String accNum = input.nextLine();

        if (isEmpty(accNum))  {
            System.out.println("\nAccount number cannot be empty!!");
            System.out.println("================================\n");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = input.nextDouble();
        input.nextLine();

        if (amt <= 0)  {
            System.out.println("\nAmount is invalid!!");
            System.out.println("===================\n");
            return;
        }

        int index = findAccountIndex(accNum);

        if (index != -1)    {
            if (accArr[index].getBalance() < amt)    {
                System.out.println("\nInsufficient Balance!!");
                System.out.println("======================\n");
                System.out.println("Available Balance: " + accArr[index].getBalance() + "\n");
                return;
            }

            accArr[index].withdraw(amt);
            System.out.println("\nWithdraw Successfully!!");
            System.out.println("=======================\n");
            System.out.println(accArr[index]);
            return;
        }

        System.out.println("Account not EXISTS!!");
        System.out.println("====================\n");
    }

    public void deleteAccount() {
        System.out.print("\nEnter Account Number: ");
        String accNum = input.nextLine();

        if (isEmpty(accNum))  {
            System.out.println("\nAccount number cannot be empty!!");
            System.out.println("================================\n");
            return;
        }

        int index = findAccountIndex(accNum);

            if (index != -1) {
                for (int j = index; j < accCount - 1; j++)  {
                    accArr[j] = accArr[j + 1];
                }
                accArr[accCount - 1] = null;
                accCount--;
                System.out.println("\nAccount Deleted Successfully!!");
                System.out.println("============================\n");
                return;
            }

        System.out.println("\nAccount Not Found!!");
        System.out.println("===================\n");
    }
}











