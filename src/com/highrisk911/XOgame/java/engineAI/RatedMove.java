package com.highrisk911.XOgame.java.engineAI;

import com.highrisk911.XOgame.java.cell.Cell;

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

    public Cell getMove() {
        return move;
    }

}
