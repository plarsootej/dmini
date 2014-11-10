package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.command.CommandSender;

public class TCommandSetCountDown {

	public static void setCountDown(CommandSender sender, String[] args) {
		if(args.length == 3 && args[0].equalsIgnoreCase("setcountdown")) {
			String arenaname = args[1];
			
			if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(arenaname)) {
				TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(arenaname);
				int seconds = Integer.parseInt(args[2]);
				arena.setCountDown(seconds);
				arena.saveToConfig();
				sender.sendMessage("§aCountdown succesfully set to §6" + seconds + "§a for arena §f" + arenaname);
			}else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tdm setcountdown <arenaname> <seconds>");
		}
		
	}

}
