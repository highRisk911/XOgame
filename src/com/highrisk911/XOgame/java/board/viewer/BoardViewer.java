package com.highrisk911.XOgame.java.board.viewer;

import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.cell.Cell;

import java.util.*;

public class BoardViewer implements BoardViewerInterface{

    private Board board;

    public BoardViewer(Board board){
        this.board = board;
    }


    @Override
    public void printState() {
        char[][] temp = board.getBoard();

        for (int row = 0; row < temp.length  ; row++) {
            for (int column = 0; column < temp.length ; column++) {
                System.out.print(temp[row][column]+" ");
            }
            System.out.println();
        }
    }

    @Override
    public char[][] getBoardState() {
        return board.getBoard();
    }



    @Override
    public List<Cell> getFreeCells(){
        List<Cell> freeCells = new ArrayList<>();

        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if(board.getBoard()[i][j] == board.getSTART_CHARACTER())freeCells.add(new Cell(i,j, board.getSTART_CHARACTER()));
            }
        }
        if(freeCells.isEmpty())return Collections.emptyList();

        return freeCells;
    }
}
