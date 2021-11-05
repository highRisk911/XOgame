package com.highrisk911.XOgame.java.main;


import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.board.Cell;
import com.highrisk911.XOgame.java.players.AI;
import com.highrisk911.XOgame.java.players.Human;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.TypeOfEnd;
import com.highrisk911.XOgame.java.session.GameMenu;
import com.highrisk911.XOgame.java.session.GameSession;

import java.util.Arrays;
import java.util.Set;

public class Main {



    public static void main(String[] args) {

        Player human = new Human(new GameMenu().selectPlayerChar());
        Player aI = new AI((char)(human.getPlayerCharacter()+1),human);
        BoardInterface board = new Board();
        board.getBoardController().initBoard(3, human.getPlayerCharacter());
       Set<Cell> cells = board.getBoardViewer().getFreeCells();
        for (Cell cell: cells
             ) {
            System.out.println(cell.getRow()+"."+cell.getColumn()+"="+cell.getPlayerChar());
        }
    }

}


