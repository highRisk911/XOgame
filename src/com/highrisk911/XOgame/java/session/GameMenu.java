package com.highrisk911.XOgame.java.session;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu implements Menu{
    public char selectPlayerChar() {
        System.out.println("put player char");
        return new Scanner(System.in).nextLine().charAt(0);
    }

    public boolean isFirstPlayerDoFirstMove() {
        System.out.println("Do you wanna do first move? y/n");
        return new Scanner(System.in).nextLine().charAt(0) == 'y';
    }

    public boolean isGameVersusAI() {
            System.out.println("Do you wanna play versus AI? y/n");
        return new Scanner(System.in).nextLine().contains("y");
    }

    @Override
    public int gameDimension() {
        System.out.println("put board dimension size in int");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid input");
            //recursion :C
            return gameDimension();
        }
    }
}
