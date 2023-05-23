package org.example.cs2016.q3;

public class Crossword {
    private Square[][] puzzle;

    public Crossword(boolean[][] blackSquares) {

    }

    public boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
        // cur square: row r, col c, blackSquares[r][c]
        // top: blackSquares[r-1][c], if r-1 < 0, no top square exists
        // left: blackSquares[r][c-1], if c-1 < 0, no left square
        return !blackSquares[r][c]
                && ((r-1 < 0 || blackSquares[r-1][0]) || (c-1 < 0 || blackSquares[r][c-1])) ;
    }
}
