package com.highrisk911.XOgame.java.cell;

public class Cell {
    private int row;
    private int column;
    private char playerChar;

    public Cell(int row, int column, char playerChar) {
        this.row = row;
        this.column = column;
        this.playerChar = playerChar;
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }



    public char getPlayerChar() {
        return playerChar;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setPlayerChar(char playerChar) {
        this.playerChar = playerChar;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
