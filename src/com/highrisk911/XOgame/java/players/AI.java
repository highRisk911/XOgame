package com.highrisk911.XOgame.java.players;

import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.cell.Cell;
import com.highrisk911.XOgame.java.engineAI.MiniMax;


public class AI implements Player{
    private final Player player;
    private final char aiCharacter;

    public AI(char aiCharacter, Player enemy) {
        this.aiCharacter = aiCharacter;
        this.player = enemy;
    }

    @Override
    public Cell makeMove(BoardInterface board) {
        return new MiniMax(this, player).minimax(board, this, 0,-1000, 1000).getMove();
    }

    @Override
    public char getPlayerCharacter() {
        return aiCharacter;
    }
}
