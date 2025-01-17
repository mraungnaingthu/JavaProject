package Assignment1_N1C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDAO {

    private Student[] students;
    private int count;

    public StudentDAO(int capacity) {
        students = new Student[capacity];
        count = 0;
    }

    public void add(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            students = Arrays.copyOf(students, students.length * 2);
            students[count] = student;
            count++;
        }
        System.out.println("Student added successfully! Total students: " + count + "\n");
    }

    public List<Student> getAllStudent() {
        System.out.println("Debug: Current count of students = " + count);
        if (count == 0) {
            System.out.println("No students available.\n");
            return new ArrayList<>();
        }

        List<Student> studentList = new ArrayList<>(); // Create a new list to hold students
        for (int i = 0; i < count; i++) {
            studentList.add(students[i]); // Add each student to the list
        }

        return studentList; // Return the list of students
    }

    public Student getStudentByID(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    /*public Student[] getStudentByName(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].getName().equals(name)) {
                return new Student[]{students[i]};
            }
        }
        return null;
    }*/

    public List<Student> getStudentByName(String name) {
        List<Student> matchingStudents = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                matchingStudents.add(students[i]);
            }
        }
        return matchingStudents.isEmpty() ? null : matchingStudents;
    }


    public boolean deleteStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[count - 1] = null; // Clear the last element
                count--;
                return true;
            }
        }

        return false;
    }

    public boolean updateStudent(int id, String name, String birthDate) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                students[i].setName(name);
                students[i].setBirthDate(birthDate);

                return true;
            }
        }

        return false;
    }
}
