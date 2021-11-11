package com.highrisk911.XOgame.java.engineAI;

import com.highrisk911.XOgame.java.cell.Cell;

public class RatedMove {
    private final int SCORE;
    private final Cell MOVE;

    public RatedMove(int score, Cell move) {
        this.SCORE = score;
        this.MOVE = move;
    }

    public int getScore() {
        return SCORE;
    }

    public Cell getMove() {
        return MOVE;
    }

}
