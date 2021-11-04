package com.highrisk911.XOgame.java.board;


public class Board implements BoardInterface {

    private char currentTurn;
    private char[][] board;
    private final char START_CHARACTER = '_';

    private BoardControllerInterface boardController;
    private BoardViewerInterface boardViewer;

    public Board(){
        boardViewer = new BoardViewer(this);
        boardController = new BoardController(this);
    }

    public char getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(char currentTurn) {
        this.currentTurn = currentTurn;
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
