package com.mm.aungnaingthu.contact;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ContactManager c = new ContactManager(50);
        String option;

        while (true) {
            System.out.println("1. Add new contact");
            System.out.println("2. List all contact");
            System.out.println("3. Search contact");
            System.out.println("4. Edit contact");
            System.out.println("5. Delete contact");
            System.out.println("0. Exit");
            System.out.print("Please enter your option: ");
            option = input.nextLine();

            switch (option) {
                case "1":
                    c.addNewContact();
                    break;
                case "2":
                    c.listAllContact();
                    break;
                case "3":
                    c.searchContact();
                    break;
                case "4":
                    c.editContact();
                    break;
                case "5":
                    c.deleteContact();
                    break;
                case "0":
                    System.out.println("Exit program");
                    System.exit(0);
                default:
                    System.out.println("Invalid input! Try again...");
            }
        }
    }
}
