package net.gamerservices.fantasyraces;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Query;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class fantasyraces extends JavaPlugin
{
private final fantasyPlayer fpListener = new fantasyPlayer(this);

  public void onDisable()
  {
PluginDescriptionFile desc = getDescription();
System.out.println(desc.getFullName() + " has been disabled");
  }

  public void onEnable()
  {
	PluginDescriptionFile desc = getDescription();
	System.out.println(desc.getFullName() + " has been enabled");
	
	setupDatabase();
	
	getCommand("race").setExecutor(new SetRace(this));
	getCommand("name").setExecutor(new setName(this));
	getCommand("findName").setExecutor(new findName(this));
	getCommand("findDisplayName").setExecutor(new findDisplayName(this));
	getCommand("forcetitle").setExecutor(new forceTitle(this));

	PluginManager pm = getServer().getPluginManager();
	pm.registerEvent(Event.Type.PLAYER_JOIN, this.fpListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.PLAYER_MOVE, this.fpListener, Event.Priority.Normal, this);
  }

  boolean onlyletters(String string) {
	  return string.matches("^[a-zA-Z]+$");
  }

  public String capitalise(String string)
  {
	if (string == null)
		throw new NullPointerException("string");
	if (string.equals(""))
		throw new NullPointerException("string");
	return Character.toUpperCase(string.charAt(0)) + string.substring(1);
  }

  private void setupDatabase()
  {
    try
    {
		getDatabase().find(sqlPlayer.class).findRowCount();
    } catch (PersistenceException ex) {
		System.out.println("Installing database for " + getDescription().getName() + " due to first time usage");
		installDDL();
    }
  }

  public List<Class<?>> getDatabaseClasses()
  {
		List list = new ArrayList();
		list.add(sqlPlayer.class);
		return list;
  }
}
