public class Chess {
    private int x;
    private int y;
    private Player player;
    private long stepTimeStamp;

    public Chess(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.stepTimeStamp = System.currentTimeInMillis();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player getPlayer() {
        return this.player;
    }

    public long getStepTimeStamp() {
        return this.stepTimeStamp;
    }
}
