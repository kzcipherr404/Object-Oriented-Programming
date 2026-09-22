package com.oop;

public class Main {
    public static void main(String[] args) {
        try {
            String[] contact = new String[1];
            contact[0] = "Mary - 091";
            int contactArrayLength = contact.length;
            String[] contacts = new String[contactArrayLength + 1];
            System.arraycopy(contact, 0, contacts, 0, contactArrayLength);
            contacts[1] = "Jacob - 092";
            for (String c : contacts) {
                System.out.println(c);

            int currentLength = contacts.length;
            String[] contactsV2 = new String[currentLength + 1];
            System.arraycopy(contacts, 0, contactsV2, 0, currentLength);
            contactsV2[currentLength] = "Ben - 093";
            for (String c : contactsV2) {
                System.out.println(c);
}   
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Problem in array: " + e.getMessage());
        }
    }
}

