package com.highrisk911.XOgame.java.session;


import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.board.Cell;
import com.highrisk911.XOgame.java.players.AI;
import com.highrisk911.XOgame.java.players.Human;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.GameObserver;
import com.highrisk911.XOgame.java.rules.Jude;

import java.util.Arrays;

public class GameSession {

    public void startGame(){
        GameObserver gameObserver = new Jude();
        Player human = new Human(new GameMenu().selectPlayerChar());
        Player aI = new AI((char)(human.getPlayerCharacter()+1),human);
        BoardInterface board = new Board();
        board.getBoardController().initBoard(3, human.getPlayerCharacter());

        board.getBoardViewer().printState();

     for (Cell cell: board.getBoardViewer().getFreeCells()
             ) {
            System.out.println(cell.getColumn()+" "+cell.getPlayerChar());

        }
        boolean playerDoFirstMove = new GameMenu().isFirstPlayerDoFirstMove();

        board.getBoardViewer().printState();
        if(!playerDoFirstMove)board.getBoardController().fillCell(new Cell(0,0,aI.getPlayerCharacter()));
        else board.getBoardController().fillCell(human.makeMove(board));

        while (!board.getBoardViewer().isFull()){
            board.getBoardViewer().printState();

            if(playerDoFirstMove)board.getBoardController().fillCell(human.makeMove(board));
            else board.getBoardController().fillCell(aI.makeMove(board));
            if(gameObserver.isFinish(board))break;
            board.getBoardViewer().printState();

            if(!playerDoFirstMove)board.getBoardController().fillCell(human.makeMove(board));
            else board.getBoardController().fillCell(aI.makeMove(board));
            if(gameObserver.isFinish(board))break;
        }

        System.out.println(gameObserver.gameState(board, human));
    }


}
