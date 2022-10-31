package main.finalrpggame;

public enum Direction {
    LEFT, UP, DOWN, RIGHT;

    public static Direction getNewDirection() {
        return Direction.values()[(int)(Math.random() * 4)];
    }
}
