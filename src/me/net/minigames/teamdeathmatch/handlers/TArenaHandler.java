package me.net.minigames.teamdeathmatch.handlers;

import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class TArenaHandler {
	
	public static void CheckStarting(TArenas arena) {
		if(TPlayerDataStore.redteam.size() >=1 && TPlayerDataStore.blueteam.size() >= 1 && !arena.isArenaStarting() == true) {
			arena.TCountDown.runArenaCountdown();
		}else {
			for(String p : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaPlayers(arena)) {
				Player player = Bukkit.getPlayerExact(p);
				player.sendMessage("§aWainting for more players...");
			}
		}
	}

	public static void AddPlayer(TArenas arena) {
		if(TPlayerDataStore.redteam.size() >=1 && TPlayerDataStore.blueteam.size() >=1 && !arena.isCounting() == true) {
			arena.TCountDown.Countdown2();
		}else {
			for(String p : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getLobbyPlayers(arena)) {
				Player player = Bukkit.getPlayerExact(p);
				player.sendMessage("§cTo low number of players in the arena");
				player.sendMessage("§aWainting for more players...");
			}
		}
		
		
	}

	public static void CheckLeave(TArenas arena) {
		if(TPlayerDataStore.redteam.size() ==0 || TPlayerDataStore.blueteam.size() ==0) {
			if(arena.isArenaStarting() == false && arena.isCounting() == false && arena.isArenaRunning() == true){
				for(String p : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§cNo players left in the other team, Leaving team deathmatch");
					arena.arenaph.LeavePlayer(player, false);
					arena.setRunning(false);
				}
			}
			if(arena.isArenaStarting()) {
				arena.TCountDown.stopArenaCountdown();
				for(String p : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getLobbyPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§aWainting for new players to join...");
				}
			}
			if(arena.isCounting()) {
				arena.TCountDown.stopArenaCountdown2();
				for(String p : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getLobbyPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§aWainting for new players to join...");
					arena.setRunning(false);
				}
				
			}
			
			
		}
	}

}
