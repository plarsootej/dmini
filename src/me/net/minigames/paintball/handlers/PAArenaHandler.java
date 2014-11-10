package me.net.minigames.paintball.handlers;


import me.net.minigames.paintball.PaintballMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class PAArenaHandler {
	
	public static void CheckStarting(PAArenas arena) {
		if(PAPlayerDataStore.redteam.size() >=1 && PAPlayerDataStore.blueteam.size() >= 1 && !arena.isArenaStarting() == true) {
			arena.PACountDown.runArenaCountdown();
		}else {
			for(String p : PaintballMain.PaintBallMain.pdata.getArenaPlayers(arena)) {
				Player player = Bukkit.getPlayerExact(p);
				player.sendMessage("§aWainting for more players...");
			}
		}
	}

	public static void AddPlayer(PAArenas arena) {
		if(PAPlayerDataStore.redteam.size() >=1 && PAPlayerDataStore.blueteam.size() >=1 && !arena.isCounting() == true) {
			arena.PACountDown.Countdown2();
		}else {
			for(String p : PaintballMain.PaintBallMain.pdata.getLobbyPlayers(arena)) {
				Player player = Bukkit.getPlayerExact(p);
				player.sendMessage("§cTo low number of players in the arena");
				player.sendMessage("§aWainting for more players...");
			}
		}
		
		
	}

	public static void CheckLeave(PAArenas arena) {
		if(PAPlayerDataStore.redteam.size() ==0 || PAPlayerDataStore.blueteam.size() ==0) {
			if(arena.isArenaStarting()) {
				arena.PACountDown.stopArenaCountdown();
				for(String p : PaintballMain.PaintBallMain.pdata.getLobbyPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§aWainting for new players to join...");
				}
			}
			if(arena.isCounting()) {
				arena.PACountDown.stopArenaCountdown2();
				for(String p : PaintballMain.PaintBallMain.pdata.getLobbyPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§aWainting for new players to join...");
					arena.setRunning(false);
				}
				
			}else {
				for(String p : PaintballMain.PaintBallMain.pdata.getArenaPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§cNo players left in the other team, Leaving team deathmatch");
					arena.arenaph.LeavePlayer(player);
					arena.setRunning(false);
				}
			}
			
			
		}
	}

}
