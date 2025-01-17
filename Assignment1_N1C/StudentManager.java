package Assignment1_N1C;

import java.awt.*;
import java.util.Scanner;
import java.util.List;

public class StudentManager {

    private Scanner scanner;
    private StudentDAO studentDAO;
    private FileHandler fileHandler;

    public StudentManager() {
        scanner = new Scanner(System.in);
        studentDAO = new StudentDAO(5);
        fileHandler = new FileHandler();
    }


    public void addNewStudent() {
        System.out.print("enter student id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("enter student name: ");
        String name = scanner.nextLine();

        System.out.print("enter student birth date (DD-MM-YY): ");
        String birthDate = scanner.nextLine();

        Student student = new Student(id, name, birthDate);
        studentDAO.add(student);
    }


    public void getAllStudent() {
        System.out.println("Displaying all students");
        List<Student> students = studentDAO.getAllStudent();

        if (students == null || students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        // Iterate over the students and print their details
        for (Student student : students) {
            System.out.println(student); // Assumes Student class has a proper toString() method
        }
    }

    public void getStudentByID() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        Student student = studentDAO.getStudentByID(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void getStudentByName() {
        System.out.print("Enter student name to search: ");
        String name = scanner.nextLine();
        List<Student> students = studentDAO.getStudentByName(name);
        if (students != null) {
            System.out.println("Students with name " + name + ":");
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("No students found with name " + name);
        }
    }

    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        boolean isDeleted = studentDAO.deleteStudent(id);
        if (isDeleted) {
            System.out.println("Student with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new birth date (DD-MM-YY): ");
        String birthDate = scanner.nextLine();

        boolean isUpdated = studentDAO.updateStudent(id, name, birthDate);
        if (isUpdated) {
            System.out.println("Student with ID " + id + " updated successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void saveToFile() {
        List<Student> students = studentDAO.getAllStudent();
        fileHandler.addData(students);
    }

    public void loadFromFile() {
        List<Student> students = fileHandler.loadData();
        if (students.isEmpty()) {
            System.out.println("No data loaded from file.");
        } else {
            for (Student student : students) {
                studentDAO.add(student);
            }
        }
    }
}
