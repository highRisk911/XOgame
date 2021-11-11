package com.highrisk911.XOgame.java.cell;

public class Cell {
    private final int ROW;
    private final int COLUMN;
    private final char PLAYER_CHAR;

    public Cell(int row, int column, char playerChar) {
        this.ROW = row;
        this.COLUMN = column;
        this.PLAYER_CHAR = playerChar;
    }

    public char getPlayerChar() {
        return PLAYER_CHAR;
    }

    public int getRow() {
        return ROW;
    }

    public int getColumn() {
        return COLUMN;
    }

}
