package me.net.minigames.teamdeathmatch.commands;

import org.bukkit.command.CommandSender;

public class TCommandSetup {

	public static void setuphelppages(CommandSender sender, String[] args) {
		sender.sendMessage("§0========== §'Spleef Setup Help <Page> §21/1 §0==========");
		sender.sendMessage("§a/tdm create <arenaname> §fCreates an arena");
		sender.sendMessage("§b/tdm setlobby <arenaname> §fSets the lobby location");
		sender.sendMessage("§b/tdm setspawn <red|blue> <arenaname> §fSets the spawn location");
		sender.sendMessage("§b/tdm setspectate <arenaname> §fSets the spectate location");
		sender.sendMessage("§aTo check if everything is ready §f/tdm check <arenaname>");
		
	}

}
