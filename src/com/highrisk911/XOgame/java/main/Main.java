package com.highrisk911.XOgame.java.main;


import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.cell.Cell;
import com.highrisk911.XOgame.java.engineAI.MiniMaxImpl;
import com.highrisk911.XOgame.java.players.AI;
import com.highrisk911.XOgame.java.players.Human;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.GameObserver;
import com.highrisk911.XOgame.java.rules.Jude;



public class Main {



    public static void main(String[] args) {
        //new GameMenu().selectPlayerChar()//GameMenu gameMenu = new GameMenu();

        //boolean isFirstPlayerDoFirstMove = gameMenu.isFirstPlayerDoFirstMove();
        Player human = new Human('X');

         Player pc = new AI('O',human);
        BoardInterface board = new Board();
        board.getBoardController().initBoard(3);
        GameObserver gameObserver = new Jude();

        while(!gameObserver.isFinish(board)){
                board.getBoardViewer().printState();
                board.getBoardController().fillCell(human.makeMove(board));
                board.getBoardViewer().printState();
            if(gameObserver.isFinish(board))break;

            MiniMaxImpl miniMax = new MiniMaxImpl(pc,human);
            Cell move = miniMax.minimax(board,pc,0,-1000,1000).getMove();

             board.getBoardController().fillCell(move);
                System.out.println();
            if(gameObserver.isFinish(board))board.getBoardViewer().printState();
         }
        System.out.println(gameObserver.gameState(board,human, pc));
    }

}

