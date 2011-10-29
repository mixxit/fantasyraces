/*    */ package net.gamerservices.fantasyraces;
/*    */ 
/*    */ import com.avaje.ebean.EbeanServer;
/*    */ import com.avaje.ebean.Query;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.persistence.PersistenceException;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.event.Event.Priority;
/*    */ import org.bukkit.event.Event.Type;
/*    */ import org.bukkit.plugin.PluginDescriptionFile;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class fantasyraces extends JavaPlugin
/*    */ {
/* 19 */   private final fantasyPlayer fpListener = new fantasyPlayer(this);
/*    */ 
/*    */   public void onDisable()
/*    */   {
/* 24 */     PluginDescriptionFile desc = getDescription();
/* 25 */     System.out.println(desc.getFullName() + " has been disabled");
/*    */   }
/*    */ 
/*    */   public void onEnable()
/*    */   {
/* 31 */     PluginDescriptionFile desc = getDescription();
/* 32 */     System.out.println(desc.getFullName() + " has been enabled");
/*    */ 
/* 34 */     setupDatabase();
/*    */ 
/* 37 */     getCommand("race").setExecutor(new SetRace(this));
/* 38 */     getCommand("name").setExecutor(new setName(this));
/*    */ 
/* 41 */     getCommand("forcetitle").setExecutor(new forceTitle(this));
/*    */ 
/* 43 */     PluginManager pm = getServer().getPluginManager();
/* 44 */     pm.registerEvent(Event.Type.PLAYER_JOIN, this.fpListener, Event.Priority.Normal, this);
/* 45 */     pm.registerEvent(Event.Type.PLAYER_MOVE, this.fpListener, Event.Priority.Normal, this);
/*    */   }
/*    */ 
/*    */   boolean onlyletters(String string) {
/* 49 */     return string.matches("^[a-zA-Z]+$");
/*    */   }
/*    */ 
/*    */   public String capitalise(String string)
/*    */   {
/* 54 */     if (string == null)
/* 55 */       throw new NullPointerException("string");
/* 56 */     if (string.equals(""))
/* 57 */       throw new NullPointerException("string");
/* 58 */     return Character.toUpperCase(string.charAt(0)) + string.substring(1);
/*    */   }
/*    */ 
/*    */   private void setupDatabase()
/*    */   {
/*    */     try
/*    */     {
/* 65 */       getDatabase().find(sqlPlayer.class).findRowCount();
/*    */     } catch (PersistenceException ex) {
/* 67 */       System.out.println("Installing database for " + getDescription().getName() + " due to first time usage");
/* 68 */       installDDL();
/*    */     }
/*    */   }
/*    */ 
/*    */   public List<Class<?>> getDatabaseClasses()
/*    */   {
/* 74 */     List list = new ArrayList();
/* 75 */     list.add(sqlPlayer.class);
/* 76 */     return list;
/*    */   }
/*    */ }

/* Location:           C:\Documents and Settings\end\Desktop\fantasyraces.jar
 * Qualified Name:     net.gamerservices.fantasyraces.fantasyraces
 * JD-Core Version:    0.6.0
 */