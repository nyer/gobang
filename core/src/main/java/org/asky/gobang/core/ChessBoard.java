package org.asky.gobang.core;

import org.asky.gobang.core.except.StepChessException;
import java.util.EventListener;

public interface ChessBoard {
    public static final DEFAULT_BOARD_WIDTH = 20;
    public static final DEFAULT_BOARD_HEIGHT = 20;

    public synchronized void stepChess(int x, int y, Player player) 
                              throws StepChessException;

    public Chess getChess(int x, int y);
    
    public void addStatusChangeListener(ChessBoard.Listener listener);

    public void removeStatusChangeListener(ChessBoard.Listener listener);
}

public interface Listener extends EventListener {
}
