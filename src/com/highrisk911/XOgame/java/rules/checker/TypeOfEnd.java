package com.highrisk911.XOgame.java.rules.checker;

public enum TypeOfEnd {
    VICTORY(1000), DRAW(0), DEFEAT(-1000);

    private final int NUMBER;

    TypeOfEnd(int number) {
        this.NUMBER = number;
    }

    public int getNumber() {
        return NUMBER;
    }
}
