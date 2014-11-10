package me.net.minigames.spleef.commands;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandSpectate {
	
	public static void TeleportSpectate(CommandSender sender, String[] args) {
		if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(args[1])) {
			if(sender instanceof Player) {
				if(args.length == 2 && args[0].equalsIgnoreCase("spectate")) {
					Player player = (Player) sender;
					SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(args[1]);
					if(arena.getSpectatePoint() != null) {
						player.teleport(arena.getSpectatePoint());
						Messages.sendMessage(player, SpleefMessages.spectate);
					}else {
						sender.sendMessage("§cSpectate Location doesn't exsists for this arena");
					}
				}else {
					sender.sendMessage("§cCommand Ussage: §f/spleef spectate <arenaname>");
				}
			}else {
				Messages.sendMessage(sender, SpleefMessages.PlayerOnlyCmd);
			}
		}else {
			Messages.sendMessage(sender, SpleefMessages.ArenaDoesntExists);
		}
		
	}

}
