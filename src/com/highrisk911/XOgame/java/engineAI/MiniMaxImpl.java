package com.highrisk911.XOgame.java.engineAI;


import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.board.Cell;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.Jude;
import com.highrisk911.XOgame.java.rules.TypeOfEnd;

public class MiniMaxImpl implements MiniMaxInterface {

    private Board board;
    private Player AI;
    private Player opponentAI;
    private Jude jude;




    public MiniMaxImpl(BoardInterface board, Player AI, Player opponentAI) {
        this.board = new Board();
        this.board.setBoard(board.getBoardViewer().getBoardState());

        this.AI = AI;
        this.opponentAI = opponentAI;
        this.jude = new Jude();
    }


    public RatedMove minimax(BoardInterface board, char marker, int depth, int alpha, int beta) {
        Cell bestMove = new Cell(-1,-1);
        int bestScore = (marker==AI.getPlayerCharacter())?TypeOfEnd.DEFEAT.getNumber():TypeOfEnd.VICTORY.getNumber();


        if(board.getBoardViewer().isFull() || (AI.getPlayerCharacter() == jude.getWinner(board))) {
            bestScore = jude.gameState(board,AI).getNumber();
            return new RatedMove(bestScore, bestMove);
        }



        for (Cell currentMove : board.getBoardViewer().getFreeCells()){
            board.getBoardController().fillCell(currentMove);

            if(marker == AI.getPlayerCharacter()){
                int score = minimax(board, opponentAI.getPlayerCharacter(), depth+1, alpha,beta).getScore();
                if(bestScore < score){
                    bestScore = score - depth*10;
                    bestMove = currentMove;

                    alpha = Integer.max(alpha, bestScore);

                    board.getBoardController().fillCell(currentMove);

                    if(beta <= alpha){
                        break;
                    }
                }
            }
            else{
                int score = minimax(board, AI.getPlayerCharacter(), depth+1, alpha,beta).getScore();

                if(bestScore > score){
                    bestScore = score + depth*10;
                    bestMove = currentMove;

                    beta = Integer.min(beta, bestScore);


                    board.getBoardController().fillCell(currentMove);


                    if(beta <= alpha)break;
                }
            }


            board.getBoardController().fillCell(currentMove);

        }

        return new RatedMove(bestScore, bestMove);
    }

    @Override
    public Cell doMove() {
        return minimax(board, AI.getPlayerCharacter(), 0, TypeOfEnd.DEFEAT.getNumber(), TypeOfEnd.VICTORY.getNumber()).getMove();
    }

}
