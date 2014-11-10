package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TCommandSetSpectate {

	public static void setSpectate(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("setspectate")) {
			if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(args[1])) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(args[1]);
					Location loc = player.getLocation();
					arena.setSpectatePoint(loc);
					arena.saveToConfig();
					
					player.sendMessage("§aSpectate Location succesfully set for arena: §f" + args[1]);
				}else {
					TMessages.sendMessage(sender, TeamDeathMatchMessages.PlayerOnlyCmd);
				}
			}else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
			}

			
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tdm setspectate <arenaname>");
		}
	}

}
