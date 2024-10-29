package com.mm.aungnaingthu.contact;

public class BusinessContact extends Contact{

    private String email;

    public BusinessContact(String name, String email) {
        super(name, ContactType.Business);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void displayContact() {
        System.out.println(STR."Name: \{getName()}");
        System.out.println(STR."Email: \{getEmail()}");
        System.out.println("Contact Type: " + getType());
        System.out.println();
    }
}
