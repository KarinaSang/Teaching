package org.example.cs2016.q1;

import java.util.ArrayList;

public class RandomStringChooser {
    private ArrayList<String> list; // {'h', 'e', ..}
    public RandomStringChooser(String[] wordArray) {
        list = new ArrayList<>();

        for (String word: wordArray) {
            list.add(word);
        }
    }

    public String getNext() {
        if (list.size() == 0) {
            return "NONE";
        }

        // 0 <= x < 1
        // 0 <= x * list.size() < list.size()
        // 0 <= newX <= list.size()-1
        int randomIndex = (int) (Math.random() * list.size());

        String removedWord = list.remove(randomIndex);
        return removedWord;
    }
}