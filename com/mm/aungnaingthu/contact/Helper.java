package com.mm.aungnaingthu.contact;

public class Helper {

    public void banner(String text) {
        printStar(text, text.length());
    }

    private void printStar(String text, int count) {
        System.out.println(text);
        for (int i=0; i<count; i++) {
            System.out.printf("*");
        }
        System.out.println();
    }
}
