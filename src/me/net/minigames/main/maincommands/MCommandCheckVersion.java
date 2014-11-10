package me.net.minigames.main.maincommands;

import me.net.minigames.main.MainClass;

import org.bukkit.command.CommandSender;

public class MCommandCheckVersion {
	
	public static void CheckVersion(CommandSender sender, String[] args) {
		if(args.length == 1 && args[0].equalsIgnoreCase("checkversion")) {
			String version = MainClass.main.getDescription().getVersion();
			sender.sendMessage("§aYou current DMinigames Version is §f Dminigames v" + version);
		}
	}

}
