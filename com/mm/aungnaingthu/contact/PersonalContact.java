package com.mm.aungnaingthu.contact;

public class PersonalContact extends Contact {
    private String phoneNumber;

    public PersonalContact(String name, String phoneNumber) {
        super(name, ContactType.Personal);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void displayContact() {
        System.out.println(STR."Name: \{getName()}");
        System.out.println(STR."PhoneNumber: \{getPhoneNumber()}");
        System.out.println(STR."Contact Type: \{getType()}");
        System.out.println();
    }
}
