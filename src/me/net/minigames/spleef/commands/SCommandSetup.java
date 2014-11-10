package me.net.minigames.spleef.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandSetup {

	public static void SetupCommand(CommandSender sender) {
		if(sender instanceof Player) {
			sender.sendMessage("§0========== §'Spleef Setup Help <Page> §21/1 §0==========");
			sender.sendMessage("§a/spleef create <arenaname> §fCreates an arena");
			sender.sendMessage("§a/spleef createfloor <arenaname> §fCreates the spleef floor");
			sender.sendMessage("§a/spleef setloselevel <arenaname> §fSets the lose level");
			sender.sendMessage("§b/spleef setlobby <arenaname> §fSets the lobby location");
			sender.sendMessage("§b/spleef setspawn <arenaname> §fSets the spawn location");
			sender.sendMessage("§b/spleef setspectate <arenaname> §fSets the spectate location");
			sender.sendMessage("§aTo check if everything is ready §f/spleef check <arenaname>");
		}
		
	}

}
