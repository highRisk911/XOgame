package com.highrisk911.XOgame.java.rules.checker;


public class RuleChecker implements RuleCheckerInterface{

    private char winnerCharacter;
    private final char INIT_CHAR = '_';

    public boolean checkBackDiagonal(char[][] array){
        for (int row = 0, column = array.length-1; row < array.length-1; column--,row++) {
            if(array[row][column] != array[row+1][column-1]) {
                return false;
            }
        }
       if (array[0][array.length-1] != INIT_CHAR) {
           winnerCharacter = array[0][array.length - 1];
           return true;
       }
       return false;
    }

    public boolean checkColumns(char[][] array){
        boolean winColumn = true;
        int column;
        int row;
        for (column = 0 ;column < array.length; column++) {
            for (row = 1; row < array.length ; row++) {
                if (array[row][column] != array[row-1][column]) {
                    winColumn = false;
                }
            }
            if (winColumn) {
                winnerCharacter = array[row-1][column];
                if(array[row-1][column] != INIT_CHAR){
                    return true;
                }
            }
            winColumn = true;
        }
        return false;
    }

    @Override
    public char getWinnerCharacter() {
        return winnerCharacter;
    }

    private boolean checkRow(char[] array) {
        for (int index = 0; index < array.length-1; index++) {
            if (array[index]!=array[index+1]) {
                return false;
            }
        }
        if (array[0] != INIT_CHAR) {
            winnerCharacter = array[0];
                return true;
        }
         return false;
    }

    public boolean checkDiagonal(char[][] array) {
        for (int row = 1, column = 1; row < array.length; column++,row++) {
            if (array[row][column] != array[row-1][column-1]) {
                return false;
            }
        }
        if (array[0][0] != INIT_CHAR) {
            winnerCharacter = array[0][0];
            return true;
        }
        else return false;
    }

    @Override
    public boolean checkRows(char[][] array) {
        for (char[] arr: array) {
            if (checkRow(arr)) {
                return true;
            }
        }
        return false;
    }
}
