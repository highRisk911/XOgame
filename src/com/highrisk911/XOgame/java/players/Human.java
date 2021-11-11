package com.highrisk911.XOgame.java.players;

import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.cell.Cell;

import java.util.Scanner;

public final class Human implements Player {
    private final char HUMAN_CHAR;

    public Human(char charFirstPlayer) {
        HUMAN_CHAR = charFirstPlayer;
    }

    @Override
    public Cell makeMove(BoardInterface board) {

        int row;
        int column;
        int count = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Free cells:");

        for (Cell cell
                : board.getBoardViewer().getFreeCells()) {
            if ((count % board.getBoardViewer().getBoardState().length) == 0) {
                System.out.println();
            }
            System.out.print("[" + cell.getRow() + "]" + "[" + cell.getColumn() + "] ");
            count++;
        }

        System.out.println("\n");
        System.out.println("Put row");
        //KEEP EXCEPTION :C
        row = scanner.nextInt();
        System.out.println("Put column");
        column = scanner.nextInt();

        if (board.getBoardViewer().getFreeCells().stream().anyMatch(
                (cell ->
                        ((cell.getColumn() == column) && (cell.getRow() == row))))) {
            return new Cell(row, column, HUMAN_CHAR);
        }
        //recursion is a very hungry to performance idea, but easiest way to solve crazy user problem
        return makeMove(board);
    }

    @Override
    public char getPlayerCharacter() {
        return HUMAN_CHAR;
    }
}
