package com.highrisk911.XOgame.java.players;

import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.board.Cell;


public interface Player {
    Cell makeMove(BoardInterface board);
    char getPlayerCharacter();
}
