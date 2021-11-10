package com.highrisk911.XOgame.java.rules.checker;

public enum TypeOfEnd {
    VICTORY(1000), DRAW(0), DEFEAT(-1000), UNFINISHED(1337);

    private int number;

    TypeOfEnd (int number){
        this.number =number;
    }

    public int getNumber(){
        return number;
    }
}
