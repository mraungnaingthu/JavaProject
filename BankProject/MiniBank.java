package BankProject;

import java.util.Scanner;

// Main Class
public class MiniBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankOperations bankOperations = new BankOperations();

        while (true) {
            System.out.println("\nMini Bank System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Number: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accHolder = scanner.nextLine();
                    System.out.print("Enter Account UserEmail: ");
                    String userEmail = scanner.nextLine();
                    System.out.print("Enter Account User Password: ");
                    String userPassword = scanner.nextLine();
                    System.out.print("Enter Account User Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    bankOperations.createAccount(accNumber, accHolder, userEmail, userPassword, gender, balance);
                }
                case 2 -> {
                    System.out.print("Enter Account Number: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Enter Deposit Amount: ");
                    double amount = scanner.nextDouble();
                    bankOperations.deposit(accNumber, amount);
                }
                case 3 -> {
                    System.out.print("Enter Account Number: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Enter Withdrawal Amount: ");
                    double amount = scanner.nextDouble();
                    bankOperations.withdraw(accNumber, amount);
                }
                case 4 -> {
                    System.out.print("Enter Account Number: ");
                    String accNumber = scanner.nextLine();
                    bankOperations.displayAccount(accNumber);
                }
                case 5 -> {
                    System.out.println("Thank you for using Mini Bank!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
