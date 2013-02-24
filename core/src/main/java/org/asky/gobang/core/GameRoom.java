package org.asky.gobang.core;

import java.uitl.List;
import java.util.concurrent.CopyOnWriterArrayList;

public class GameRoom {
    private ChessBoard chessBoard;
    private CopyOnWriterArrayList<Player> players = new CopyOnWriterArrayList<Player>();

    public GameRoom(Player player1,Player player2) {
        this.chessBoard = new MemoryChessBoard(player1, player2);
        if (null != player1) {
            players.add(player1);
        }
        if (null != player2) {
            players.add(player2);
        }
    }

    public ChessBoard getChessBoard() {
        return this.chessBoard;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}

