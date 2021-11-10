package com.highrisk911.XOgame.java.players;

import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.cell.Cell;
import java.util.Scanner;

public class Human implements Player {
    private char humanChar;


    public Human(char charFirstPlayer) {
        this.humanChar = charFirstPlayer;
    }

    @Override
    public Cell makeMove(BoardInterface board){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Free cells:");
        int count = 0;

        for (Cell cell: board.getBoardViewer().getFreeCells()) {
            if(count%board.getBoardViewer().getBoardState().length == 0) System.out.println();
            System.out.print("["+cell.getRow()+"]"+"["+cell.getColumn()+"] ");

            count++;
        }


        System.out.println("\n");
        System.out.println("Put row");
        //keep EXCEPTION
        int row = scanner.nextInt();
        System.out.println("Put column");
        //keep EXCEPTION
        int column = scanner.nextInt();
        if(board.getBoardViewer().getFreeCells().stream().anyMatch((cell -> ((cell.getColumn() == column) && (cell.getRow() == row))))){
            return new Cell(row,column, humanChar);
        }
        return makeMove(board);
    }

    @Override
    public char getPlayerCharacter() {
        return humanChar;
    }
}
