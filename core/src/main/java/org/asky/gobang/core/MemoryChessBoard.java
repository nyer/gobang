package org.asky.gobang.core;

import org.asky.gobang.core.except.StepChessException;
public class MemoryChessBoard extends AbstractChessBoard {
    /** the player's chess step trace **/
    private Map<Player, List<Chess>> playerStepTrace = 
                    new HashMap<Player, List<Chess>>();
    private Chess[][] chesses = null;

    public ChessBoard() {
        this(null, null, DEFAULT_BOARD_WIDTH, DEFAULT_BOARD_HEIGHT);
    }

    public ChessBoard(Player player1, Player player2) {
        this(player1, player2, DEFAULT_BOARD_WIDTH, DEFAULT_BOARD_HEIGHT);
    }

    public ChessBoard(Player player1, Player player2,
                      int boardWidth, int boardHeight) {
        super(player1, player2, boardWidth, boardHeight);

        this.init();
    }

    private void init() {
        this.chesses = new Chess[width][height];
        int defaultStepTraceSize = width * height / 2;
        playerStepTrace.put(player1, new ArrayList<Chess>(defaultStepTraceSize));
        playerStepTrace.put(player2, new ArrayList<Chess>(defaultStepTraceSize));
    }

    @Override
    public synchronized void stepChess(int x, int y, Player player) 
                              throws StepChessException {
        ensureCorrect(x, y, player);
        Chess chess = new Chess(x, y, player);
        playerStepTrace.get(player).add(chess);
        this.chesses[x][y] = chess;
    }

    @Override
    public Chess getChess(int x, int y) {
        if (x < 0 || x >= width || y <0 || y >= height) {
            return null;
        }
        return chesses[x][y];
    }
    }

    private void ensureCorrect(int x, int y, Player player) throws StepChessException {
        boolean correct = true;
        String msg = "";
        if (x >= width || x < 0 || y >= height || y < 0) {
            msg = String.format("x: %d, y: %d exceed the board size", x, y);
            correct = false;
        } else if (player1 != player && player2 != player) {
            msg = String.format("%s is not valid player", player.getName());
            correct = false;
        } else if(chesses[x][y] != null) {
            msg = String.format("x: %d, y: %d has chessed", x, y);
            correct = false;
        }
        if (correct == false) {
            log.warn(msg);
            throw new StepChessException(msg);
        }
    }
}

