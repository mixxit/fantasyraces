package net.gamerservices.fantasyraces;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class findName implements CommandExecutor {

	private fantasyraces plugin;

	public findName(fantasyraces fantasyraces) {
		// TODO Auto-generated constructor stub
		this.plugin = fantasyraces;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
		try
		{
		sqlPlayer sPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("display", arg3[0]).findUnique();
			if (sPlayer == null) {
				arg0.sendMessage("no player found with that name (" + arg3[0] + ") - try with a different case (ie Player instead of player)");
				return true;
			} else {
				arg0.sendMessage(arg2 + " resolved to: " + sPlayer.getName());
				return true;
			}
		} catch (Exception e)
		{
			arg0.sendMessage("Incorrect syntax, /findname Playername");
			return true;
		}
	}
	
	

}
