package com.highrisk911.XOgame.java.board.viewer;

import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.cell.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardViewer implements BoardViewerInterface {

    private final Board BOARD;

    public BoardViewer(Board board) {
        this.BOARD = board;
    }

    @Override
    public void printState() {
        char[][] temp = BOARD.getBoard();

        for (char[] chars : temp) {
            for (int column = 0; column < temp.length; column++) {
                System.out.print(chars[column] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public char[][] getBoardState() {
        return BOARD.getBoard();
    }

    @Override
    public List<Cell> getFreeCells() {
        List<Cell> freeCells = new ArrayList<>();

        for (int row = 0; row < BOARD.getBoard().length; row++) {
            for (int column = 0; column < BOARD.getBoard().length; column++) {
                if (BOARD.getBoard()[row][column] == BOARD.getStartCharacter()) {
                    freeCells.add(new Cell(row, column, BOARD.getStartCharacter()));
                }
            }
        }

        if (freeCells.isEmpty()) {
            return Collections.emptyList();
        }

        return freeCells;
    }
}
