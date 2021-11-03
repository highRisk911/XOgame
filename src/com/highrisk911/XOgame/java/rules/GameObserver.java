package com.highrisk911.XOgame.java.rules;


import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.players.Player;

public interface GameObserver {
    boolean isFinish(BoardInterface board);
    char getWinner(BoardInterface board);
    boolean isDraw(BoardInterface board);
    TypeOfEnd gameState(BoardInterface board, Player player);
}
