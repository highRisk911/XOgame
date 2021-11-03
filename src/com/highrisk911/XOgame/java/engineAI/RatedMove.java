package com.highrisk911.XOgame.java.engineAI;

import com.highrisk911.XOgame.java.board.Cell;

public class RatedMove {
    private int score;
    private Cell move;

    public RatedMove(int score, Cell move) {
        this.score = score;
        this.move = move;
    }

    public int getScore() {
        return score;
    }

  /*  public void setScore(int score) {
        this.score = score;
    }*/

    public Cell getMove() {
        return move;
    }

  /*  public void setMove(Cell move) {
        this.move = move;
    }*/
}
