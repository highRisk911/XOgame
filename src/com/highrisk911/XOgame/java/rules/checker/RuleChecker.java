package com.highrisk911.XOgame.java.rules.checker;


public class RuleChecker implements RuleCheckerInterface{

    private char winnerCharacter;
    private final char INIT_CHAR = '_';

    public boolean checkBackDiagonal(char[][] array){
        for (int row = 0, column = array.length-1; row < array.length-1; column--,row++) {
            if(array[row][column] != array[row+1][column-1])return false;
        }

       if(array[0][array.length-1] != INIT_CHAR) {

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
                if(array[row][column] != array[row-1][column])winColumn = false;
            }
            if(winColumn){
                winnerCharacter = array[row-1][column];
                if(array[row-1][column] != INIT_CHAR) return true;
            }
            winColumn = true;
        }
        return false;
    }

    @Override
    public char getWinnerCharacter() {
        return winnerCharacter;
    }

    @Override
    public boolean isFull(char[][] array) {
        for (int row = 0; row < array[0].length ; row++) {
            for (int column = 0; column < array[0].length; column++) {
                if(array[row][column] == INIT_CHAR)return false;
            }
        }
        return true;
    }

    private boolean checkRow(char[] array){
        for (int i = 0; i < array.length-1; i++) {
            if(array[i]!=array[i+1])return false;
        }
        if(array[0] != INIT_CHAR){
            winnerCharacter = array[0];
                return true;
        }
         return false;
    }

    public boolean checkDiagonal(char[][] array){
        for (int row = 1, column = 1; row < array.length; column++,row++) {
            if(array[row][column] != array[row-1][column-1])return false;
        }
        if(array[0][0] != INIT_CHAR){
            winnerCharacter = array[0][0];
            return true;
        }
        else return false;
    }

    @Override
    public boolean checkRows(char[][] array) {
        for (char[] arr: array) {
            if(checkRow(arr))return true;
        }
        return false;
    }
}
