package com.highrisk911.XOgame.java.players;

import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.cell.Cell;
import com.highrisk911.XOgame.java.engineAI.MiniMaxImpl;


public class AI implements Player{
    Player player;
    char aiCharacter;

    public AI(char aiCharacter, Player enemy){
        this.aiCharacter = aiCharacter;
        this.player = enemy;
    }

    @Override
    public Cell makeMove(BoardInterface board) {
        return new MiniMaxImpl(this, player).minimax(board, this, 0,-1000, 1000).getMove();
    }

    @Override
    public char getPlayerCharacter() {
        return aiCharacter;
    }
}
