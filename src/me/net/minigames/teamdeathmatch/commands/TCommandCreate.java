package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.main.MainClass;
import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TCommandCreate {
	
	public static void create(CommandSender sender, String[] args) {
		if(args.length == 2) {
			if(sender instanceof Player) {
				
				Player player = (Player) sender;
				
				String arenaname = args[1];
				if(!TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(arenaname)) {
					if(arenaname.length() <= 15) {
						
						createNonWanded(sender, args);
						
					}else {
						TMessages.sendMessage(player, TeamDeathMatchMessages.ToLongName);
					}
				}else {
					sender.sendMessage("§aThat arena already exists!");
					sender.sendMessage("§cTo delete the old arena with name: §6" +arenaname +" §f/tdm delete <arenaname>");
				}
				
			}else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.PlayerOnlyCmd);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tdm create <arenaname>");
		}
	}
	
	
	private static void createNonWanded(CommandSender sender, String[] args) {
		TArenas arena = new TArenas(args[1], MainClass.main, TeamDeathMatchMain.TeamDeathMatchMain);
		Player player = (Player) sender;
		Location loc = player.getLocation();
		arena.setArenaWorld(loc.getWorld().getName());
		sender.sendMessage("§aArena succesfully created!");
		
		
	}

}
