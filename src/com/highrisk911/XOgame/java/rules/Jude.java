package com.highrisk911.XOgame.java.rules;


import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.checker.RuleChecker;
import com.highrisk911.XOgame.java.rules.checker.RuleCheckerInterface;
import com.highrisk911.XOgame.java.rules.checker.TypeOfEnd;


public class Jude implements GameObserver {

    private final RuleCheckerInterface RULE_CHECKER;

    public Jude() {
        RULE_CHECKER = new RuleChecker();
    }

    @Override
    public boolean isFinish(BoardInterface board) {
        char[][] boardState = board.getBoardViewer().getBoardState();
        return (RULE_CHECKER.checkRows(boardState)
                || RULE_CHECKER.checkColumns(boardState)
                || RULE_CHECKER.checkBackDiagonal(boardState)
                || RULE_CHECKER.checkDiagonal(boardState)
                || isFull(board));
    }

    @Override
    public boolean isFull(BoardInterface board) {
        char[][] boardState = board.getBoardViewer().getBoardState();
        for (int row = 0; row < boardState[0].length; row++) {
            for (int column = 0; column < boardState[0].length; column++) {
                if (boardState[row][column] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public char getWinner(BoardInterface board) {
        isFinish(board);
        return RULE_CHECKER.getWinnerCharacter();
    }

    @Override
    public TypeOfEnd gameState(BoardInterface board, Player player, Player opponent) {
        if (getWinner(board) == player.getPlayerCharacter()) {
            return TypeOfEnd.VICTORY;
        }
        if (getWinner(board) == opponent.getPlayerCharacter()) {
            return TypeOfEnd.DEFEAT;
        }
        return TypeOfEnd.DRAW;
        /*
         * return (getWinner(board) == player.getPlayerCharacter())? TypeOfEnd.VICTORY :
         *  (getWinner(board) == opponent.getPlayerCharacter())?TypeOfEnd.DEFEAT:TypeOfEnd.DRAW
         * and can be replaced with switch-case construction
         */
    }


}
