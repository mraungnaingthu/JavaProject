package com.ant.fileHandle;

public class Item {

    private int id;
    private String name;
    private float price;

    // Constructor
    public Item(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Display item as a string (e.g., "1 Widget 19.99")
    public String displayItem() {
        return STR."\{id} \{name} \{price}";
    }
}