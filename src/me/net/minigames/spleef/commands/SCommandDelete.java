package me.net.minigames.spleef.commands;

import java.io.File;

import me.net.minigames.main.MainClass;
import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandDelete {
	
	public static void DeleteArena(CommandSender sender, String[] args) {
		if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(args[1])) {
			SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(args[1]);
			for(String p : SpleefMain.SpleefMain.pdata.getArenaPlayers(arena)) {
				Player players = Bukkit.getServer().getPlayerExact(p);
				players.teleport(arena.getLobbyPoint());
				Messages.sendMessage(players, SpleefMessages.DeletedArena);
				SpleefMain.SpleefMain.pdata.removePlayerFromArena(p);
				SpleefMain.SpleefMain.pdata.removeArenaFromHashMap(arena);
				File file = new File(MainClass.main.getDataFolder() + "/Spleef/Arenas" + args[1] + ".yml");
				file.delete();
				
			}
			
		}else {
			Messages.sendMessage(sender, SpleefMessages.ArenaDoesntExists);
		}
		
	}

}
