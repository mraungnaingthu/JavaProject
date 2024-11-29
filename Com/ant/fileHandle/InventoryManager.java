package com.ant.fileHandle;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryManager {

    private Helper h;
    private Scanner input;
    private ItemDAO itemDAO;

    public InventoryManager() {
        h = new Helper();
        input = new Scanner(System.in);
        itemDAO = new ItemDAO();
    }

    public void addNewItem() throws IOException {
        h.banner("Add new item");
        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter price: ");
        float price = input.nextFloat();

        Item item = new Item(idAutoGenerate(), name, price);
        itemDAO.addItem(item);
    }

    public void getAllItem() throws IOException {
        h.banner("Get all items");
        MyArray items = itemDAO.getItems();
        if (items.isEmpty()) {
            System.out.println("There is no item to show");
        }else {
            for (int i=0; i<items.getItemCount(); i++) {
                Item item = (Item) items.getArr(i);
                System.out.println(item.displayItem());
            }
        }
        // Logic to get all items
    }

    public void getItembyID() throws IOException {
        h.banner("Get items by ID");

        while (true) {
            try {
                System.out.print("Enter id to search: ");
                int id = input.nextInt();
                input.nextLine();
                Item item = searchItemById(id);
                if (item == null) {
                    System.out.println("Item not found with this id");
                    break;
                }else{
                    System.out.println(item.displayItem());
                    break;
                }
                // Logic to get error
            }catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer input\n");
                input.nextLine();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void updateItembyID() throws IOException {
        h.banner("Update items by ID");
        System.out.print("Enter id to update item: ");
        int id = input.nextInt();

        Item item = searchItemById(id);

        if (item == null) {
            System.out.println("Item not found to update with ID");
        }else {
            System.out.println(item.displayItem());
            input.nextLine();
            System.out.print("Enter name to update: ");
            String name = input.nextLine();
            System.out.print("Enter price to update: ");
            float price = input.nextFloat();

            itemDAO.updateItem(new Item(id, name, price));

            System.out.println("Item updated successfully...");
        }
    }

    public void deleteItembyID() throws IOException {
        h.banner("Delete items by ID");
        System.out.print("Enter id to delete item: ");
        int id = input.nextInt();

        Item item = searchItemById(id);

        if (item == null) {
            System.out.println("Item not found to delete with this ID");
        }else {
            System.out.println(item.displayItem());
            System.out.print("Are you sure to delete (Y/N): ");

            char yOrn = input.next().charAt(0);
            if (yOrn == 'y' || yOrn == 'Y') {
                itemDAO.deleteItem(item.getId());
                System.out.println("Item deleted successfully...");
            }else if (yOrn == 'n' || yOrn == 'N'){
                System.out.println("Item did not delete...");
            }else {
                System.out.println("Invalid input. Try again!");
            }
        }
    }

    private int idAutoGenerate() throws IOException {
        MyArray items = itemDAO.getItems();
        if (!items.isEmpty()) {
            Item lastItem = (Item) items.getArr(items.getItemCount() - 1);
            return lastItem.getId() + 1;
        }
        return 1;
    }

    private Item searchItemById(int searchID) throws IOException {
        Item item = null;
        MyArray items = itemDAO.getItems();

        for (int i=0; i<items.getItemCount(); i++) {
            Item sItem = (Item) items.getArr(i);
            if(sItem.getId() == searchID) {
                item = sItem;
                break;
            }
        }
        return item;
    }
}