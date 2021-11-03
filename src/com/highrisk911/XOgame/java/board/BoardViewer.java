package com.highrisk911.XOgame.java.board;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BoardViewer implements BoardViewerInterface{

    private Board board;

    public BoardViewer(Board board){
        this.board = board;
    }
    public boolean isFull(){
        return Arrays.stream(board.getBoard()).anyMatch((chars -> {
            boolean isFull = true;
            for (Character c: chars) {
                if(c.equals(board.getSTART_CHARACTER()))isFull = false;
            }
            return isFull;
        }));
    }

    @Override
    public char[][] getBoardState() {
        return board.getBoard();
    }

    @Override
    public char currentTurn() {
        return board.getCurrentTurn();
    }

    @Override
    public Set<Cell> getFreeCells(){
        if(isFull())return null;
        Set<Cell> freeCells = new HashSet();

        for (int i = 0; i < board.getBoard()[0].length; i++) {
            for (int j = 0; j < board.getBoard()[0].length; j++) {
                if(board.getBoard()[i][j] == (board.getCurrentTurn()))freeCells.add(new Cell(i,j, board.getSTART_CHARACTER()));
            }
        }
        return freeCells;
    }
}
