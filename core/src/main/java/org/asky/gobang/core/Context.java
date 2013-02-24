package org.asky.gobang.core;

public class Context {
   private Player player;
   private List<Player> players;

   public Context(Player player, List<Player> players) {
       this.player = player;
       this.players = players;
   }

   public Player getPlayer() {
       return this.player;
   }

   public List<Player> getPlayers() {
       return this.players;
   }
}
