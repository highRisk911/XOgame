package com.highrisk911.XOgame.java.rules;


import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.checker.RuleChecker;
import com.highrisk911.XOgame.java.rules.checker.RuleCheckerInterface;
import com.highrisk911.XOgame.java.rules.checker.TypeOfEnd;


public class Jude implements GameObserver{

    private RuleCheckerInterface ruleChecker;
    private char testChar;

    public Jude(){
    ruleChecker =  new RuleChecker();
    }

    @Override
    public boolean isFinish(BoardInterface board) {
        char[][] boardState = board.getBoardViewer().getBoardState();
        return (ruleChecker.checkRows(boardState)
                ||  ruleChecker.checkColumns(boardState)
                ||  ruleChecker.checkBackDiagonal(boardState)
                ||  ruleChecker.checkDiagonal(boardState)
                ||  ruleChecker.isFull(boardState));
    }

    @Override
    public char getWinner(BoardInterface board) {
            return ruleChecker.getWinnerCharacter();
    }

    @Override
    public TypeOfEnd gameState(BoardInterface board, Player player , Player opponent) {
        if(getWinner(board) == player.getPlayerCharacter()) return TypeOfEnd.VICTORY;
        if(getWinner(board) == opponent.getPlayerCharacter())return TypeOfEnd.DEFEAT;
        return TypeOfEnd.DRAW;
    }


}
