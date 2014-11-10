package me.net.minigames.spleef.handlers;

import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.methods.Game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ArenaHandler {
	
	public static void CheckStarting(SArena arena) {
		if(SpleefMain.SpleefMain.pdata.getArenaPlayers(arena).size() >= 2 && !arena.isArenaStarting() == true) {
			arena.SCountdown.runArenaCountdown();
		}
	}

	public static void checkSize(SArena arena) {
		if(SpleefMain.SpleefMain.pdata.getArenaPlayers(arena).size() == 1) {
			for(String p : SpleefMain.SpleefMain.pdata.getArenaPlayers(arena)) {
				Player player = Bukkit.getPlayerExact(p);
				Game.Winner(player);
			}
		}
		
	}

}
