package com.highrisk911.XOgame.java.players;

import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.cell.Cell;
import java.util.InputMismatchException;
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
        int row = -1;
        int column = -1;
        try {
            row = scanner.nextInt();
            System.out.println("Put column");
             column = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Invalid input");
            System.out.println("I'll wait until you come to adequate");
            if (scanner.hasNext()){
                row = scanner.nextInt();
                if (scanner.hasNext()) column = scanner.nextInt();
            }

            //no idea how infinity wait before user put valid data into input

        }
        scanner.close();

        int finalColumn = column;
        int finalRow = row;
        if(board.getBoardViewer().getFreeCells().stream().anyMatch((cell -> ((cell.getColumn() == finalColumn) && (cell.getRow() == finalRow))))){
            return new Cell(row,column, humanChar);
        }


        //recursion is a very hungry to performance idea, but easiest way to solve crazy user problem
        return makeMove(board);
    }

    @Override
    public char getPlayerCharacter() {
        return humanChar;
    }
}
