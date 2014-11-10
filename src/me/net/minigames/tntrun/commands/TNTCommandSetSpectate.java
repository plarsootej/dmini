package me.net.minigames.tntrun.commands;

import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTCommandSetSpectate {
	
	public static void CreateSpectate(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("setspectate")) {
			final String arenaname = args[1];
			if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					
					TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(arenaname);
					arena.setSpectatePoint(player.getLocation());
					arena.saveToConfig();
			    	
			    	sender.sendMessage("§aSpectate location succesfull set! for arena: §f" + arenaname);
				}else {
					TNTMessages.sendMessage(sender, TNTRunMessages.PlayerOnlyCmd);
				}
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt setspectate <arenaname>");
		}
		
		
		
	}

}
