package com.highrisk911.XOgame.java.session;


import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.players.AI;
import com.highrisk911.XOgame.java.players.Human;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.GameObserver;
import com.highrisk911.XOgame.java.rules.Jude;

public class GameSession {
    private Menu menu;
    private boolean versusAI;
    private boolean firstPlayerDoFirstMove;
    private Player firstPlayer;
    private Player secondPlayer;

    public GameSession(Player firstPlayer, Player secondPlayer) {
        menu = new GameMenu();
        versusAI = menu.isGameVersusAI();
        firstPlayerDoFirstMove = menu.isFirstPlayerDoFirstMove();

        if(firstPlayerDoFirstMove){
            firstPlayer = new Human(menu.selectPlayerChar());
            if (versusAI) secondPlayer = new AI((char) (firstPlayer.getPlayerCharacter()+2),firstPlayer);
                else secondPlayer = new Human(menu.selectPlayerChar());
        }
        else{
            secondPlayer = new Human(menu.selectPlayerChar());
                if (versusAI) firstPlayer = new AI((char) (secondPlayer.getPlayerCharacter()+2),secondPlayer);
                     else firstPlayer = new Human(menu.selectPlayerChar());
        }
    }

    public void startGame(){
        BoardInterface board = new Board();
        board.getBoardController().initBoard(3);
        GameObserver gameObserver = new Jude();

        while(!gameObserver.isFinish(board)){

                board.getBoardViewer().printState();
                board.getBoardController().fillCell(firstPlayer.makeMove(board));
                board.getBoardViewer().printState();

            if(gameObserver.isFinish(board))break;

            board.getBoardController().fillCell(secondPlayer.makeMove(board));

            if(gameObserver.isFinish(board))board.getBoardViewer().printState();
        }
        System.out.println(gameObserver.gameState(board,firstPlayer, secondPlayer));
    }

}
