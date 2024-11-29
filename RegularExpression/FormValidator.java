package RegularExpression;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FormValidator {

    // Regex patterns
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_REGEX = "^\\+?\\d{1,4}?[-.\\s]?\\(?(\\d{1,3})\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
    private static final String ZIP_REGEX = "^\\d{5}(-\\d{4})?$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Form Validator ---");
            System.out.println("1. Validate Email");
            System.out.println("2. Validate Phone Number");
            System.out.println("3. Validate Password");
            System.out.println("4. Validate Date (YYYY-MM-DD)");
            System.out.println("5. Validate ZIP Code");
            System.out.println("6. Custom Regex Test");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    validateInput(scanner, EMAIL_REGEX, "Email");
                    break;
                case 2:
                    validateInput(scanner, PHONE_REGEX, "Phone Number");
                    break;
                case 3:
                    validateInput(scanner, PASSWORD_REGEX, "Password");
                    break;
                case 4:
                    validateInput(scanner, DATE_REGEX, "Date");
                    break;
                case 5:
                    validateInput(scanner, ZIP_REGEX, "ZIP Code");
                    break;
                case 6:
                    customRegexTest(scanner);
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Method to validate input against a regex pattern
    private static void validateInput(Scanner scanner, String regex, String inputType) {
        System.out.print("Enter " + inputType + ": ");
        String input = scanner.nextLine();
        if (Pattern.matches(regex, input)) {
            System.out.println(inputType + " is valid.");
        } else {
            System.out.println(inputType + " is invalid.");
        }
    }

    // Method for custom regex testing
    private static void customRegexTest(Scanner scanner) {
        System.out.print("Enter your custom regex: ");
        String customRegex = scanner.nextLine();
        System.out.print("Enter the string to test: ");
        String testString = scanner.nextLine();

        Pattern pattern = Pattern.compile(customRegex);
        Matcher matcher = pattern.matcher(testString);

        if (matcher.matches()) {
            System.out.println("The string matches the custom regex.");
        } else {
            System.out.println("The string does not match the custom regex.");
        }
    }
}
