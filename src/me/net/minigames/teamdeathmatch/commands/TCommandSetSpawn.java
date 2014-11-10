package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TCommandSetSpawn {

	public static void setSpawn(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 3 && args[0].equalsIgnoreCase("setspawn")) {
				String arenaname = args[2];
				if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(arenaname)) {
					if(args[1].equalsIgnoreCase("red")) {
						setRedSpawn(sender, arenaname);

						
					}if(args[1].equalsIgnoreCase("blue")) {
						
						setBlueSpawn(sender, arenaname);
						
					}
					if(!args[1].equalsIgnoreCase("blue") && !args[1].equalsIgnoreCase("red")) {
						sender.sendMessage("§cCommand Ussage: §f/tdm setspawn <red|blue> <arenaname>");
					}
				}else {
					TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
				}
				
			}else {
				sender.sendMessage("§cCommand Ussage: §f/tdm setspawn <red|blue> <arenaname>");
			}
		}else {
			TMessages.sendMessage(sender, TeamDeathMatchMessages.PlayerOnlyCmd);
		}
		
	}

	private static void setRedSpawn(CommandSender sender, String arenaname) {
		Player player = (Player) sender;
		Location loc = player.getLocation();
		TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(arenaname);
		arena.setRedSpawn(loc);
		arena.saveToConfig();
		sender.sendMessage("§cRed §aSpawn succesfully set for arena §f" + arenaname);
	}
	
	private static void setBlueSpawn(CommandSender sender, String arenaname) {
		Player player = (Player) sender;
		Location loc = player.getLocation();
		TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(arenaname);
		arena.setBlueSpawn(loc);
		arena.saveToConfig();
		sender.sendMessage("§9Blue §aSpawn succesfully set for arena §f" + arenaname);
	}

}
