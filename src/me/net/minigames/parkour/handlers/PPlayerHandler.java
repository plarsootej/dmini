package me.net.minigames.parkour.handlers;

import me.net.minigames.main.MainClass;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PPlayerHandler {
	
	public MainClass plugin;
	protected PArena arena;
	
	 public PPlayerHandler(MainClass plugin, PArena arena)
     {
             this.plugin = plugin;
             this.arena = arena;
     }
	 
	 public void JoinPlayer(Player player) {
		 player.teleport(arena.getSpawnPoint());
		 
		 	//setting the player arena
			PPlayerDataStore.pfells.put(player.getName(), 0);
			//store armor
			PPlayerDataStore.storePlayerArmor(player);
			//store inventory
			PPlayerDataStore.storePlayerInventory(player);
			//store gamemdoe
			PPlayerDataStore.storePlayerGameMode(player);
			//store hunger level
			PPlayerDataStore.storePlayerHunger(player);
			//store Locaton
			PPlayerDataStore.storePlayerLocation(player);
			//message
			
			for(String pnames : ParkourMain.ParkourMain.pdata.getArenaPlayers(arena)) {
				Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
				Messages.sendMessage(otherplayers, player.getName(), ParkourMessages.joinedtoothers);
			}
			
			ParkourMain.ParkourMain.pdata.setPlayerArena(player.getName(), arena);
			player.sendMessage("§aSuccesfully joined parkour: §f"+arena.getArenaName());		
	 }

	public static void EndParkour(Player player, PArena arena) {
		//restore location
		 PPlayerDataStore.restoreLocation(player);
		 //restore armor
		 PPlayerDataStore.restoreArmor(player);
		 //restore inventory
		 PPlayerDataStore.restorePlayerInventory(player);
		 //restore hunger
		 PPlayerDataStore.restoreHunger(player);
		 //restore gamemode
		 PPlayerDataStore.restoreGameMode(player);
		 
		 int fells = ParkourMain.ParkourMain.pdata.getPlayerFells(player.getName());
		 
		 //removing player from list
		 ParkourMain.ParkourMain.pdata.removePlayerFromArena(player.getName());
		 
		 player.sendMessage("§aYou have succesfully completed parkour: §b" + arena.getArenaName());
		 player.sendMessage("§aYou fell §6" + fells + "§a times");
	}
	
	public void leaveParkour(Player player) {
		//restore location
		 PPlayerDataStore.restoreLocation(player);
		 //restore armor
		 PPlayerDataStore.restoreArmor(player);
		 //restore inventory
		 PPlayerDataStore.restorePlayerInventory(player);
		 //restore hunger
		 PPlayerDataStore.restoreHunger(player);
		 //restore gamemode
		 PPlayerDataStore.restoreGameMode(player);
		 //removing from list
		 ParkourMain.ParkourMain.pdata.removePlayerFromArena(player.getName());
		 player.sendMessage("§aYou succesfully left the parkour!");
	}
	
	public void kickPlayer(CommandSender sender, Player player) {
		//restore location
		 PPlayerDataStore.restoreLocation(player);
		 //restore armor
		 PPlayerDataStore.restoreArmor(player);
		 //restore inventory
		 PPlayerDataStore.restorePlayerInventory(player);
		 //restore hunger
		 PPlayerDataStore.restoreHunger(player);
		 //restore gamemode
		 PPlayerDataStore.restoreGameMode(player);
		 //removing from list
		 ParkourMain.ParkourMain.pdata.removePlayerFromArena(player.getName());
		 player.sendMessage("§cYou have been kicked out of the parkour by: §f" + sender.getName());
		 sender.sendMessage("§aYou have succesfully kicked §f" + player.getName() + "§a Out of the parkour");
	}

}
