package in.bankmanagement;

import java.util.Scanner;

public class BankManagementSystem {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankService service = new BankService(input);

        System.out.println("\n==================================");
        System.out.println("      BANK MANAGEMENT SYSTEM      ");
        System.out.println("==================================\n");

        int opt;

        do {

            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");
            System.out.print("\nWhat you would like to do?\nchoice: ");
            opt = input.nextInt();
            input.nextLine();

            switch (opt)    {

                case 1: service.createAccount();
                    break;

                case 2: service.viewAccount();
                    break;

                case 3: service.searchAccount();
                    break;

                case 4: service.depositMoney();
                    break;

                case 5: service.withdrawMoney();
                    break;

                case 6: service.deleteAccount();
                    break;

                case 7:
                    System.out.println("\nProgram Exited!!");
                    break;

                default:
                    System.out.println("\nInvalid Option!!");
                    System.out.println("================\n");
            }
        } while (opt != 7);
    }
}
