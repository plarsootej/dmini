package me.net.minigames.tntrun.commands;

import java.io.File;

import me.net.minigames.main.MainClass;
import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTCommandDelete {

	public static void DeleteArena(CommandSender sender, String[] args) {
		if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(args[1])) {
			TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(args[1]);
			for(String p : TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena)) {
				Player players = Bukkit.getServer().getPlayerExact(p);
				players.teleport(arena.getLobbyPoint());
				TNTMessages.sendMessage(players, TNTRunMessages.DeletedArena);
				TNTRunMain.TNTRunMain.pdata.removePlayerFromArena(p);
				TNTRunMain.TNTRunMain.pdata.removeArenaFromHashMap(arena);
				File file = new File(MainClass.main.getDataFolder() + "/TntRun/Arenas" + args[1] + ".yml");
				file.delete();
				
			}
			
		}else {
			TNTMessages.sendMessage(sender, TNTRunMessages.ArenaDoesntExists);
		}
		
	}

}
