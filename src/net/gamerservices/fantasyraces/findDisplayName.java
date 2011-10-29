package net.gamerservices.fantasyraces;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class findDisplayName implements CommandExecutor {

	private fantasyraces plugin;

	public findDisplayName(fantasyraces fantasyraces) {
		// TODO Auto-generated constructor stub
		this.plugin = fantasyraces;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		
		try
		{
		// TODO Auto-generated method stub
		
		sqlPlayer sPlayer = (sqlPlayer)this.plugin.getDatabase().find(sqlPlayer.class).where().ieq("name", arg3[0]).findUnique();
			if (sPlayer == null) {
				arg0.sendMessage("no player found with that display name (" + arg3[0] + ") - try with a different case (ie Player instead of player)");
				return true;
			} else {
				arg0.sendMessage(arg2 + " resolved to: " + sPlayer.getDisplay());
				return true;
			}
		} catch (Exception e)
		{
			arg0.sendMessage("Incorrect syntax, /finddisplayname Playername");
			return true;
		}
		
	}
	
	

}
