package org.example.cs2016.q1;

public class RandomLetterChooser extends RandomStringChooser {

    public RandomLetterChooser(String str) {
        // super({'h', 'e', ..})
        super(getSingleLetters(str));
    }

    public static String[] getSingleLetters(String str) {
        // {'h', 'e', ..}
        String[] arr = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.substring(i, i+1);
        }

        return arr;
    }

    // getNext()
}
