package com.oop;

import java.util.ArrayList;
import java.util.List;

public class ArrList {
    public static void main(String[] args) {
        List<String> contacts = new ArrayList<>();
        contacts.add("Mary - 091");
        contacts.add("Jacob - 092");
        contacts.add("Ben - 093");
        contacts.add(1, "Alex - 097");

        contacts.add("Fred - 094");
        System.out.println("Before deleting Fred: " + contacts);
        contacts.remove("Fred - 094");
        System.out.println("After deleting Fred: " + contacts);
        System.out.println(contacts);

    }
}
