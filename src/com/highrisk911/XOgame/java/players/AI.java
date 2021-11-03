package com.highrisk911.XOgame.java.players;

import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.board.Cell;
import com.highrisk911.XOgame.java.engineAI.MiniMaxImpl;
import com.highrisk911.XOgame.java.engineAI.MiniMaxInterface;


public class AI implements Player{
    Player player;
    char aiCharacter;

    public AI(char aiCharacter, Player enemy){
        this.aiCharacter = aiCharacter;
        this.player = enemy;
    }

    @Override
    public Cell makeMove(BoardInterface board) {
        MiniMaxInterface miniMax = new MiniMaxImpl(board,this, player);
        return miniMax.doMove();
    }





    @Override
    public char getPlayerCharacter() {
        return aiCharacter;
    }
}
