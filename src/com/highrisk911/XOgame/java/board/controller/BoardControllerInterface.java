package com.highrisk911.XOgame.java.board.controller;

import com.highrisk911.XOgame.java.cell.Cell;

public interface BoardControllerInterface {
    void initBoard(int size);

    void fillCell(Cell cell);
}
