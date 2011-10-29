/*    */ package net.gamerservices.fantasyraces;
/*    */ 
/*    */ import com.avaje.ebean.EbeanServer;
/*    */ import com.avaje.ebean.ExpressionList;
/*    */ import com.avaje.ebean.Query;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class forceTitle
implements CommandExecutor
/*    */ {
private final fantasyraces plugin;
/*    */ 
public forceTitle(fantasyraces plugin)
{
/* 17 */     this.plugin = plugin;
}
/*    */ 
public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
{
/* 25 */     if (!(sender instanceof Player)) {
/* 26 */       return false;
  }
/*    */ 
/* 29 */     Player player = (Player)sender;
/*    */ 
/* 31 */     if (!player.isOp())
  {
/* 33 */       player.sendMessage(ChatColor.RED + "Op only command");
/* 34 */       return true;
  }
/*    */ 
/* 37 */     if (args.length < 2) {
/* 38 */       player.sendMessage(ChatColor.RED + "To set a players title use: '/forcetitle playername title'");
/* 39 */       return true;
  }
/*    */ 
/* 42 */     sqlPlayer sPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("name", args[0]).findUnique();
/* 43 */     if (sPlayer == null) {
/* 44 */       player.sendMessage(ChatColor.RED + "That player does not exist");
/* 45 */       return true;
  }
/*    */ 
/* 48 */     int count = 0;
/* 49 */     String finaltitle = "";
/* 50 */     for (String s : args)
  {
/* 52 */       if (count != 0)
    {
/* 54 */         if (count == 1)
      {
/* 56 */           finaltitle = s;
      }
/* 58 */         if (count > 1)
      {
/* 60 */           finaltitle = finaltitle + " " + s;
      }
    }
/* 63 */       count++;
  }
/*    */ 
/* 66 */     sPlayer.setTitle(finaltitle);
/* 67 */     this.plugin.getDatabase().save(sPlayer);
/*    */ 
/* 70 */     Server server = this.plugin.getServer();
  try {
/* 72 */       Player targetplayer = server.getPlayer(sPlayer.getName());
/* 73 */       targetplayer.sendMessage("You have received a new title!");
/* 74 */       targetplayer.setDisplayName("[" + this.plugin.capitalise(sPlayer.getRace()) + "] " + this.plugin.capitalise(sPlayer.getDisplay()) + " " + sPlayer.getTitle());
  }
  catch (Exception e)
  {
/* 78 */       player.sendMessage("Offline player " + args[0] + "'s title is now: " + finaltitle);
  }
/*    */ 
/* 81 */     player.sendMessage("Online player " + args[0] + "'s title is now: " + finaltitle);
/* 82 */     return true;
}
/*    */ }

/* Location:           C:\Documents and Settings\end\Desktop\fantasyraces.jar
 * Qualified Name:     net.gamerservices.fantasyraces.forceTitle
 * JD-Core Version:    0.6.0
 */