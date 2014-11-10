package me.net.minigames.main.helppages;

import org.bukkit.command.CommandSender;

public class HelpMain {
	
	public static void MainHelp(CommandSender sender, String[] args) {
		if(sender.hasPermission("dm.admin")) {
			sender.sendMessage("§0============= §4DMinigames Help §0=============");
			sender.sendMessage("§a/dm reload §fReload all the configs");
			sender.sendMessage("§a/dm reload <minigame> §f reload the certain configs");
			sender.sendMessage("§a/dm help <minigame> <page> §fSee the help pages for the minigames");
			
		}else {
			sender.sendMessage("§0============= §4DMinigames Help §0=============");
			sender.sendMessage("§a/dm help <minigame> <page> §fSee the help pages for the minigames");
		}
	}

}
