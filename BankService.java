package bankingapplication;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Account> accounts = new ArrayList<>();

    // Add new account
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created for: " + account.getHolderName());
    }

    // Deposit
    public void deposit(Account account, float amount) {
        account.deposit(amount);
    }

    // Withdraw
    public void withdraw(Account account, float amount) {
        account.withdraw(amount);
    }

    // Transfer
    public void transfer(Account fromAcc, Account toAcc, float amount, String rem) {
        if (fromAcc.getBalance() >= amount) {
            fromAcc.withdraw(amount);
            toAcc.deposit(amount);
            System.out.println("Rs. " + amount + " transferred successfully.");
        }
        else 
            System.out.println("Transfer failed: Insufficient balance.");       
    }

    // Print mini statement
    public void printMiniStatement(Account account) {
        System.out.println("----- Mini Statement -----");
        System.out.println("Account No: " + account.getAccountno());
        System.out.println("Holder Name: " + account.getHolderName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Opened Date: " + account.getOpenedDate());
        System.out.println("--------------------------");
    }
}
