package com.highrisk911.XOgame.java.rules;

public interface RuleCheckerInterface {

    boolean checkBackDiagonal(char[][] array);
    boolean checkDiagonal(char[][] array);
    boolean checkRows(char[][] array);
    boolean checkColumns(char[][] array);
    char getWinnerCharacter();
}
