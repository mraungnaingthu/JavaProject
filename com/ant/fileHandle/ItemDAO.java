package com.ant.fileHandle;

import java.io.*;

public class ItemDAO {

    // Add a new item to the file
    public void addItem(Item item) throws IOException {
        MyArray items = loadAllDataFromFile();  // Load all items from the file
        items.add(item);  // Add the new item to the array
        writeAllDataToFile(items);  // Save the updated list back to the file
    }

    // Get all items (not implemented)
    public MyArray getItems() throws IOException {
        return loadAllDataFromFile();  // Placeholder
    }

    // Get a specific item by its ID (not implemented)
    public Item getItem(int id) throws IOException {
        MyArray items = loadAllDataFromFile();
        for (int i=0; i<items.getItemCount(); i++) {
            Item item = (Item) items.getArr(i);
            if (id == item.getId()) {
                return item;
            }
        }
        return null;  // Placeholder
    }

    // Update an existing item (not implemented)
    public void updateItem(Item item) throws IOException {
        MyArray items = loadAllDataFromFile();
        for (int i=0; i<items.getItemCount(); i++) {
            Item uItem = (Item) items.getArr(i);
            if(item.getId() == uItem.getId()) {
                uItem.setId(item.getId());
                uItem.setName(item.getName());
                uItem.setPrice(item.getPrice());
                break;
            }
        }
        writeAllDataToFile(items);
    }

    // Delete an item by its ID (not implemented)
    public void deleteItem(int id) throws IOException {
        MyArray items = loadAllDataFromFile();

        for (int i=0; i<items.getItemCount(); i++) {
            Item dItem = (Item) items.getArr(i);
            if(dItem.getId() == id) {
                items.removeContact(i);
                break;
            }
        }
        writeAllDataToFile(items);
    }

    // Write all data to the file
    private void writeAllDataToFile(MyArray items) throws IOException {
        if (!items.isEmpty()) {
            File file = new File("C:\\Users\\Aung Naing Thu\\OOP-Projects\\src\\com\\ant\\fileHandle\\data");
            BufferedWriter writer = null;

            try {
                writer = new BufferedWriter(new FileWriter(file));  // Create writer

                // Write each item to the file
                for (int i = 0; i < items.getItemCount(); i++) {
                    Item item = (Item) items.getArr(i);  // Get the item from array
                    writer.write(item.displayItem());  // Write item data to file
                    writer.write("\n");  // Add newline after each item
                }

            } finally {
                if (writer != null) {
                    writer.close();  // Ensure the writer is closed
                }
            }
        }
    }

    // Load all items from the file
    private MyArray loadAllDataFromFile() throws IOException {
        MyArray items = new MyArray(50);
        File file = new File("C:\\Users\\Aung Naing Thu\\OOP-Projects\\src\\com\\ant\\fileHandle\\data");

        if (file.exists()) {  // Ensure the file exists
            BufferedReader reader = new BufferedReader(new FileReader(file));  // Create reader
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+");  // Split by spaces or tabs

                if (data.length == 3) {  // Ensure correct data format
                    try {
                        int id = Integer.parseInt(data[0]);  // Parse item ID
                        String name = data[1];  // Item name
                        float price = Float.parseFloat(data[2]);  // Item price

                        Item item = new Item(id, name, price);  // Create new item
                        items.add(item);  // Add item to the list
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing line: " + line);  // Handle errors in parsing
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);  // Invalid line format
                }
            }

            reader.close();  // Close the reader after reading the file
        } else {
            System.out.println("Data file does not exist.");
        }

        return items;
    }
}