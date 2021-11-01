package com.highrisk911.XOgame.java.logic;

import com.highrisk911.XOgame.java.board.Board;

public interface RuleInterface {
    boolean checkRules();

    TypeOfEnd determineTheTypeOfGame(Board board);
}
