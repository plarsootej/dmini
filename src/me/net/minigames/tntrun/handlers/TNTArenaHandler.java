package me.net.minigames.tntrun.handlers;

import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TNTArenaHandler {
	
	
	public static void CheckStarting(TNTArena arena) {
		System.out.print(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size());
		if(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size() >= 2 && !arena.isArenaStarting() == true) {
			arena.TNTCountDown.runArenaCountdown();
		}else {
			if(!arena.isArenaStarting() == true) {
				for(String p : TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§aWainting for more players...");
				}
			}

		}
	}

	public static void AddPlayer(TNTArena arena) {
		if(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size() >= 2 && !arena.isCounting() == true) {
			arena.TNTCountDown.Countdown2();
		}else {
			for(String p : TNTRunMain.TNTRunMain.pdata.getLobbyPlayers(arena)) {
				Player player = Bukkit.getPlayerExact(p);
				player.sendMessage("§cTo low number of players in the arena");
				player.sendMessage("§aWainting for more players...");
			}
		}
		
		
	}

	public static void CheckLeave(TNTArena arena) {
		if(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size() == 1) {
			if(arena.isCounting() == false && arena.isArenaStarting() == false) {
				for(String p : TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§cNo players left in the game, Leaving TNT Run");
					
					for (final TNTFloorLevel gl : arena.getGameLevels())
			        {
						gl.fillArea(arena.getArenaWorld());
			        }
					arena.arenaph.LeavePlayer(player, false);
					arena.setRunning(false);
				}
			}
			if(arena.isArenaStarting()) {
				arena.TNTCountDown.stopArenaCountdown();
				for(String p : TNTRunMain.TNTRunMain.pdata.getLobbyPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§aWainting for new players to join...");
					arena.setRunning(false);
				}
			}
			if(arena.isCounting()) {
				arena.TNTCountDown.stopArenaCountdown2();
				for(String p : TNTRunMain.TNTRunMain.pdata.getLobbyPlayers(arena)) {
					Player player = Bukkit.getPlayerExact(p);
					player.sendMessage("§aWainting for new players to join...");
					arena.setRunning(false);
				}
				
			}
			
			
		}
	}
	
	public static void checkSize(TNTArena arena) {
		if(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size() == 1) {
			for(String p : TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena)) {
				Player player = Bukkit.getPlayerExact(p);
				arena.arenaph.leaveOnEnd(player, true);
			}
		}
		
	}

}
