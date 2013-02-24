package org.asky.gobang.core;

/**
 * the gobang Player, may be a watcher
 */
public interface Player {
    /**
     * return the player's name
     */
    String getName();

    /**
     * return the chess board
     */
    ChessBoard getChessBoard();

    /**
     * get the rival
     */
    Player getRival();

    /**
     * step a chess
     */
    void stepChess(int x, int y);

    /**
     * if this player is a watcher
     */
    boolean isWatcher();
}
