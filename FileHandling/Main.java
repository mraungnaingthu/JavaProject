package FileHandling;

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //Writing user input data to the file

        String userName;
        String userEmail;
        String userPassword;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        userName = input.nextLine();

        System.out.print("Enter user email: ");
        userEmail = input.nextLine();

        System.out.print("Enter user password: ");
        userPassword = input.nextLine();

        File file = new File("C:\\Users\\Aung Naing Thu\\OOP-Projects\\src\\FileHandling\\text.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(STR."\{userName}\t\{userEmail}\t\{userPassword}");

        writer.flush();
        writer.close();

        System.out.println("Data has been written to the file successfully...");

        //Read data from file text.txt and assign to the related variable

        File file1 = new File("C:\\Users\\Aung Naing Thu\\OOP-Projects\\src\\FileHandling\\text.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file1));

        String line = reader.readLine();
        String[] data = line.split("\t");

        String newUserName = data[0];
        String newUserEmail = data[1];
        String newUserPassword = data[2];

        System.out.println(newUserName);
        System.out.println(newUserEmail);
        System.out.println(newUserPassword);

        System.out.println("Data has been taken from the text file...");

        reader.close();
    }

}
