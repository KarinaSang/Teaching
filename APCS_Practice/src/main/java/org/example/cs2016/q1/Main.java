package org.example.cs2016.q1;

public class Main {
    public static void main(String[] args) {
        RandomLetterChooser letterChooser = new RandomLetterChooser("helloworld");

        for (int i = 0; i < 20; i++) {
            System.out.println(letterChooser.getNext());
        }

    }
}
