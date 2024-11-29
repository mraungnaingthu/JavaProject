package com.ant.fileHandle;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        inventoryMenu();
    }

    static void inventoryMenu() throws IOException {
        InventoryManager inventoryManager = new InventoryManager();
        Helper h = new Helper();
        Scanner input = new Scanner(System.in);
        h.banner("Inventory Manager");
        System.out.println("1. Add new items");
        System.out.println("2. Get all items");
        System.out.println("3. Get items by ID");
        System.out.println("4. Update items by ID");
        System.out.println("5. Delete items by ID");
        System.out.println("0. Exit");
        System.out.print("Enter your option: ");
        String option = input.nextLine();

        switch (option) {
            case "1":
                inventoryManager.addNewItem();
                break;
            case "2":
                inventoryManager.getAllItem();
                break;
            case "3":
                inventoryManager.getItembyID();
                break;
            case "4":
                inventoryManager.updateItembyID();
                break;
            case "5":
                inventoryManager.deleteItembyID();
                break;
            case "0":
                System.out.println("Program exit...");
                System.exit(0);
            default:
                System.out.println("Invalid option. Try again!");
        }

        inventoryMenu();
    }
}