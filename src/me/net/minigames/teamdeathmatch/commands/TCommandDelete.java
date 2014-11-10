package me.net.minigames.teamdeathmatch.commands;

import java.io.File;

import me.net.minigames.main.MainClass;
import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TCommandDelete {

	public static void delete(CommandSender sender, String[] args) {
		if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(args[1])) {
			TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(args[1]);
			for(String p : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaPlayers(arena)) {
				Player players = Bukkit.getServer().getPlayerExact(p);
				players.teleport(arena.getLobbyPoint());
				TMessages.sendMessage(players, TeamDeathMatchMessages.DeletedArena);
				TeamDeathMatchMain.TeamDeathMatchMain.pdata.removePlayerFromArena(p);
				TeamDeathMatchMain.TeamDeathMatchMain.pdata.removeArenaFromHashMap(arena);
				File file = new File(MainClass.main.getDataFolder() + "/TeamDeathMatch/Arenas" + args[1] + ".yml");
				file.delete();
				
			}
			
		}else {
			TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
		}
	}

}
