package com.highrisk911.XOgame.java.logic;

import com.highrisk911.XOgame.java.board.Board;
import com.highrisk911.XOgame.java.players.Player;

import java.util.Scanner;

public class GameSession {
    private Player player;
    private Player enemy;
    private Board board;
    private GameObserver gameObserver;
    private Scanner scanner = new Scanner(System.in);

    private boolean firstPlayerDoFirstMove;
    private boolean secondPlayerIsAI;

    private void entryMenu(){
        String secondPlayerSymbol = null;
        String firstPlayerSymbol;
        String playerAnswer;

        System.out.println("First player, select your char: ");
             firstPlayerSymbol = scanner.nextLine();

        System.out.println("Do you wanna do first turn? yes/no");
             playerAnswer = scanner.nextLine();
                firstPlayerDoFirstMove = checkUserAnswer(playerAnswer);

        System.out.println("Do you wanna play with AI? yes/no");
            playerAnswer = scanner.nextLine();
                secondPlayerIsAI = checkUserAnswer(playerAnswer);

        if(!secondPlayerIsAI){
            System.out.println("First player, select your char: ");
                secondPlayerSymbol = scanner.nextLine();
        }
        init(firstPlayerSymbol, secondPlayerSymbol);
    }

    private void init(String charFirstPlayer, String charSecondPlayer){
        player = new Human(charFirstPlayer);
            if(charSecondPlayer == null) enemy = new AI(String.valueOf(charFirstPlayer.codePointAt(0)+2));
        board = new Board(3);
        gameObserver = new GameObserver();
    }

    private boolean checkUserAnswer(String playerAnswer){
        if(playerAnswer.contains("y") && !playerAnswer.contains("n")){
            return true;
        }
        else if(playerAnswer.contains("n") && !playerAnswer.contains("y")){
            return false;
        }
        System.out.println("You entered unknown word");
        System.exit(0);
        return false;
    }

    private void playGame(){
        while (!board.isFull() || !gameObserver.isFinish(board)){
            if (firstPlayerDoFirstMove) {
                player.makeMove();
                if(gameObserver.isFinish(board))break;
                enemy.makeMove();
                if(gameObserver.isFinish(board))break;
            } else {
                enemy.makeMove();
                if(gameObserver.isFinish(board))break;
                player.makeMove();
                if(gameObserver.isFinish(board))break;
            }
        }

    }


    public void start(){
        entryMenu();

    }
}
