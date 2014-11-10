package me.net.minigames.tntrun.commands;


import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.handlers.TNTFloorLevel;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.command.CommandSender;

public class TNTCommandRepair {

	public static void RepairArena(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("repair")) {
			String arenaname = args[1];
			if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
				TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(arenaname);
				for (final TNTFloorLevel gl : arena.getGameLevels())
		        {
					gl.fillArea(arena.getArenaWorld());
		        }
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.ArenaDoesntExists);
			}
			
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt repair <arenaname>");
		}
	}

}
