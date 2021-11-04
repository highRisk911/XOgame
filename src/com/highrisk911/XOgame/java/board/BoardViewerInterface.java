package com.highrisk911.XOgame.java.board;

import java.util.Set;

public interface BoardViewerInterface {

    Set<Cell> getFreeCells();
    char[][] getBoardState();
    char currentTurn();
    boolean isFull();
    void printState();
}
