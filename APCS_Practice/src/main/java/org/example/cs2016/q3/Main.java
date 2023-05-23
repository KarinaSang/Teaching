package org.example.cs2016.q3;

public class Main {
    public static void main(String[] args) {
        boolean [][] blackSquares = new boolean [7][7];
        blackSquares[0] = new boolean[]{true, false, false, true, true, true, false, false, false};
        blackSquares[1] = new boolean[]{false, false, false, false, true, false, false, false, false};
        blackSquares[2] = new boolean[]{false, false, false, false, false, false, true, true, true};
        blackSquares[3] = new boolean[]{false, false, true, false, false, false, true, false, false};
        blackSquares[4] = new boolean[]{true, true, true, false, false, false, false, false, false};
        blackSquares[5] = new boolean[]{false, false, false, false, true, false, false, false, false};
        blackSquares[6] = new boolean[]{false, false, false, true, true, true, false, false, true};


        //System.out.println(blackSquares[3][3]);

//        Crossword crossword = new Crossword(blackSquares);
//
//        System.out.println(crossword.toBeLabeled(0, 0, blackSquares));
//        System.out.println(crossword.toBeLabeled(2, 1, blackSquares));
//        System.out.println(crossword.toBeLabeled(2, 0, blackSquares));

    }
}
