package com.highrisk911.XOgame.java.session;


import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.board.BoardInterface;
import com.highrisk911.XOgame.java.players.AI;
import com.highrisk911.XOgame.java.players.Human;
import com.highrisk911.XOgame.java.players.Player;
import com.highrisk911.XOgame.java.rules.GameObserver;
import com.highrisk911.XOgame.java.rules.Jude;

public class GameSession {

    private final boolean firstPlayerDoFirstMove;
    private final Player firstPlayer;
    private final Player secondPlayer;
    //private int size;

    public GameSession() {
        Menu menu = new GameMenu();

        boolean versusAI = menu.isGameVersusAI();
        firstPlayerDoFirstMove = menu.isFirstPlayerDoFirstMove();

        if (firstPlayerDoFirstMove) {
            firstPlayer = new Human(menu.selectPlayerChar());
            if (versusAI) {
                secondPlayer = new AI(chooseChar(firstPlayer), firstPlayer);
            }
                else {
                    secondPlayer = new Human(menu.selectPlayerChar());
            }
        }
        else {
            secondPlayer = new Human(menu.selectPlayerChar());
                if (versusAI){
                    firstPlayer = new AI(chooseChar(secondPlayer), secondPlayer);
                }
                     else {
                         firstPlayer = new Human(menu.selectPlayerChar());
                }
        }
    }

    private char chooseChar(Player player) {
        return switch (player.getPlayerCharacter()) {
            case 'X' -> 'O';
            case 'x' -> 'o';
            case 'o' -> 'x';
            case 'O' -> 'X';
            default -> (char)(player.getPlayerCharacter()+1);
        };
    }

    public void startGame() {
        BoardInterface board = new Board();
        board.getBoardController().initBoard(3);
        GameObserver gameObserver = new Jude();

        while (!gameObserver.isFinish(board)) {
            if (firstPlayerDoFirstMove) {
                board.getBoardViewer().printState();
            }
              board.getBoardController().fillCell(firstPlayer.makeMove(board));
            if (gameObserver.isFinish(board)) {
                board.getBoardViewer().printState();
                break;
            }
              System.out.println();
            if (!firstPlayerDoFirstMove) {
                board.getBoardViewer().printState();
            }
              board.getBoardController().fillCell(secondPlayer.makeMove(board));
            if (gameObserver.isFinish(board)) {
                board.getBoardViewer().printState();
            }
        }
            System.out.println();
            System.out.println(firstPlayer.getPlayerCharacter()+" "+gameObserver.gameState(board,firstPlayer, secondPlayer));
            System.out.println(secondPlayer.getPlayerCharacter()+" "+gameObserver.gameState(board,secondPlayer, firstPlayer));
    }

}
