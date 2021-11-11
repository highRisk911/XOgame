package com.highrisk911.XOgame.java.engineAI;

import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.cell.Cell;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.GameObserver;
import com.highrisk911.XOgame.java.rules.Jude;
import com.highrisk911.XOgame.java.rules.checker.TypeOfEnd;

public class MiniMax {
    private final Player AI;
    private final Player OPPONENT_AI;

    public MiniMax(Player AI, Player opponentAI) {
        this.AI = AI;
        this.OPPONENT_AI = opponentAI;
    }

    public RatedMove minimax(BoardInterface boardState, Player player, int depth, int alpha, int beta) {
        GameObserver jude = new Jude();
        final char INIT_CHAR = '_';

        //init best move & best score
        Cell bestMove = new Cell(-1, -1, player.getPlayerCharacter());
        int bestScore = (player.getPlayerCharacter() == AI.getPlayerCharacter())
                ? TypeOfEnd.DEFEAT.getNumber() : TypeOfEnd.VICTORY.getNumber();

        //the leaf condition for exit from recursion
        if (jude.isFull(boardState) || (TypeOfEnd.DRAW != jude.gameState(boardState, player, OPPONENT_AI))) {
            bestScore = jude.gameState(boardState, AI, OPPONENT_AI).getNumber();
            return new RatedMove(bestScore, bestMove);
        }

        for (Cell currentMove :
                boardState.getBoardViewer().getFreeCells()) {

            boardState.getBoardController().fillCell(new Cell(currentMove.getRow(),
                    currentMove.getColumn(), player.getPlayerCharacter()));

            if (player.getPlayerCharacter() == AI.getPlayerCharacter()) {
                int score = minimax(boardState, OPPONENT_AI, depth + 1, alpha, beta).getScore();

                if (bestScore < score) {
                    bestScore = score - depth * 10;
                    bestMove = new Cell(currentMove.getRow(), currentMove.getColumn(),
                            player.getPlayerCharacter());
                    alpha = Integer.max(alpha, bestScore);
                    boardState.getBoardController().fillCell(
                            new Cell(currentMove.getRow(), currentMove.getColumn(), INIT_CHAR));

                    if (beta <= alpha) {
                        break;
                    }
                }
            } else {
                int score = minimax(boardState, AI, depth + 1, alpha, beta).getScore();

                if (bestScore > score) {
                    bestScore = score + depth * 10;
                    bestMove = new Cell(currentMove.getRow(), currentMove.getColumn(),
                            player.getPlayerCharacter());
                    beta = Integer.min(beta, bestScore);
                    boardState.getBoardController().fillCell(
                            new Cell(currentMove.getRow(), currentMove.getColumn(), INIT_CHAR));

                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            boardState.getBoardController().fillCell(
                    new Cell(currentMove.getRow(), currentMove.getColumn(), INIT_CHAR));
        }
        return new RatedMove(bestScore, bestMove);
    }
}
