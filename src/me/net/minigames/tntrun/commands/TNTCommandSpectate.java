package me.net.minigames.tntrun.commands;


import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTCommandSpectate {

	public static void SpectateTNT(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 2 && args[0].equalsIgnoreCase("spectate")) {
				final Player player = (Player) sender;
				final String arenaname = args[1];
				if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
					
					sender.sendMessage("§aSuccesfully teleported to spectate location for §f" + arenaname);
					TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(arenaname);
					if(arena.getSpectatePoint() != null) {
						player.teleport(arena.getSpectatePoint());
					}else {
						TNTMessages.sendMessage(sender, TNTRunMessages.spectateDoesnotexists);
					}
				}else {
					TNTMessages.sendMessage(sender, TNTRunMessages.ArenaDoesntExists);
				}
				
				
			}else {
				sender.sendMessage("§aCommandUssage: §f/tnt spectate <arenaname>");
			}
		}else {
			TNTMessages.sendMessage(sender, TNTRunMessages.PlayerOnlyCmd);
		}
		
	}

}
