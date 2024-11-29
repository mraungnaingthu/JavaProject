package com.ant.fileHandle;

public class MyArray {
    private Object[] arr;
    private int itemCount;

    // Constructor with size
    public MyArray(int size) {
        arr = new Object[size];
        itemCount = 0;
    }

    // Get the number of items
    public int getItemCount() {
        return itemCount;
    }

    // Add an item to the array
    public void add(Object data) {
        if (itemCount < arr.length) {
            arr[itemCount] = data;
            itemCount++;
        } else {
            System.out.println("Error: Array index out of bound");
        }
    }

    // Get an item at a specific index
    public Object getArr(int index) {
        if (index >= 0 && index < itemCount) {
            return arr[index];
        } else {
            return null;
        }
    }

    // Check if the array is empty
    public boolean isEmpty() {
        return itemCount == 0;
    }

    // Update an item at a specific index
    public void updateContact(int index, Object newData) {
        if (index >= 0 && index < itemCount) {
            arr[index] = newData;
        } else {
            System.out.println("Error: Array index not found");
        }
    }

    // Remove an item at a specific index
    public void removeContact(int index) {
        if (index >= 0 && index < itemCount) {
            for (int i = index; i < itemCount - 1; i++) {
                arr[i] = arr[i + 1];
            }
            itemCount--;
        } else {
            System.out.println("Error: Array index not found");
        }
    }
}