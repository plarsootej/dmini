package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TCommandLeave {

	public static void leave(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getPlayerArena(player.getName());
			if(arena != null) {
				arena.arenaph.LeavePlayer(player, true);
			}
			
		}else {
			TMessages.sendMessage(sender, TeamDeathMatchMessages.PlayerOnlyCmd);
		}
	}

}
