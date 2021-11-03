package com.highrisk911.XOgame.java.rules;

public class RuleChecker implements RuleCheckerInterface{

    char winnerCharacter;

    public boolean checkBackDiagonal(char[][] array){
        for (int row = 0, column = array.length-1; row < array.length-1; column--,row++) {
            if(array[row][column] != array[row+1][column-1])return false;
        }
        winnerCharacter = array[0][array.length-1];
        return true;
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
                winnerCharacter = array[row][column];
                return true;
            }
            winColumn = true;
        }
        return false;
    }

    @Override
    public char getWinnerCharacter() {
        return winnerCharacter;
    }

    private boolean checkRow(char[] array){
        for (int i = 0; i < array.length-1; i++) {
            if(array[i]!=array[i+1])return false;
        }
        winnerCharacter = array[0];
        return true;
    }

    public boolean checkDiagonal(char[][] array){
        for (int row = 1, column = 1; row < array.length; column++,row++) {
            if(array[row][column] != array[row-1][column-1])return false;
        }
        winnerCharacter = array[0][0];
        return true;
    }

    @Override
    public boolean checkRows(char[][] array) {
        for (char[] arr: array) {
            if(checkRow(arr))return true;
        }
        return false;
    }
}
