package Assignment2_N1C;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

// Class to represent a question with options
class Question {
    String questionText;
    String[] options;
    char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('a' + i) + ". " + options[i]);
        }
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}


public class Registration {

    private static LinkedList<String> accounts = new LinkedList<>();
    private static LinkedList<Question> questions = new LinkedList<>();
    private static LinkedList<Question> exam = new LinkedList<>();

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        String type;

        System.out.print("Enter user type (Admin or Student): ");
        type = scanner.nextLine();

        if (type.equalsIgnoreCase("Admin")) {

            System.out.print("Enter admin username: ");
            username = scanner.nextLine();
            System.out.print("Enter admin password: ");
            password = scanner.nextLine();

            accounts.add(username);
            accounts.add(password);
            accounts.add(type);

            System.out.println("Admin account added successfully!");

        } else if (type.equalsIgnoreCase("Student")) {
            System.out.print("Enter student username: ");
            username = scanner.nextLine();
            System.out.print("Enter student password: ");
            password = scanner.nextLine();

            accounts.add(username);
            accounts.add(password);
            accounts.add(type);

            System.out.println("student account added successfully!");
        } else {
            System.out.println("Invalid type! Try to register again");
        }
    }

    public static void displayAccount() {
        System.out.println("Registered Accounts:");
        for (int i = 0; i < accounts.size(); i += 3) {
            System.out.println("Username: " + accounts.get(i));
            System.out.println("Password: " + accounts.get(i + 1));
            System.out.println("Type: " + accounts.get(i + 2));
            System.out.println("--------------------");
        }
    }

    // Admin Section
    public static void login(String lUsername, String lPassword) {

        for (int i = 0; i < accounts.size(); i += 3) {
            String username = accounts.get(i);
            String password = accounts.get(i + 1);
            String type = accounts.get(i + 2);

            if (Objects.equals(username, lUsername) && Objects.equals(password, lPassword)) {

                Scanner scanner = new Scanner(System.in);

                if (type.equalsIgnoreCase("Admin")){

                    System.out.println("Admin Login Successful!\n");

                    while (true) {
                        System.out.println("1. Add Question");
                        System.out.println("2. View All Questions");
                        System.out.println("3. Create Exam");
                        System.out.println("4. Logout");

                        System.out.print("Enter your choice: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Clear the buffer

                        switch (choice) {
                            case 1:
                                addQuestion(scanner);
                                break;
                            case 2:
                                displayAllQuestions();
                                break;
                            case 3:
                                createExam(scanner);
                                break;
                            case 4:
                                System.out.println("Logged out successfully.");
                                return;
                            default:
                                System.out.println("Invalid choice! Try again.");
                        }
                    }
                }

                else if (Objects.equals(type, "Student")) {
                    System.out.println("Student Login Successful!\n");

                    System.out.println(">>> Welcome from the Exam Center! Answer All the Questions <<<");
                    if (exam.isEmpty()) {
                        System.out.println("No Exam!");
                        return;
                    }

                    for (int j = 0; j < exam.size(); j++) {
                        int score = 0;

                        System.out.println("Question " + (j + 1) + ":");
                        exam.get(j).displayQuestion();

                        System.out.print("Enter your answer (a/b/c/d): ");
                        char userAnswer = scanner.next().toLowerCase().charAt(0);

                        if (userAnswer == exam.get(j).getCorrectAnswer()) {
                            score++;
                            System.out.println("your answer is correct. Congratulation!");
                        }

                        else {
                            System.out.println("your answer is incorrect");
                            System.out.println("Correct Answer: " + exam.get(j).getCorrectAnswer()); // Optional
                        }

                        System.out.printf("Your total score is %d", score);
                        System.out.println();
                    }

                }
            }
        }
    }

    private static void addQuestion(Scanner scanner) {
        System.out.println(">>> Add Question <<<");
        System.out.print("Enter question text: ");
        String questionText = scanner.nextLine();

        System.out.print("Enter number of options: ");
        int numOptions = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        String[] options = new String[numOptions];
        for (int i = 0; i < numOptions; i++) {
            System.out.print("Enter option " + (char) ('a' + i) + ": ");
            options[i] = scanner.nextLine();
        }

        System.out.print("Enter correct answer (a/b/c/d/etc.): ");
        char correctAnswer = scanner.nextLine().toLowerCase().charAt(0);

        questions.add(new Question(questionText, options, correctAnswer));
        System.out.println("Question added successfully!");
    }

    private static void displayAllQuestions() {
        System.out.println(">>> List of Questions <<<");
        if (questions.isEmpty()) {
            System.out.println("No questions have been added yet.");
            return;
        }

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ":");
            questions.get(i).displayQuestion();
            System.out.println("Correct Answer: " + questions.get(i).getCorrectAnswer()); // Optional
            System.out.println();
        }
    }

    private static void createExam(Scanner scanner) {
        System.out.println(">>> Create Exam <<<");
        System.out.println("Choose questions to include in the exam:");

        if (questions.isEmpty()) {
            System.out.println("No questions available to add to the exam.");
            return;
        }

        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i).questionText);
        }

        System.out.print("Enter question numbers to add to the exam (comma-separated): ");
        String[] selectedNumbers = scanner.nextLine().split(",");

        for (String num : selectedNumbers) {
            int index = Integer.parseInt(num.trim()) - 1;
            if (index >= 0 && index < questions.size()) {
                exam.add(questions.get(index));
            } else {
                System.out.println("Invalid question number: " + (index + 1));
            }
        }

        System.out.println("Exam created successfully with " + exam.size() + " questions.");
    }
}
