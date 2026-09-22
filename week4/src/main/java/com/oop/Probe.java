package com.oop;

public class Probe {
    private int fieldPrivate = 1;
    int fieldDefault = 2; // default (package-private)
    protected int fieldProtected = 3;
    public int fieldPublic = 4;

    public int getFieldPrivate() {
        return fieldPrivate;
    }
}
