/*    */ package net.gamerservices.fantasyraces;
/*    */ 
/*    */ import com.avaje.ebean.EbeanServer;
/*    */ import com.avaje.ebean.ExpressionList;
/*    */ import com.avaje.ebean.Query;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
/*    */ 
/*    */ public class setName
/*    */   implements CommandExecutor
/*    */ {
/*    */   private final fantasyraces plugin;
/*    */ 
/*    */   public setName(fantasyraces plugin)
/*    */   {
/* 15 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
/*    */   {
/* 23 */     if (!(sender instanceof Player)) {
/* 24 */       return false;
/*    */     }
/*    */ 
/* 27 */     Player player = (Player)sender;
/*    */ 

			 sqlPlayer sFindPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("display", args[0]).findUnique();
			 if (sFindPlayer != null) {
				 player.sendMessage(args[0] + " is already in use by another player (" + sFindPlayer.getName() + ")");
				return true;
			 }

/* 29 */     sqlPlayer sPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("name", player.getName()).findUnique();
/* 30 */     if (sPlayer == null) {
/* 31 */       sPlayer = new sqlPlayer();
/* 32 */       sPlayer.setName(player.getName());
/*    */ 
/* 34 */       sPlayer.setDisplay(player.getName());
/* 35 */       sPlayer.setRace("Barbarian");
/* 36 */       sPlayer.setLanguage("Barbaric");
/*    */     }
/*    */ 
/* 41 */     if (args.length < 1) {
/* 42 */       player.sendMessage(ChatColor.RED + "Your current name is: " + sPlayer.getName());
/* 43 */       player.sendMessage(ChatColor.RED + "To set a new name use the: '/name Newname' command");
/*    */ 
/* 45 */       return true;
/*    */     }
/* 47 */     if (!this.plugin.onlyletters(args[0]))
/*    */     {
/* 49 */       player.sendMessage(ChatColor.RED + "Your character name must be a forename only with no special characters");
/* 50 */       return true;
/*    */     }
/*    */ 
/* 53 */     sPlayer.setDisplay(args[0].toString());
/* 54 */     this.plugin.getDatabase().save(sPlayer);
/*    */ 
/* 56 */     player.setDisplayName("[" + this.plugin.capitalise(sPlayer.getRace()) + "] " + this.plugin.capitalise(sPlayer.getDisplay()) + " " + sPlayer.getTitle());
/* 57 */     player.sendMessage("Your name is now: " + args[0]);
/* 58 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Documents and Settings\end\Desktop\fantasyraces.jar
 * Qualified Name:     net.gamerservices.fantasyraces.setName
 * JD-Core Version:    0.6.0
 */