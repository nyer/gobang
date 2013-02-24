package org.asky.gobang.core.player;

import org.asky.gobang.core.Player;

public abstract class AbstractPlayer implements Player {
    private String name;
    private ChessBoard chessBoard;
    private Player rival;
    private boolean watcher = true;

    public AbstractPlayer(String name, ChessBoard chessBoard) {
        this.name = name;
        this.chessBoard = chessBoard;
    }

    public void setRival(Player player) {
        this.rival = rival;
    }

    @Override
    public ChessBoard getChessBoard() {
        return this.chessBoard;
    }

    @Override
    public Player getRival() {
        return this.rival;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void stepChess(int x, int y) {
    }

    @Override
    public boolean isWatcher() {
        return watcher;
    }

    public void setAsNotWatcher() {
        this.watcher = false;
    }
}
