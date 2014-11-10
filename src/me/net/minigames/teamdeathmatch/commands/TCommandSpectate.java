package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TCommandSpectate {

	public static void spectate(CommandSender sender, String[] args) {
		if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(args[1])) {
			if(sender instanceof Player) {
				if(args.length == 2 && args[0].equalsIgnoreCase("spectate")) {
					Player player = (Player) sender;
					TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(args[1]);
					if(arena.getSpectatePoint() != null) {
						player.teleport(arena.getSpectatePoint());
						TMessages.sendMessage(player, TeamDeathMatchMessages.spectate);
					}else {
						sender.sendMessage("§cSpectate Location doesn't exsists for this arena");
					}
				}else {
					sender.sendMessage("§cCommand Ussage: §f/tdm spectate <arenaname>");
				}
			}else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.PlayerOnlyCmd);
			}
		}else {
			TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
		}
		
	}

}
