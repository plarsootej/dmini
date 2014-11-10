package me.net.minigames.spleef.commands;


import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.command.CommandSender;

public class SCommandSetCountDown {

	public static void setcountdown(CommandSender sender, String[] args) {
		if(args.length == 3 && args[0].equalsIgnoreCase("setcountdown")) {
			String arenaname = args[1];
			
			if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(arenaname)) {
				SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(arenaname);
				int seconds = Integer.parseInt(args[2]);
				arena.setCountDown(seconds);
				arena.saveToConfig();
				sender.sendMessage("§aCountdown succesfully set to §6" + seconds + "§a for arena §f" + arenaname);
			}else {
				Messages.sendMessage(sender, SpleefMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/spleef setcountdown <arenaname> <seconds>");
		}
		
	}

}
