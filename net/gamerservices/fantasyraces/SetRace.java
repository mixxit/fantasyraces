/*    */ package net.gamerservices.fantasyraces;
/*    */ 
/*    */ import com.avaje.ebean.EbeanServer;
/*    */ import com.avaje.ebean.ExpressionList;
/*    */ import com.avaje.ebean.Query;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class SetRace
/*    */   implements CommandExecutor
/*    */ {
/*    */   private final fantasyraces plugin;
/*    */ 
/*    */   public SetRace(fantasyraces plugin)
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
/* 40 */     if (args.length < 1) {
/* 41 */       player.sendMessage(ChatColor.RED + "Your current race is: " + sPlayer.getRace());
/* 42 */       player.sendMessage(ChatColor.RED + "To set a new race use the: '/race Racename' command");
/*    */ 
/* 44 */       return true;
/*    */     }
/*    */ 
/* 48 */     int matchcount = 0;
/* 49 */     String targetrace = args[0].toLowerCase();
/* 50 */     String[] races = { "endol", "meroei", "taxicost", "mysmaal", "vishim", "eusebian", "eiao", "garuda", "lidkim", "gialon", "chunel", "rauklete", "taktevolken", "zahnfe", "setagn" };
/* 51 */     for (String rs : races)
/*    */     {
/* 53 */       if (!rs.equals(targetrace))
/*    */         continue;
/* 55 */       matchcount++;
/*    */     }
/*    */ 
/* 59 */     if (matchcount < 1)
/*    */     {
/* 61 */       player.sendMessage(ChatColor.RED + "That is not a valid race");
/* 62 */       player.sendMessage(ChatColor.RED + "Valid races are: " + "Endol, " + "Meroei, " + "Taxicost, " + "Mysmaal, " + "Vishim, " + "Eusebian, " + "Eiao, " + "Garuda, " + "Lidkim, " + "Gialon, " + "Chunel, " + "Rauklete, " + "Taktevolken, " + "Zahnfe, " + "Setagn");
/* 63 */       player.sendMessage(ChatColor.RED + "Please see http://www.soliniaonline.com/races for more information");
/* 64 */       return false;
/*    */     }
/*    */ 
/* 69 */     sPlayer.setRace(args[0].toString());
/* 70 */     this.plugin.getDatabase().save(sPlayer);
/* 71 */     String currentrace = "";
/*    */     try
/*    */     {
/* 75 */       int indexleft = player.getDisplayName().indexOf('[');
/* 76 */       int indexright = player.getDisplayName().indexOf(']');
/* 77 */       currentrace = player.getDisplayName().substring(indexleft + 1, indexright);
/*    */     }
/*    */     catch (StringIndexOutOfBoundsException err) {
/* 80 */       currentrace = "";
/*    */     }
/*    */ 
/* 83 */     player.setDisplayName("[" + this.plugin.capitalise(sPlayer.getRace()) + "] " + this.plugin.capitalise(sPlayer.getDisplay()) + " " + sPlayer.getTitle());
/* 84 */     player.sendMessage("Your race is now: " + args[0]);
/* 85 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Documents and Settings\end\Desktop\fantasyraces.jar
 * Qualified Name:     net.gamerservices.fantasyraces.SetRace
 * JD-Core Version:    0.6.0
 */