package com.highrisk911.XOgame.java.board;

public class BoardController implements BoardControllerInterface{
    private Board board;

    public BoardController(Board board) {
        this.board = board;
    }

    public void initBoard(int size, char firstTurnPlayer){
        board.setBoard(new char[size][size]);
        board.setCurrentTurn(firstTurnPlayer);
    }

    public void fillCell(Cell cell){
        char[][] temp = board.getBoard();
        temp[cell.getRow()][cell.getColumn()] = cell.getPlayerChar();
        board.setBoard(temp);

    }

    @Override
    public void endTurn(char c) {
        board.setCurrentTurn(c);
    }

}
