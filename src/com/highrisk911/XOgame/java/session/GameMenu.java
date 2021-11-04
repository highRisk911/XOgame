package com.highrisk911.XOgame.java.session;

import java.util.Scanner;

public class GameMenu {
    public char selectPlayerChar(){
        System.out.println("put player char");
        return new Scanner(System.in).nextLine().charAt(0);
    }

    public boolean isFirstPlayerDoFirstMove(){
        System.out.println("Do you wanna do first move? y/n");
        return (new Scanner(System.in).nextLine().charAt(0) == 'y')?true:false;
    }
}
