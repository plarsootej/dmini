package me.net.minigames.tntrun.commands;

import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;
import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.command.CommandSender;

public class TNTSetCountdown {

	public static void setcountdown(CommandSender sender, String[] args) {
		if(args.length == 3 && args[0].equalsIgnoreCase("setcountdown")) {
			String arenaname = args[1];
			
			if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
				TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(arenaname);
				int seconds = Integer.parseInt(args[2]);
				arena.setCountDown(seconds);
				arena.saveToConfig();
				sender.sendMessage("§aCountdown succesfully set to §6" + seconds + "§a for arena §f" + arenaname);
			}else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt setcountdown <arenaname> <seconds>");
		}
		
	}

}
