package com.highrisk911.XOgame.java.board;


import com.highrisk911.XOgame.java.board.controller.BoardController;
import com.highrisk911.XOgame.java.board.controller.BoardControllerInterface;
import com.highrisk911.XOgame.java.board.viewer.BoardViewer;
import com.highrisk911.XOgame.java.board.viewer.BoardViewerInterface;

public class Board implements BoardInterface {


    private char[][] board;
    private final char START_CHARACTER = '_';

    private BoardControllerInterface boardController;
    private BoardViewerInterface boardViewer;

    public Board(){
        boardViewer = new BoardViewer(this);
        boardController = new BoardController(this);
    }

    public Board(char[][] board) {
        this.board = board;
        boardViewer = new BoardViewer(this);
        boardController = new BoardController(this);
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char getSTART_CHARACTER() {
        return START_CHARACTER;
    }

    @Override
    public BoardViewerInterface getBoardViewer() {
        return boardViewer;
    }

    @Override
    public BoardControllerInterface getBoardController() {
        return boardController;
    }
}
