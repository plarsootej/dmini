package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.command.CommandSender;

public class TCommandEnable {

	public static void enablearena(CommandSender sender, String[] args) {
		if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(args[1])) {
			TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(args[1]);
			arena.enableArena();
			TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaEnabled);
		}else {
			TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
		}
	}

}
