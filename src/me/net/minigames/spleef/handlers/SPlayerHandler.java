package me.net.minigames.spleef.handlers;

import me.net.minigames.main.MainClass;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SPlayerHandler {
	
	public MainClass plugin;
	protected SArena arena;
	
	 public SPlayerHandler(MainClass plugin, SArena arena)
     {
             this.plugin = plugin;
             this.arena = arena;
     }
	 
	 public void lobbyPlayer(final Player player) {
		 player.teleport(arena.getLobbyPoint());
		 
		 	//setting the player arena
			
			//store armor
			SPlayerDataStore.storePlayerArmor(player);
			//store inventory
			SPlayerDataStore.storePlayerInventory(player);
			//store gamemdoe
			SPlayerDataStore.storePlayerGameMode(player);
			//store hunger level
			SPlayerDataStore.storePlayerHunger(player);
			//store Locaton
			SPlayerDataStore.storePlayerLocation(player);
			//message
			
			for(String pnames : SpleefMain.SpleefMain.pdata.getArenaPlayers(arena)) {
				Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
				Messages.sendMessage(otherplayers, player.getName(), SpleefMessages.joinedtoothers);
			}
			SpleefMain.SpleefMain.pdata.setPlayerArena(player.getName(), arena);
			SpleefMessages.JoinMessage(player);
			
	 }
	 
	 public void spawnPlayer(final Player player) {
		 
		 player.teleport(arena.getSpawnPoint());
	 }
	 
	 public void LeavePlayer(final Player player) {
		//restore location
		SPlayerDataStore.restoreLocation(player);
		//restore armor
		SPlayerDataStore.restoreArmor(player);
		//restore inventory
		SPlayerDataStore.restorePlayerInventory(player);
		//restore hunger
		SPlayerDataStore.restoreHunger(player);
		//restore gamemode
		SPlayerDataStore.restoreGameMode(player);
		 
		//removing player from list
		SpleefMain.SpleefMain.pdata.removePlayerFromArena(player.getName());
		 
		 
		Messages.sendMessage(player, SpleefMessages.leaveMessage);
		 
		for(String pnames : SpleefMain.SpleefMain.pdata.getArenaPlayers(arena)) {
			Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
			Messages.sendMessage(otherplayers, player.getName(), SpleefMessages.leavedtoothers);
		}
			
		
	 }
	 
	 public void kickPlayer(final Player player) {
		 //restore location
		 SPlayerDataStore.restoreLocation(player);
		 //restore armor
		 SPlayerDataStore.restoreArmor(player);
		 //restore inventory
		 SPlayerDataStore.restorePlayerInventory(player);
		 //restore hunger
		 SPlayerDataStore.restoreHunger(player);
		 //restore gamemode
		 SPlayerDataStore.restoreGameMode(player);
		 
		 //removing player from list
		 SpleefMain.SpleefMain.pdata.removePlayerFromArena(player.getName());
		 
		 Messages.sendMessage(player, SpleefMessages.kicked);
			for(String pnames : SpleefMain.SpleefMain.pdata.getArenaPlayers(arena)) {
				Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
				Messages.sendMessage(otherplayers, player.getName(), SpleefMessages.kickedtoothers);
			}
	 }

}
