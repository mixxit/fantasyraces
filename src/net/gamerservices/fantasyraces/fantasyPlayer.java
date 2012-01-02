package net.gamerservices.fantasyraces;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Query;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

public class fantasyPlayer extends PlayerListener
{
private final fantasyraces plugin;

	public fantasyPlayer(fantasyraces plugin)
	{
	/* 12 */     this.plugin = plugin;
	}
	
	public void onPlayerMove(PlayerMoveEvent event)
	{
		/*
	    sqlPlayer sPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("name", event.getPlayer().getName()).findUnique();
	    if (sPlayer == null) {
	      event.getPlayer().teleport(event.getFrom());
	      event.getPlayer().sendMessage("You cannot move until you set a player race with the /race command (ie /race Human) for a full list use /race list");
		
		  }
		  */
	}
	
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		sqlPlayer sPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("name", event.getPlayer().getName()).findUnique();
		if (sPlayer == null) {
			sPlayer = new sqlPlayer();
			sPlayer.setName(event.getPlayer().getName());
			
			sPlayer.setDisplay(event.getPlayer().getName());
			sPlayer.setRace("Barbarian");
			sPlayer.setLanguage("Barbaric");
		}
		event.getPlayer().setDisplayName("[" + this.plugin.capitalise(sPlayer.getRace()) + "] " + this.plugin.capitalise(sPlayer.getDisplay()) + " " + sPlayer.getTitle());
	}
}
