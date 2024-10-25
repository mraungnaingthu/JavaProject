import java.util.Scanner;

public class Tutorial1 {
    public static void main(String[] args) {
        int menu;
        String[][] Student = new String[100][4]; // Adjust size as needed
        String user_id = ""; // Initialize user_id
        int id = 0; // Initialize id
        int userCount=0; //to count user in the array

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Enter the menu id you want to control User Account");
            System.out.println("==================================================");
            System.out.println("Menu 1 >>> Register");
            System.out.println("Menu 2 >>> Login");
            System.out.println("Menu 3 >>> Update");
            System.out.println("Menu 4 >>> Delete");
            System.out.println("Menu 0 >>> Exit\n");

            System.out.print("Please enter the menu: ");
            menu = input.nextInt();

            if (menu == 1) {
                banner(">>> Welcome from Registration Center <<<");

                for (int i=0; i<4; i++) {
                    if (user_id.isEmpty()) {
                        user_id = "1";
                    }
                    else {
                        id = Integer.parseInt(user_id);
                        id++;
                        user_id = String.valueOf(id);
                    }
                    int userIndex = Integer.parseInt(user_id);

                    input.nextLine();
                    System.out.print("Please enter your account name: ");
                    Student[userIndex][1] = input.next();
                    System.out.print("Please enter your account mail: ");
                    Student[userIndex][2] = input.next();
                    System.out.print("Please enter your account password: ");
                    Student[userIndex][3] = input.next();

                    Student[userIndex][0] = user_id;

                    userCount++;
                }
                System.out.println("Total account user: " +userCount);
            }

            else if (menu == 2) {
                banner(">>> Welcome from Logging Center <<<");
                for (int i=0; i<=userCount; i++) {
                    if (Student[i][0] != null) {
                        for (int j=0; j<4; j++){
                            System.out.print(Student[i][j] + "\t");
                        };
                        System.out.println();
                    }

                }
            }

            else if (menu == 3) {
                banner(">>> Welcome from User Updating Center <<<");
                System.out.print("Please enter your account ID: ");
                String accountID = input.next();
                for (int k=0; k<=userCount; k++) {
                    if (accountID.equals(Student[k][0])) {
                        System.out.printf(">>> User ID founde at %d And Let's get Update...\n", k);
                        System.out.print("Please enter new account name: ");
                        Student[k][1] = input.next(); // Update username
                        System.out.print("Please enter new account mail: ");
                        Student[k][2] = input.next(); // Update email
                        System.out.print("Please enter new account password: ");
                        Student[k][3] = input.next(); // Update password
                        break;
                    }
                    else {
                        System.out.println("ID wrong...Please verify again your account ID!\n");
                    }
                }

            }

            else if (menu == 4) {
                String delID;
                banner("\n>>> Welcome from User Info Deleting Center <<<");
                System.out.print("Please enter your Account ID: ");
                delID = input.next();
                for (int k=0; k<=userCount; k++) {
                    if (delID.equals(Student[k][0])) {
                        System.out.printf("\n>>> User ID found at %d and Let's get Delete...\n", k);
                        System.out.println();
                        System.out.print("Do you want to delete...\n\nPress 1: To delete\nPress 2: Cancel\nClick >>> ");
                        int option = input.nextInt();
                        if (option == 1) {
                            userCount--;
                            for (int z=k; z<= userCount; z++) {
                                Student[z][0] = Student[z+1][0];
                                Student[z][1] = Student[z+1][1];
                                Student[z][2] = Student[z+1][2];
                                Student[z][3] = Student[z+1][3];
                            }
                            System.out.println("User account has been deleted successfully from the database!");
                        }
                        else if (option == 2) {
                            System.out.println("Cancelling user deleting!");
                            break;
                        }
                    }
                }
                System.out.println();
            }

        } while (menu != 0);

        input.close();
    }

    static void banner(String text) {
        System.out.println(text);
        for (int i=0; i<text.length(); i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println();
    }

}
