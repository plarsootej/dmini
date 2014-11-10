package me.net.minigames.tntrun.commands;


import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.command.CommandSender;

public class TNTCommandEnable {

	public static void enable(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("enable")) {
			if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(args[1])) {
				TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(args[1]);
				arena.enableArena();
				TNTMessages.sendMessage(sender, TNTRunMessages.ArenaEnabled);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt enable <arenaname>");
		}
		
		
	}

}
