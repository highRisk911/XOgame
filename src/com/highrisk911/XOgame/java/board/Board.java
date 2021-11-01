package com.highrisk911.XOgame.java.board;

import com.highrisk911.XOgame.java.players.Player;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Board {

    private int[][] board;

    public void initBoard(int size){
        board = new int[size][size];
    }

    public void startGame( Player one, Player two){
        initBoard(3);
    }

    @Override
    public String toString() {
        AtomicInteger counter = new AtomicInteger();
        StringBuilder stringBuilder = new StringBuilder("   ");

            for (int i = 0; i < board[0].length ; i++) stringBuilder.append(i+"  ");
                    stringBuilder.append("\n");

                    Arrays.stream(board).forEach((int[] arr)->{stringBuilder.append(counter.getAndIncrement() +" "+Arrays.toString(arr)+"\n");});

        return stringBuilder.toString();
    }
}
