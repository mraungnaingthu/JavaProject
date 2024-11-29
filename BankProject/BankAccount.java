package BankProject;

import java.util.*;
import java.io.*;

// BankAccount Class
class BankAccount implements Serializable {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;
    private final String accountUserEmail;
    private final String accountUserPassword;
    private final String accountUserGender;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, String accountUserEmail,
                       String accountUserPassword, String accountUserGender, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountUserEmail = accountUserEmail;
        this.accountUserPassword = accountUserPassword;
        this.accountUserGender = accountUserGender;
        this.balance = initialBalance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountUserName() {
        return accountUserEmail;
    }

    public String getAccountUserPassword() {
        return accountUserPassword;
    }

    public String getAccountUserGender() {
        return accountUserGender;
    }

    // Deposit Money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn " + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    // Display Account Info
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account UserEmail: " + accountUserEmail);
        System.out.println("Account UserPassword: " + accountUserPassword);
        System.out.println("Account UserGender: " + accountUserGender);
        System.out.println("Account UserBalance: " + balance);
    }
}

// BankOperations Class
class BankOperations {
    private Map<String, BankAccount> accounts = new HashMap<>();
    private final String fileName = "accounts.dat";

    // Constructor - Loads data from file
    public BankOperations() {
        loadAccountsFromFile();
    }

    // Create a New Account
    public void createAccount(String accountNumber, String accountHolderName, String accountUserEmail,
                              String accountUserPassword, String accountUserGender, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
        } else {
            BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, accountUserEmail,
                    accountUserPassword, accountUserGender, initialBalance);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created successfully!");
        }
        saveAccountsToFile();
    }

    // Deposit
    public void deposit(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
        saveAccountsToFile();
    }

    // Withdraw
    public void withdraw(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
        saveAccountsToFile();
    }

    // Display Account Info
    public void displayAccount(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.displayAccountInfo();
        } else {
            System.out.println("Account not found!");
        }
    }

    // Save Accounts to File
    private void saveAccountsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    // Load Accounts from File
    private void loadAccountsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            accounts = (Map<String, BankAccount>) ois.readObject();
        } catch (FileNotFoundException e) {
            // First run, file not present
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}

