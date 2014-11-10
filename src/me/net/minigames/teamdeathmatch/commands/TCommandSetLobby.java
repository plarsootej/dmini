package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TCommandSetLobby {

	public static void setLobby(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(args[1])) {
				if(args.length == 2  && args[0].equalsIgnoreCase("setlobby")) {
					Player player = (Player) sender;
					TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(args[1]);
					Location loc = player.getLocation();
					arena.setLobbyPoint(loc);
					arena.saveToConfig();
					
					player.sendMessage("§aLobby Location succesfully set for arena: §f" + args[1]);
				}else {
					sender.sendMessage("§cCommand Ussage: §f/tdm setlobby <arenaname>");
				}
			}else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
			}
			
		}else {
			TMessages.sendMessage(sender, TeamDeathMatchMessages.PlayerOnlyCmd);
		}
		
	}

}
