package me.net.minigames.spleef.commands;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandSetSpectate {
	
	public static void SetSpectate(CommandSender sender, String[] args) {
			if(args.length == 2 && args[0].equalsIgnoreCase("setspectate")) {
				if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(args[1])) {
					if(sender instanceof Player) {
						Player player = (Player) sender;
						SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(args[1]);
						Location loc = player.getLocation();
						arena.setSpectatePoint(loc);
						arena.saveToConfig();
						
						player.sendMessage("§aSpectate Location succesfully set for arena: §f" + args[1]);
					}else {
						Messages.sendMessage(sender, SpleefMessages.PlayerOnlyCmd);
					}
				}else {
					Messages.sendMessage(sender, SpleefMessages.ArenaDoesntExists);
				}

				
			}else {
				sender.sendMessage("§cCommand Ussage: §f/Spleef setspectate <arenaname>");
			}
		
		
	}

}
