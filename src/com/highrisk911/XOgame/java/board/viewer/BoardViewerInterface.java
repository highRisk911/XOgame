package com.highrisk911.XOgame.java.board.viewer;

import com.highrisk911.XOgame.java.cell.Cell;

import java.util.List;


public interface BoardViewerInterface {

    List<Cell> getFreeCells();
    char[][] getBoardState();
    void printState();
}
