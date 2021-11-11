package com.highrisk911.XOgame.java.board;

import com.highrisk911.XOgame.java.board.controller.BoardController;
import com.highrisk911.XOgame.java.board.controller.BoardControllerInterface;
import com.highrisk911.XOgame.java.board.viewer.BoardViewer;
import com.highrisk911.XOgame.java.board.viewer.BoardViewerInterface;

public class Board implements BoardInterface {
    private char[][] board;
    private final char START_CHARACTER = '_';
    private final BoardControllerInterface BOARD_CONTROLLER;
    private final BoardViewerInterface BOARD_VIEWER;

    public Board() {
        BOARD_VIEWER = new BoardViewer(this);
        BOARD_CONTROLLER = new BoardController(this);
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char getStartCharacter() {
        return START_CHARACTER;
    }

    @Override
    public BoardViewerInterface getBoardViewer() {
        return BOARD_VIEWER;
    }

    @Override
    public BoardControllerInterface getBoardController() {
        return BOARD_CONTROLLER;
    }
}
