package com.highrisk911.XOgame.java.rules;


import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.checker.TypeOfEnd;

public interface GameObserver {
    boolean isFinish(BoardInterface board);

    char getWinner(BoardInterface board);

    TypeOfEnd gameState(BoardInterface board, Player player, Player opponent);

    boolean isFull(BoardInterface board);

}
