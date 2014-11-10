package me.net.minigames.teamdeathmatch.handlers;


import java.util.Map.Entry;

import me.net.minigames.main.MainClass;
import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;
import me.net.minigames.teamdeathmatch.scoreboards.TScoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class TPlayerHandler {
	
	public MainClass plugin;
	protected TArenas arena;
	
	 public TPlayerHandler(MainClass plugin, TArenas arena)
     {
             this.plugin = plugin;
             this.arena = arena;
     }
	 
	 

	 @SuppressWarnings("deprecation")
	public void joinBlue(final Player player) {
		 player.teleport(arena.getLobbyPoint());
		 
		 	//setting the player arena
			
			//store armor
			TPlayerDataStore.storePlayerArmor(player);
			//store inventory
			TPlayerDataStore.storePlayerInventory(player);
			//store gamemdoe
			TPlayerDataStore.storePlayerGameMode(player);
			//store hunger level
			TPlayerDataStore.storePlayerHunger(player);
			//store Locaton
			TPlayerDataStore.storePlayerLocation(player);
			
			//helmet
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
			helmMeta.setColor(Color.BLUE);
			helm.setItemMeta(helmMeta);
			player.getInventory().setHelmet(helm);
			player.updateInventory();
			
			//message
			player.sendMessage("§aSuccesfully joined team §fblue §ain arena §f" + arena.getArenaName());
			player.sendMessage("§aTeleport to lobby choose kit: §f/tdm kit <kitname|list>");
			if(arena.isArenaRunning()) {
				TArenaHandler.AddPlayer(arena);
			}else {
				TArenaHandler.CheckStarting(arena);
			}
			TeamDeathMatchMain.TeamDeathMatchMain.pdata.setPlayerArena(player.getName(), arena);
			TeamDeathMatchMain.TeamDeathMatchMain.pdata.setPlayerTeam(player.getName(), "blue");
			TeamDeathMatchMain.TeamDeathMatchMain.pdata.setLobby(player.getName(), arena);
			
			TPlayerDataStore.blueteam.add(player.getName());
			TScoreBoard.loadOnJoin(player);
			
	 }
	 
	 public void LeavePlayer(final Player player, boolean checkLeave) {
		 
		 
		 
			
			TPlayerDataStore.restoreLocation(player);
			
			 
			 //restore armor
			 TPlayerDataStore.restoreArmor(player);
			 //restore inventory
			 TPlayerDataStore.restorePlayerInventory(player);
			 //restore hunger
			 TPlayerDataStore.restoreHunger(player);
			 //restore gamemode
			 TPlayerDataStore.restoreGameMode(player);

		 

		 
		
		 
		 if(TPlayerDataStore.blueteam.contains(player.getName())) {
			 TPlayerDataStore.blueteam.remove(player.getName());
			 
		 }
		 if(TPlayerDataStore.redteam.contains(player.getName())) {
			 TPlayerDataStore.redteam.remove(player.getName());
			 
		 }
		 TMessages.sendMessage(player, TeamDeathMatchMessages.leaveMessage);
		 TeamDeathMatchMain.TeamDeathMatchMain.pdata.removePlayerFromArena(player.getName());
		 if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.getLobbyPlayers(arena).contains(player.getName())) {
			 TeamDeathMatchMain.TeamDeathMatchMain.pdata.removePlayerFromLobby(player.getName());
		 }
		 
		 TScoreBoard.removeScoreBoard(player);
		 if(checkLeave == true) {
			 TArenaHandler.CheckLeave(arena);
		 }
		
		 if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaPlayers(arena).size() >=1) {
			 for(String pnames : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaPlayers(arena)) {
					
					Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
					TMessages.sendMessage(otherplayers, player.getName(), TeamDeathMatchMessages.leavedtoothers);
				}
		 }

		
		 //removing player from list
		 
	 }
	 
	 public void kickPlayer(final Player player) {
		 
			//restore location
			 TPlayerDataStore.restoreLocation(player);
			 //restore armor
			 TPlayerDataStore.restoreArmor(player);
			 //restore inventory
			 TPlayerDataStore.restorePlayerInventory(player);
			 //restore hunger
			 TPlayerDataStore.restoreHunger(player);
			 //restore gamemode
			 TPlayerDataStore.restoreGameMode(player);

		 
		 //removing player from list
		 
		 
		 TMessages.sendMessage(player, TeamDeathMatchMessages.kicked);
			for(String pnames : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaPlayers(arena)) {
				Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
				TMessages.sendMessage(otherplayers, player.getName(), TeamDeathMatchMessages.kickedtoothers);
			}
			
			TeamDeathMatchMain.TeamDeathMatchMain.pdata.removePlayerFromArena(player.getName());
			TeamDeathMatchMain.TeamDeathMatchMain.kdata.RemovePlayerFromLists(player.getName());
			 TScoreBoard.removeScoreBoard(player);
			TArenaHandler.CheckLeave(arena);
	 }



	@SuppressWarnings("deprecation")
	public void startGame(Player player) {
		String team = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getPlayerTeam(player.getName());
		if(team.equalsIgnoreCase("blue")) {
			player.teleport(arena.getBlueSpawn());
			player.sendMessage("Succesfully started team §9blue");
		}
		if(team.equalsIgnoreCase("red")) {
			player.teleport(arena.getRedSpawn());
			player.sendMessage("Succesfully started team §cRed");
		}
		player.setGameMode(GameMode.SURVIVAL);
		TeamDeathMatchMain.TeamDeathMatchMain.pdata.removePlayerFromLobby(player.getName());
		TPlayerDataStore.lobbied.clear();
		String defaultkit = ConfigHandler.MainTDM.getString("Default-Kit");
		if(!TeamDeathMatchMain.TeamDeathMatchMain.kdata.pkit.containsKey(player.getName())) {
			if(TeamDeathMatchMain.TeamDeathMatchMain.kdata.kitnames.containsKey(defaultkit)) {
				TKit kit = TeamDeathMatchMain.TeamDeathMatchMain.kdata.getKitByName(defaultkit);
				
				
				player.getInventory().clear();
				player.getInventory().setChestplate(new ItemStack(Material.getMaterial(kit.getChestPlate())));
				player.getInventory().setLeggings(new ItemStack(Material.getMaterial(kit.getLeggings())));
				player.getInventory().setBoots(new ItemStack(Material.getMaterial(kit.getBoots())));
				player.getInventory().setItemInHand(new ItemStack(Material.getMaterial(kit.getInHand())));
				
				for(Entry<Material, Integer> entry : TeamDeathMatchMain.TeamDeathMatchMain.kdata.items.entrySet())
				{
					player.getInventory().addItem(new ItemStack(entry.getKey(), entry.getValue()));
				}
				player.updateInventory();
				TeamDeathMatchMain.TeamDeathMatchMain.kdata.setPlayerKit(player.getName(), kit);
			}else {
				player.sendMessage(defaultkit);
			}
		}
	}
	
	public void startLobbied(Player player) {
		String team = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getPlayerTeam(player.getName());
		if(team.equalsIgnoreCase("blue")) {
			player.teleport(arena.getBlueSpawn());
			player.sendMessage("Succesfully started team §9blue");
		}
		if(team.equalsIgnoreCase("red")) {
			player.teleport(arena.getRedSpawn());
			player.sendMessage("Succesfully started team §cRed");
		}
		TeamDeathMatchMain.TeamDeathMatchMain.pdata.removePlayerFromLobby(player.getName());
		TPlayerDataStore.lobbied.clear();
	}



	@SuppressWarnings("deprecation")
	public void joinRed(Player player) {
		player.teleport(arena.getLobbyPoint());
		 
	 	//setting the player arena
		
		//store armor
		TPlayerDataStore.storePlayerArmor(player);
		//store inventory
		TPlayerDataStore.storePlayerInventory(player);
		//store gamemdoe
		TPlayerDataStore.storePlayerGameMode(player);
		//store hunger level
		TPlayerDataStore.storePlayerHunger(player);
		//store Locaton
		TPlayerDataStore.storePlayerLocation(player);
		
		//helmet
		ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
		helmMeta.setColor(Color.RED);
		helm.setItemMeta(helmMeta);
		player.getInventory().setHelmet(helm);
		player.updateInventory();
		
		//message
		player.sendMessage("§aSuccesfully joined team §fred §ain arena §f" + arena.getArenaName());
		player.sendMessage("§aTeleport to lobby choose kit: §f/tdm kit <kitname|list>");
		if(arena.isArenaRunning()) {
			TArenaHandler.AddPlayer(arena);
		}else {
			TArenaHandler.CheckStarting(arena);
		}
		TeamDeathMatchMain.TeamDeathMatchMain.pdata.setPlayerArena(player.getName(), arena);
		TeamDeathMatchMain.TeamDeathMatchMain.pdata.setPlayerTeam(player.getName(), "red");
		TeamDeathMatchMain.TeamDeathMatchMain.pdata.setLobby(player.getName(), arena);
		TArenaHandler.CheckStarting(arena);
		TScoreBoard.loadOnJoin(player);
		
		TPlayerDataStore.redteam.add(player.getName());
	}



	public void LeaveOnDisable(Player player) {
		
		TPlayerDataStore.restoreLocation(player);
		
		 
		 //restore armor
		 TPlayerDataStore.restoreArmor(player);
		 //restore inventory
		 TPlayerDataStore.restorePlayerInventory(player);
		 //restore hunger
		 TPlayerDataStore.restoreHunger(player);
		 //restore gamemode
		 TPlayerDataStore.restoreGameMode(player);
		 if(TPlayerDataStore.blueteam.contains(player.getName())) {
			 TPlayerDataStore.blueteam.remove(player.getName());
			 
		 }
		 if(TPlayerDataStore.redteam.contains(player.getName())) {
			 TPlayerDataStore.redteam.remove(player.getName());
			 
		 }
		 TeamDeathMatchMain.TeamDeathMatchMain.pdata.removePlayerFromArena(player.getName());
		 if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.getLobbyPlayers(arena).contains(player.getName())) {
			 TeamDeathMatchMain.TeamDeathMatchMain.pdata.removePlayerFromLobby(player.getName());
		 }
		 
	}

}
