package me.net.minigames.tntrun.methods;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTSetupHelpPage {
	
	public static void TNTSetupHelp(CommandSender sender) {
		if(sender instanceof Player) {
			
			sender.sendMessage("§0========== §4TNT Setup Help <Page> §21/1 §0==========");
			sender.sendMessage("§a/tnt create <arenaname>");
			sender.sendMessage("§a/tnt createfloor <arenaname> <floor>");
			sender.sendMessage("§a/tnt createlose <arenaname>");
			sender.sendMessage("§a/tnt setlobby <arenaname>");
			sender.sendMessage("§a/tnt setspawn <arenaname> <number>");
			sender.sendMessage("§a/tnt setspectate <arenaname>");
			
		}else {
			sender.sendMessage("§cPlayer Only Command!");
		}
	}

}
