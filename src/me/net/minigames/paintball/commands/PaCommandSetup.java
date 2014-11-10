package me.net.minigames.paintball.commands;

import org.bukkit.command.CommandSender;

public class PaCommandSetup {

	public static void setup(CommandSender sender, String[] args) {
		if(args.length == 1  && args[0].equalsIgnoreCase("setup")){
			sender.sendMessage("§0========== §'paintball Setup Help <Page> §21/1 §0==========");
			sender.sendMessage("§a/pb create <arenaname> §fCreates an arena");
			sender.sendMessage("§a/pb setspawn <red|blue> <arenaname> §fCreates the team spawn");
			sender.sendMessage("§b/pb setlobby <arenaname> §fSets the lobby location");
			sender.sendMessage("§b/pb setspectate <arenaname> §fSets the spectate location");
			sender.sendMessage("§aTo check if everything is ready §f/pb check <arenaname>");
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb setup");
		}
		
	}

}
