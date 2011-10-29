package net.gamerservices.fantasyraces;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class findName implements CommandExecutor {

	private fantasyraces plugin;

	public findName(fantasyraces fantasyraces) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
		sqlPlayer sPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("display", arg2).findUnique();
		if (sPlayer == null) {
			arg0.sendMessage("no player found with that name");
			return true;
		} else {
			arg0.sendMessage(arg2 + " resolved to: " + sPlayer.getName());
			return true;
		}
	}
	
	

}
