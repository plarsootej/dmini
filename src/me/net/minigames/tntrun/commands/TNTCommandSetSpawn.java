package me.net.minigames.tntrun.commands;

import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTCommandSetSpawn {

	public static void CreateSpawn(CommandSender sender, String[] args) {
		if(args.length == 3 && args[0].equalsIgnoreCase("setspawn")) {
			final String arenaname = args[1];
			
			final String number = args[2];
			if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					
					TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(arenaname);
					arena.setSpawnPoint(number, player.getLocation());
					arena.saveToConfig();
					
					
			    	
			    	sender.sendMessage("§aSpawn location succesfull set! for arena: §f" + arenaname);
				}else {
					TNTMessages.sendMessage(sender, TNTRunMessages.PlayerOnlyCmd);
				}
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt setspawn <arenaname> <number>");
		}
	}

}
