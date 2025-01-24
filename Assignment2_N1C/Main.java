package Assignment2_N1C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Registration registration = new Registration();

        int choice;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Display Accounts");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println(">>> Registration Section <<<");
                    Registration.add();
                    break;
                }
                case 2: {
                    System.out.println(">>> Login Section <<<");

                    String lUsername;
                    String lPassword;

                    System.out.print("enter username: ");
                    lUsername= scanner.nextLine();
                    System.out.print("enter password: ");
                    lPassword = scanner.nextLine();

                    Registration.login(lUsername, lPassword);

                    break;
                }
                case 3: {
                    System.out.println(">>> Display Section <<<");
                    Registration.displayAccount();
                    break;
                }
                case 4: {
                    System.out.println(">>> Exit <<<");
                    System.exit(0);
                }

            }
        }

    }
}
