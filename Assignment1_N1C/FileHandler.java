package Assignment1_N1C;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public void addData(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write(student.toString()); // Assuming Student has a proper toString method
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Student added successfully to the file...");
    }

    /*public List<Student> loadData() {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\t+");
                if (data.length == 3) {
                    int id = Integer.parseInt(data[0]);  // Parse item ID
                    String name = data[1];  // Item name
                    String birthDate = data[2];
                    Student student = new Student(id, name, birthDate); // Assuming a suitable constructor
                    studentList.add(student);
                }
                System.out.println("Students loaded successfully from the file...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }*/

    public List<Student> loadData() {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Find the index of the last space, which separates birth date from name
                int lastSpaceIndex = line.lastIndexOf(" ");

                // Split the line at the last space: before is name, after is birth date
                if (lastSpaceIndex != -1) {
                    String idAndName = line.substring(0, lastSpaceIndex).trim();
                    String birthDate = line.substring(lastSpaceIndex + 1).trim();

                    // Split the ID and Name (ID is before the first space)
                    String[] idAndNameParts = idAndName.split("\\s+", 2); // Split into 2 parts
                    if (idAndNameParts.length == 2) {
                        int id = Integer.parseInt(idAndNameParts[0].trim());
                        String name = idAndNameParts[1].trim();

                        // Create the Student object and add to the list
                        Student student = new Student(id, name, birthDate);
                        studentList.add(student);
                    }
                }
            }
            System.out.println("Students loaded successfully from the file...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
