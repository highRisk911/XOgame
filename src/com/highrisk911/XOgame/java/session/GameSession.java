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
    private final Player FIRST_PLAYER;
    private final Player SECOND_PLAYER;

    public GameSession() {
        Menu menu = new GameMenu();
        boolean versusAI = menu.isGameVersusAI();
        firstPlayerDoFirstMove = menu.isFirstPlayerDoFirstMove();

        if (firstPlayerDoFirstMove) {
            FIRST_PLAYER = new Human(menu.selectPlayerChar());
            if (versusAI) {
                SECOND_PLAYER = new AI(chooseChar(FIRST_PLAYER), FIRST_PLAYER);
            } else {
                SECOND_PLAYER = new Human(menu.selectPlayerChar());
            }
        } else {
            SECOND_PLAYER = new Human(menu.selectPlayerChar());
            if (versusAI) {
                FIRST_PLAYER = new AI(chooseChar(SECOND_PLAYER), SECOND_PLAYER);
            } else {
                FIRST_PLAYER = new Human(menu.selectPlayerChar());
            }
        }
    }

    private char chooseChar(Player player) {
        return switch (player.getPlayerCharacter()) {
            case 'X' -> 'O';
            case 'x' -> 'o';
            case 'o' -> 'x';
            case 'O' -> 'X';
            default -> (char) (player.getPlayerCharacter() + 1);
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
            board.getBoardController().fillCell(FIRST_PLAYER.makeMove(board));
            if (gameObserver.isFinish(board)) {
                board.getBoardViewer().printState();
                break;
            }
            System.out.println();
            if (!firstPlayerDoFirstMove) {
                board.getBoardViewer().printState();
            }
            board.getBoardController().fillCell(SECOND_PLAYER.makeMove(board));
            if (gameObserver.isFinish(board)) {
                board.getBoardViewer().printState();
            }
        }

        System.out.println();
        System.out.println(FIRST_PLAYER.getPlayerCharacter() + " " +
                gameObserver.gameState(board, FIRST_PLAYER, SECOND_PLAYER));
        System.out.println(SECOND_PLAYER.getPlayerCharacter() + " " +
                gameObserver.gameState(board, SECOND_PLAYER, FIRST_PLAYER));
    }

}
