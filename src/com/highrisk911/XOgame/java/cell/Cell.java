package com.highrisk911.XOgame.java.cell;

public class Cell {
    private final int row;
    private final int column;
    private final char playerChar;

    public Cell(int row, int column, char playerChar) {
        this.row = row;
        this.column = column;
        this.playerChar = playerChar;
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
