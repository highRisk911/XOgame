package com.highrisk911.XOgame.java.board;

public interface BoardControllerInterface {
    void initBoard(int size, char firstTurnPlayer);

    void fillCell(Cell cell);

    void endTurn(char c);
}
