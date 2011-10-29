/*    */ package net.gamerservices.fantasyraces;
/*    */ 
/*    */ import com.avaje.ebean.EbeanServer;
/*    */ import com.avaje.ebean.ExpressionList;
/*    */ import com.avaje.ebean.Query;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.event.player.PlayerListener;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ 
/*    */ public class fantasyPlayer extends PlayerListener
/*    */ {
/*    */   private final fantasyraces plugin;
/*    */ 
/*    */   public fantasyPlayer(fantasyraces plugin)
/*    */   {
/* 12 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   public void onPlayerMove(PlayerMoveEvent event)
/*    */   {
/* 17 */     sqlPlayer sPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("name", event.getPlayer().getName()).findUnique();
/* 18 */     if (sPlayer == null) {
/* 19 */       event.getPlayer().teleport(event.getFrom());
/* 20 */       event.getPlayer().sendMessage("You cannot move until you set a player race with the /race command");
/*    */     }
/*    */   }
/*    */ 
/*    */   public void onPlayerJoin(PlayerJoinEvent event)
/*    */   {
/* 27 */     sqlPlayer sPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("name", event.getPlayer().getName()).findUnique();
/* 28 */     if (sPlayer == null) {
/* 29 */       sPlayer = new sqlPlayer();
/* 30 */       sPlayer.setName(event.getPlayer().getName());
/*    */ 
/* 32 */       sPlayer.setDisplay(event.getPlayer().getName());
/* 33 */       sPlayer.setRace("Barbarian");
/* 34 */       sPlayer.setLanguage("Barbaric");
/*    */     }
/* 36 */     event.getPlayer().setDisplayName("[" + this.plugin.capitalise(sPlayer.getRace()) + "] " + this.plugin.capitalise(sPlayer.getDisplay()) + " " + sPlayer.getTitle());
/*    */   }
/*    */ }

/* Location:           C:\Documents and Settings\end\Desktop\fantasyraces.jar
 * Qualified Name:     net.gamerservices.fantasyraces.fantasyPlayer
 * JD-Core Version:    0.6.0
 */