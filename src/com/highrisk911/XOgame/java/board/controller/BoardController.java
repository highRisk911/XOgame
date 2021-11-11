package com.highrisk911.XOgame.java.board.controller;

import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.cell.Cell;

import java.util.Arrays;

public class BoardController implements BoardControllerInterface {
    private final Board board;

    public BoardController(Board board) {
        this.board = board;
    }

    public void initBoard(int size) {
        char[][] startBoard = new char[size][size];
        for (int index = 0; index < startBoard[0].length; index++) {
            Arrays.fill(startBoard[index], board.getSTART_CHARACTER());
        }
        board.setBoard(startBoard);
    }

    public void fillCell(Cell cell) {
        char[][] temp = board.getBoard();
        temp[cell.getRow()][cell.getColumn()] = cell.getPlayerChar();
        board.setBoard(temp);
    }
}
