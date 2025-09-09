package bankingapplication;

import java.util.Scanner;

public class BankAppMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();

        System.out.println("=== Welcome to Banking Application ===");

        // Create Savings Account
        System.out.println("\n--- Create Savings Account ---");
        System.out.print("Enter Account No: ");
        int sAccNo = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Holder Name: ");
        String sName = sc.nextLine();
        System.out.print("Enter Balance: ");
        float sBalance = sc.nextFloat();
        System.out.print("Enter Opened Date: ");
        String sDate = sc.next();
        System.out.print("Enter Interest Rate: ");
        float sRate = sc.nextFloat();
        System.out.print("Enter Minimum Balance: ");
        float sMin = sc.nextFloat();

        SavingsAccount savings = new SavingsAccount(sRate, sMin, sAccNo, sName, sBalance, sDate);

        // Create Current Account
        System.out.println("\n--- Create Current Account ---");
        System.out.print("Enter Account No: ");
        int cAccNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Holder Name: ");
        String cName = sc.nextLine();
        System.out.print("Enter Balance: ");
        float cBalance = sc.nextFloat();
        System.out.print("Enter Opened Date: ");
        String cDate = sc.next();
        System.out.print("Enter Overdraft Limit: ");
        float overdraft = sc.nextFloat();

        CurrentAccount current = new CurrentAccount(cAccNo, overdraft, cAccNo, cName, cBalance, cDate);

        int choice;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Deposit (Savings)");
            System.out.println("2. Withdraw (Savings)");
            System.out.println("3. Apply Interest (Savings)");
            System.out.println("4. Deposit (Current)");
            System.out.println("5. Withdraw (Current)");
            System.out.println("6. Transfer (Savings -> Current)");
            System.out.println("7. Mini Statement (Savings)");
            System.out.println("8. Mini Statement (Current)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    bankService.deposit(savings, sc.nextFloat());
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ");
                    bankService.withdraw(savings, sc.nextFloat());
                    break;
                case 3:
                    savings.intrestrate();
                    break;
                case 4:
                    System.out.print("Enter deposit amount: ");
                    bankService.deposit(current, sc.nextFloat());
                    break;
                case 5:
                    System.out.print("Enter withdraw amount: ");
                    bankService.withdraw(current, sc.nextFloat());
                    break;
                case 6:
                    System.out.print("Enter transfer amount: ");
                    float amt = sc.nextFloat();
                    sc.nextLine(); 
                    System.out.print("Enter remarks: ");
                    String rem = sc.nextLine();
                    bankService.transfer(savings, current, amt, rem);
                    break;
                case 7:
                    bankService.printMiniStatement(savings);
                    break;
                case 8:
                    bankService.printMiniStatement(current);
                    break;
                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
