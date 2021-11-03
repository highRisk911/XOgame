package com.highrisk911.XOgame.java.rules;


import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.players.Player;

public class Jude implements GameObserver{

    private RuleCheckerInterface ruleChecker;

    public Jude(){
    ruleChecker =  new RuleChecker();
    }



    @Override
    public boolean isFinish(BoardInterface board) {
        char[][] boardState = board.getBoardViewer().getBoardState();
        return   ( ruleChecker.checkRows(boardState)
                || ruleChecker.checkColumns(boardState)
                || ruleChecker.checkBackDiagonal(boardState)
                || ruleChecker.checkDiagonal(boardState));
    }

    @Override
    public char getWinner(BoardInterface board) {
        if(!isFinish(board))return '\0';
        if(isDraw(board))return '◍';
            return ruleChecker.getWinnerCharacter();
    }

    @Override
    public boolean isDraw(BoardInterface board) {
        return (board.getBoardViewer().isFull() && !isFinish(board));
    }

    @Override
    public TypeOfEnd gameState(BoardInterface board, Player player) {
        if(isDraw(board))return TypeOfEnd.DRAW;
        if(getWinner(board) == player.getPlayerCharacter()) return TypeOfEnd.VICTORY;
        return TypeOfEnd.DEFEAT;
    }


}
