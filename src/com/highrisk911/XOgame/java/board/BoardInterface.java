package com.highrisk911.XOgame.java.board;

import com.highrisk911.XOgame.java.board.controller.BoardControllerInterface;
import com.highrisk911.XOgame.java.board.viewer.BoardViewerInterface;

public interface BoardInterface {
    BoardViewerInterface getBoardViewer();

    BoardControllerInterface getBoardController();
}
