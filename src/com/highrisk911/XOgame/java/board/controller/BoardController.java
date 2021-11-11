package com.highrisk911.XOgame.java.board.controller;

import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.cell.Cell;

import java.util.Arrays;

public class BoardController implements BoardControllerInterface {
    private final Board BOARD;

    public BoardController(Board board) {
        this.BOARD = board;
    }

    public void initBoard(int size) {
        char[][] startBoard = new char[size][size];

        for (int index = 0; index < startBoard[0].length; index++) {
            Arrays.fill(startBoard[index], BOARD.getStartCharacter());
        }
        BOARD.setBoard(startBoard);
    }

    public void fillCell(Cell cell) {
        char[][] temp = BOARD.getBoard();

        temp[cell.getRow()][cell.getColumn()] = cell.getPlayerChar();
        BOARD.setBoard(temp);
    }
}
