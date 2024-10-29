package com.mm.aungnaingthu.contact;

import javax.xml.transform.Source;
import java.util.Scanner;

public class ContactManager {

    private MyArray contacts;
    private Helper h;
    private Scanner input;
    private int size;

    public ContactManager(int size){
        contacts = new MyArray(size);
        h = new Helper();
        input = new Scanner(System.in);
        this.size = size;
    }

    public void addNewContact() {
        h.banner("Add New Contact");
        String name;
        String contactOption;
        System.out.print("Enter name: ");
        name = input.nextLine();

        while (true) {
            System.out.println("1. Personal Contact");
            System.out.println("2. Business Contact");
            System.out.print("Enter your contact type: ");
            contactOption = input.nextLine();

            Contact contact = null;
            if (contactOption.equals("1")) {
                String phoneNumber;
                System.out.print("Enter phone number: ");
                phoneNumber = input.nextLine();
                contact = new PersonalContact(name, phoneNumber);
            } else if (contactOption.equals("2")) {
                String email;
                System.out.print("Enter email: ");
                email = input.nextLine();
                contact = new BusinessContact(name, email);
            }else{
                System.out.println("Invalid input! Try again...");
            }
            contacts.add(contact);
            System.out.println("Contact just added successfully...");
            break;
        }


    }

    public void listAllContact() {
        h.banner("List All Contact");
        if (contacts.isEmpty()) {
            System.out.println("No contact in the database");
        }else {
            for (int i=0; i<contacts.getItemCount(); i++) {
                Contact contact = (Contact) contacts.getArr(i);
                contact.displayContact();
            }
        }
    }

    public void searchContact() {
        h.banner("Search Contact");
        String searchName;
        MyArray matchContact = new MyArray(size);

        System.out.print("Enter name to search: ");
        searchName = input.nextLine();

        for (int i=0; i<contacts.getItemCount(); i++) {
            Contact contact = (Contact) contacts.getArr(i);
            if (contact.getName().toLowerCase().contains(searchName.toLowerCase())) {
                matchContact.add(contact);
            }
        }

        if (matchContact.isEmpty()) {
            System.out.println("No contact found");
        }else {
            for (int i=0; i< matchContact.getItemCount(); i++) {
                Contact contact = (Contact) matchContact.getArr(i);
                contact.displayContact();
            }
        }

    }

    public void editContact() {
        h.banner("Edit Contact");
        int index = searchByName();
        if (index == -1) {
            System.out.println("Contact not found to edit");
        }else {
            Contact contact = (Contact) contacts.getArr(index);
            contact.displayContact();

            String editName;
            System.out.print("Enter name to edit: ");
            editName = input.nextLine();

            Contact editContact;
            if (contact.getType() == ContactType.Personal) {
                String editPhoneNumber;
                System.out.print("Enter phone number to update: ");
                editPhoneNumber = input.nextLine();
                editContact = new PersonalContact(editName, editPhoneNumber);
            }else{
                String editEmail;
                System.out.print("Enter email to update: ");
                editEmail = input.nextLine();
                editContact = new BusinessContact(editName, editEmail);
            }

            contacts.updateContact(index, editContact);
            System.out.println("Contact is updated successfully...");
        }


    }

    public void deleteContact() {
        h.banner("Delete Contact");
        int index = searchByName();
        if (index == -1) {
            System.out.println("Contact not found to delete");
        }else {
            contacts.removeContact(index);
            System.out.println("Contact has been deleted successfully...");
        }
    }

    public int searchByName() {
        String searchName;
        System.out.print("Enter name to update/delete: ");
        searchName = input.nextLine();

        int contactIndex = -1;

        for(int i=0; i<contacts.getItemCount(); i++) {
            Contact contact = (Contact) contacts.getArr(i);
            if(contact.getName().equalsIgnoreCase(searchName)) {
                contactIndex = i;
            }
        }
        return contactIndex;
    }
}
