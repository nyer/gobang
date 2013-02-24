package org.asky.gobang.core;

import org.asky.gobang.core.except.StepChessException;
public abstract class AbstractChessBoard implements  ChessBoard {
    private Player player1;
    private Player player2;

    private int width;
    private int height;

    protected final CopyOnWriterArrayList<ChessBoard.Listener> listeners =
        new CopyOnWriterArrayList<ChessBoard.Listener>();

    public ChessBoard() {
        this(null, null);
    }

    public ChessBoard(Player player1, Player player2) {
        this(player1, player2, DEFAULT_BOARD_WIDTH, DEFAULT_BOARD_HEIGHT);
    }

    public ChessBoard(Player player1, Player player2,
                      int boardWidth, int boardHeight) {
        this.player1 = player1;
        this.player2 = player2;
        this.width = boardWidth;
        this.height = boardHeight;
    }

    @Override
    public void addStatusChangeListener(ChessBoard.Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeStatusChangeListener(ChessBoard.Listener listener) {
        this.listeners.remove(listener);
    }

    public void setPlayer1(Player player) {
        this.player1 = player;
    }

    public void setPlayer2(Player player) {
        this.player2 = player;
    }

    protected void ensureCorrect(int x, int y, Player player) throws StepChessException {
        boolean correct = true;
        String msg = "";
        if (x >= width || x < 0 || y >= height || y < 0) {
            msg = String.format("x: %d, y: %d exceed the board size", x, y);
            correct = false;
        } else if (player1 != player && player2 != player) {
            msg = String.format("%s is not valid player", player.getName());
            correct = false;
        } else if(getChess(x, y) != null) {
            msg = String.format("x: %d, y: %d has chessed", x, y);
            correct = false;
        }
        if (correct == false) {
            log.warn(msg);
            throw new StepChessException(msg);
        }
    }
}

public class AbstractEventListener implements ChessBoard.Listener {
}
