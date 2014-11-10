package me.net.minigames.spleef.methods;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.handlers.SPlayerDataStore;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.entity.Player;

public class Game {
	
	public static void Loser(Player player) {
		SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(player.getName());
		//restore player
		RestorePlayer(player);
		
		SpleefMessages.LostToOtherPlayers(arena, player);
		Messages.sendMessage(player, SpleefMessages.Lose);
		
	}
	
	public static void Winner(Player player) {
		//restore arena
		SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(player.getName());
		String arenaname = arena.getArenaName();
		SCreateFloor.CreateFloor(arenaname);
		arena.setRunning(false);
		//restore player
		RestorePlayer(player);
		
		//messages
		Messages.sendMessage(player, SpleefMessages.Winner);
		
		
	}
	
	private static void RestorePlayer(Player player) {
		
	    SpleefMain.SpleefMain.pdata.removePlayerFromArena(player.getName());
        //restore location
	    SPlayerDataStore.restoreLocation(player);
        //restore player status
	    SPlayerDataStore.restoreHunger(player);
	    SPlayerDataStore.restoreArmor(player);
	    SPlayerDataStore.restorePlayerInventory(player);
	}

}
