package com.highrisk911.XOgame.java.players;

import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.cell.Cell;
import com.highrisk911.XOgame.java.engineAI.MiniMax;
import com.highrisk911.XOgame.java.rules.checker.TypeOfEnd;


public final class AI implements Player {
    private final Player PLAYER;
    private final char AI_CHARACTER;

    public AI(char aiCharacter, Player enemy) {
        AI_CHARACTER = aiCharacter;
        PLAYER = enemy;
    }

    @Override
    public Cell makeMove(BoardInterface board) {
        return new MiniMax(this, PLAYER).minimax(board, this, 0,
                TypeOfEnd.DEFEAT.getNumber(), TypeOfEnd.VICTORY.getNumber()).getMove();
    }

    @Override
    public char getPlayerCharacter() {
        return AI_CHARACTER;
    }
}
