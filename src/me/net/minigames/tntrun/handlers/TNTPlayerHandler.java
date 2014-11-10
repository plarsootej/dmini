package me.net.minigames.tntrun.handlers;

import java.util.ArrayList;
import java.util.Random;

import me.net.minigames.main.MainClass;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class TNTPlayerHandler {
	
	public MainClass plugin;
	protected TNTArena arena;
	
	 public TNTPlayerHandler(MainClass plugin, TNTArena arena)
     {
             this.plugin = plugin;
             this.arena = arena;
     }
	 
	 public void join(final Player player) {
		 player.teleport(arena.getLobbyPoint());
		 
		 	//setting the player arena
			
			//store armor
			TNTPlayerDataStore.storePlayerArmor(player);
			//store inventory
			TNTPlayerDataStore.storePlayerInventory(player);
			//store gamemdoe
			TNTPlayerDataStore.storePlayerGameMode(player);
			//store hunger level
			TNTPlayerDataStore.storePlayerHunger(player);
			//store Locaton
			TNTPlayerDataStore.storePlayerLocation(player);
			

	
			TNTRunMain.TNTRunMain.pdata.setLobby(player.getName(), arena);
			if(arena.isArenaRunning()) {
				player.sendMessage("§aWaiting before running game is ended");
				player.sendMessage("§aTeleported To lobby");
			}else {
				TNTArenaHandler.CheckStarting(arena);
			}
	 }
	 
	 private ArrayList<String> spawnlocs = new ArrayList<String>();
	 public void startGame(final Player player) {
		 
			
			for (final TNTFloorLevel gl : arena.getGameLevels())
	        {
				gl.fillArea(arena.getArenaWorld());
	        }
		 
		 for(TNTSpawnLocation sl : arena.spawnlocations) {
			 spawnlocs.add(sl.getSpawnLocationName());
		 }
		 int random = new Random().nextInt(spawnlocs.size());
		 String name = spawnlocs.get(random);
		 TNTSpawnLocation loc = arena.getSpawnLocationByName(name);
		 player.teleport(loc.getP1().toLocation(arena.getArenaWorld()));

		player.setGameMode(GameMode.SURVIVAL);
		TNTRunMain.TNTRunMain.pdata.removePlayerFromLobby(arena, player.getName());
		TNTPlayerDataStore.lobbied.clear();
	 }

	public void startLobbied(Player player) {
		for (final TNTFloorLevel gl : arena.getGameLevels())
        {
			gl.fillArea(arena.getArenaWorld());
        }
		 for(TNTSpawnLocation sl : arena.spawnlocations) {
			 spawnlocs.add(sl.getSpawnLocationName());
		 }
		 int random = new Random().nextInt(spawnlocs.size());
		 String name = spawnlocs.get(random);
		 TNTSpawnLocation loc = arena.getSpawnLocationByName(name);
		 player.teleport(loc.getP1().toLocation(arena.getArenaWorld()));

		player.setGameMode(GameMode.SURVIVAL);
		TNTRunMain.TNTRunMain.pdata.removePlayerFromLobby(arena, player.getName());
		TNTPlayerDataStore.lobbied.clear();
		
	}

		public void LeavePlayer(final Player player, boolean checkLeave) {
			 
			 
			 
			
			 //restore location
            TNTRunMain.TNTRunMain.pdata.restoreLocation(player);
             //restore player status
            TNTRunMain.TNTRunMain.pdata.restoreHunger(player);
            TNTRunMain.TNTRunMain.pdata.restoreArmor(player);
            TNTRunMain.TNTRunMain.pdata.restorePlayerInventory(player);
            TNTRunMain.TNTRunMain.pdata.restoreGameMode(player);
		

	 
		TNTMessages.sendMessage(player, TNTRunMessages.leaveMessage);
		TNTRunMain.TNTRunMain.pdata.removePlayerFromArena(player.getName());
		TNTRunMain.TNTRunMain.pdata.removePlayerFromLobby(arena, player.getName());
		if(TNTPlayerDataStore.playing.contains(player.getName())) {
			TNTPlayerDataStore.playing.remove(player.getName());
		}
		if(checkLeave == true) {
			TNTArenaHandler.CheckLeave(arena);
		}
		
		if(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size() >=1) {
			for(String pnames : TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena)) {
				
				Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
				TNTMessages.sendMessage(otherplayers, player.getName(), TNTRunMessages.leavedtoothers);
			}
		}
		}
		
		public void leaveOnEnd(Player player, boolean winner) {
			if(winner == false) {
				
				TNTMessages.sendMessage(player, TNTRunMessages.Lose);
				
				 //restore location
	               TNTRunMain.TNTRunMain.pdata.restoreLocation(player);
	                //restore player status
	               TNTRunMain.TNTRunMain.pdata.restoreHunger(player);
	               TNTRunMain.TNTRunMain.pdata.restoreArmor(player);
	               TNTRunMain.TNTRunMain.pdata.restorePlayerInventory(player);
	               TNTRunMain.TNTRunMain.pdata.restoreGameMode(player);
				
				TNTRunMain.TNTRunMain.pdata.removePlayerFromArena(player.getName());
				if(TNTPlayerDataStore.playing.contains(player.getName())) {
					TNTPlayerDataStore.playing.remove(player.getName());
				}
				
				if(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size() >=1) {
					for(String p : TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena)) {
						Player otherplayers = Bukkit.getPlayerExact(p);
						otherplayers.sendMessage(player.getName() + "§a Has fallen, There are §c" + TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size() + "§a Left in the game!");
					}
				}
			}
			if(winner == true) {
				
				TNTMessages.sendMessage(player, TNTRunMessages.Winner);
	                //restore location
	               TNTRunMain.TNTRunMain.pdata.restoreLocation(player);
	                //restore player status
	               TNTRunMain.TNTRunMain.pdata.restoreHunger(player);
	               TNTRunMain.TNTRunMain.pdata.restoreArmor(player);
	               TNTRunMain.TNTRunMain.pdata.restorePlayerInventory(player);
	               TNTRunMain.TNTRunMain.pdata.restoreGameMode(player);
				
				TNTRunMain.TNTRunMain.pdata.removePlayerFromArena(player.getName());
				if(TNTPlayerDataStore.playing.contains(player.getName())) {
					TNTPlayerDataStore.playing.remove(player.getName());
				}
				for (final TNTFloorLevel gl : arena.getGameLevels())
		        {
					gl.fillArea(arena.getArenaWorld());
		        }
				arena.setRunning(false);
			}
			 
		}

		
		
		
		public void leaveOnDisable(Player player) {
			
			 
			 //restore location
            TNTRunMain.TNTRunMain.pdata.restoreLocation(player);
             //restore player status
            TNTRunMain.TNTRunMain.pdata.restoreHunger(player);
            TNTRunMain.TNTRunMain.pdata.restoreArmor(player);
            TNTRunMain.TNTRunMain.pdata.restorePlayerInventory(player);
            TNTRunMain.TNTRunMain.pdata.restoreGameMode(player);
            
			TNTMessages.sendMessage(player, TNTRunMessages.Disabling);
			TNTRunMain.TNTRunMain.pdata.removePlayerFromArena(player.getName());
			if(TNTPlayerDataStore.playing.contains(player.getName())) {
				TNTPlayerDataStore.playing.remove(player.getName());
			}
		}

		public void kickPlayer(Player player) {
			
			 //restore location
            TNTRunMain.TNTRunMain.pdata.restoreLocation(player);
             //restore player status
            TNTRunMain.TNTRunMain.pdata.restoreHunger(player);
            TNTRunMain.TNTRunMain.pdata.restoreArmor(player);
            TNTRunMain.TNTRunMain.pdata.restorePlayerInventory(player);
            TNTRunMain.TNTRunMain.pdata.restoreGameMode(player);

		 
			TNTMessages.sendMessage(player, TNTRunMessages.leaveMessage);
			TNTRunMain.TNTRunMain.pdata.removePlayerFromArena(player.getName());
			if(TNTPlayerDataStore.playing.contains(player.getName())) {
				TNTPlayerDataStore.playing.remove(player.getName());
			}
			TNTArenaHandler.CheckLeave(arena);
			if(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size() >=1) {
				for(String pnames : TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena)) {
					
					Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
					TNTMessages.sendMessage(otherplayers, player.getName(), TNTRunMessages.kickedtoothers);
				}
		 }
		}
		

}
