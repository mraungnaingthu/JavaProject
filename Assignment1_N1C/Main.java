package Assignment1_N1C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager(); // Create a single instance
        StudentMenu(studentManager);
    }

    static void StudentMenu(StudentManager studentManager) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display all Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Delete Student");
            System.out.println("6. Update Student");
            System.out.println("7. Save to file");
            System.out.println("8. Load from file");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    studentManager.addNewStudent();
                    break;
                case "2":
                    studentManager.getAllStudent();
                    break;
                case "3":
                    studentManager.getStudentByID();
                    break;
                case "4":
                    studentManager.getStudentByName();
                    break;
                case "5":
                    studentManager.deleteStudent();
                    break;
                case "6":
                    studentManager.updateStudent();
                    break;
                case "7":
                    studentManager.saveToFile();
                    break;
                case "8":
                    studentManager.loadFromFile();
                    break;
                case "9":
                    System.out.println("Program exit...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again!");
            }
        }
    }
}