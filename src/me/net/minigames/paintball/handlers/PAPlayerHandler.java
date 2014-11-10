package me.net.minigames.paintball.handlers;


import me.net.minigames.main.MainClass;
import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;
import me.net.minigames.paintball.methods.ToolsAndArmor;
import me.net.minigames.paintball.scoreboards.PaScoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PAPlayerHandler {
	
	public MainClass plugin;
	protected PAArenas arena;
	
	 public PAPlayerHandler(MainClass plugin, PAArenas arena)
     {
             this.plugin = plugin;
             this.arena = arena;
     }
	 
	 

	public void joinBlue(final Player player) {
		 player.teleport(arena.getLobbyPoint());
		 
		 	//setting the player arena
			
			//store armor
			PAPlayerDataStore.storePlayerArmor(player);
			//store inventory
			PAPlayerDataStore.storePlayerInventory(player);
			//store gamemdoe
			PAPlayerDataStore.storePlayerGameMode(player);
			//store hunger level
			PAPlayerDataStore.storePlayerHunger(player);
			//store Locaton
			PAPlayerDataStore.storePlayerLocation(player);
			
			ToolsAndArmor.getBlueArmor(player);

			
			if(arena.isArenaRunning()) {
				PAArenaHandler.AddPlayer(arena);
			}else {
				PAArenaHandler.CheckStarting(arena);
			}
			PaintballMain.PaintBallMain.pdata.setPlayerArena(player.getName(), arena);
			PaintballMain.PaintBallMain.pdata.setPlayerTeam(player.getName(), "blue");
			PaintballMain.PaintBallMain.pdata.setLobby(player.getName(), arena);
			
			PAPlayerDataStore.blueteam.add(player.getName());
			PaScoreBoard.loadOnJoin(player);
			
	 }
	 

	public void LeavePlayer(final Player player) {
		 
		 
		 
			
			PAPlayerDataStore.restoreLocation(player);
			
			 
			 //restore armor
			 PAPlayerDataStore.restoreArmor(player);
			 //restore inventory
			 PAPlayerDataStore.restorePlayerInventory(player);
			 //restore hunger
			 PAPlayerDataStore.restoreHunger(player);
			 //restore gamemode
			 PAPlayerDataStore.restoreGameMode(player);

		 

		 
		
		 
		 if(PAPlayerDataStore.blueteam.contains(player.getName())) {
			 PAPlayerDataStore.blueteam.remove(player.getName());
			 
		 }
		 if(PAPlayerDataStore.redteam.contains(player.getName())) {
			 PAPlayerDataStore.redteam.remove(player.getName());
			 
		 }
		 PaMessages.sendMessage(player, PaintballMessages.leaveMessage);
		 
		 if(PaintballMain.PaintBallMain.pdata.getArenaPlayers(arena).size() >=1) {
			 for(String pnames : PaintballMain.PaintBallMain.pdata.getArenaPlayers(arena)) {
					
					Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
					PaMessages.sendMessage(otherplayers, player.getName(), PaintballMessages.leavedtoothers);
				}
		 }
		
		
		PaintballMain.PaintBallMain.pdata.removePlayerFromArena(player.getName());
		PAArenaHandler.CheckLeave(arena);
		
		 //removing player from list
		PaScoreBoard.removeScoreBoard(player);
		 
	 }
	 
	 public void kickPlayer(final Player player) {
		 
			//restore location
			 PAPlayerDataStore.restoreLocation(player);
			 //restore armor
			 PAPlayerDataStore.restoreArmor(player);
			 //restore inventory
			 PAPlayerDataStore.restorePlayerInventory(player);
			 //restore hunger
			 PAPlayerDataStore.restoreHunger(player);
			 //restore gamemode
			 PAPlayerDataStore.restoreGameMode(player);

		 
		 //removing player from list
		 
		 PaMessages.sendMessage(player, PaintballMessages.kicked);
		for(String pnames : PaintballMain.PaintBallMain.pdata.getArenaPlayers(arena)) {
			Player otherplayers = Bukkit.getServer().getPlayerExact(pnames);
			PaMessages.sendMessage(otherplayers, player.getName(), PaintballMessages.kickedtoothers);
		}
		PAArenaHandler.CheckLeave(arena);
		PaintballMain.PaintBallMain.pdata.removePlayerFromArena(player.getName());
		PaScoreBoard.removeScoreBoard(player);
	 }



	@SuppressWarnings("deprecation")
	public void startGame(Player player) {
		String team = PaintballMain.PaintBallMain.pdata.getPlayerTeam(player.getName());
		if(team.equalsIgnoreCase("blue")) {
			player.teleport(arena.getBlueSpawn());
			player.sendMessage("Succesfully started team §9blue");
		}
		if(team.equalsIgnoreCase("red")) {
			player.teleport(arena.getRedSpawn());
			player.sendMessage("Succesfully started team §cRed");
		}
		player.setGameMode(GameMode.SURVIVAL);
		PaintballMain.PaintBallMain.pdata.removePlayerFromLobby(player.getName());
		PAPlayerDataStore.lobbied.clear();
		
		Inventory pi = player.getInventory();
		final int ShootWeaponID = ConfigHandler.Paintball.getInt("Weapons.Shoot-Weapon-ID");
		final int ShotGunID = ConfigHandler.Paintball.getInt("Weapons.ShotGun-ID");
		final int SniperID = ConfigHandler.Paintball.getInt("Weapons.SniperGun-ID");
		final int DamageGrenadeID = ConfigHandler.Paintball.getInt("Weapons.Damage-Grenade-ID");
		final int FlashGrenadeID = ConfigHandler.Paintball.getInt("Weapons.Flash-Grenade-ID");
		
		ItemStack shootweapon = new ItemStack(ShootWeaponID);
		ItemMeta shootMeta = shootweapon.getItemMeta();
		shootMeta.setDisplayName("§6Normal Gun");
		shootweapon.setItemMeta(shootMeta);
		player.getInventory().addItem(shootweapon);
		
		ItemStack shotgun = new ItemStack(Material.getMaterial(ShotGunID));
		ItemMeta shotgunmeta = shotgun.getItemMeta();
		shotgunmeta.setDisplayName("§6ShotGun");
		shotgun.setItemMeta(shotgunmeta);
		player.getInventory().addItem(shotgun);
		
		ItemStack sniper = new ItemStack(Material.getMaterial(SniperID));
		ItemMeta snipermeta = sniper.getItemMeta();
		snipermeta.setDisplayName("§6Sniper");
		sniper.setItemMeta(snipermeta);
		player.getInventory().addItem(sniper);
		
		ItemStack DamageGrenade = new ItemStack(Material.getMaterial(DamageGrenadeID));
		ItemMeta DamageGrenademeta = DamageGrenade.getItemMeta();
		DamageGrenademeta.setDisplayName("§6Grenade");
		DamageGrenade.setItemMeta(DamageGrenademeta);
		player.getInventory().addItem(DamageGrenade);
		
		ItemStack FlashGrenade = new ItemStack(Material.getMaterial(FlashGrenadeID));
		ItemMeta FlashGrenademeta = FlashGrenade.getItemMeta();
		FlashGrenademeta.setDisplayName("§6Flash Grenade");
		FlashGrenade.setItemMeta(FlashGrenademeta);
		player.getInventory().addItem(FlashGrenade);
		
		ItemStack[] snowballs = {new ItemStack(Material.SNOW_BALL, 16), new ItemStack(Material.SNOW_BALL, 16), new ItemStack(Material.SNOW_BALL, 16), new ItemStack(Material.SNOW_BALL, 16)};
		pi.addItem(snowballs);
		player.updateInventory();
		
	}
	
	public void startLobbied(Player player) {
		String team = PaintballMain.PaintBallMain.pdata.getPlayerTeam(player.getName());
		if(team.equalsIgnoreCase("blue")) {
			player.teleport(arena.getBlueSpawn());
			player.sendMessage("Succesfully started team §9blue");
		}
		if(team.equalsIgnoreCase("red")) {
			player.teleport(arena.getRedSpawn());
			player.sendMessage("Succesfully started team §cRed");
		}
		player.setGameMode(GameMode.SURVIVAL);
		PaintballMain.PaintBallMain.pdata.removePlayerFromLobby(player.getName());
		PAPlayerDataStore.lobbied.clear();
		
		ToolsAndArmor.getTools(player);
	}



	public void joinRed(Player player) {
		player.teleport(arena.getLobbyPoint());
		 
	 	//setting the player arena
		
		//store armor
		PAPlayerDataStore.storePlayerArmor(player);
		//store inventory
		PAPlayerDataStore.storePlayerInventory(player);
		//store gamemdoe
		PAPlayerDataStore.storePlayerGameMode(player);
		//store hunger level
		PAPlayerDataStore.storePlayerHunger(player);
		//store Locaton
		PAPlayerDataStore.storePlayerLocation(player);
		
		ToolsAndArmor.getRedArmor(player);
		
		//message
		player.sendMessage("§aSuccesfully joined team §fred §ain arena §f" + arena.getArenaName());
		if(arena.isArenaRunning()) {
			PAArenaHandler.AddPlayer(arena);
		}else {
			PAArenaHandler.CheckStarting(arena);
		}
		PaintballMain.PaintBallMain.pdata.setPlayerArena(player.getName(), arena);
		PaintballMain.PaintBallMain.pdata.setPlayerTeam(player.getName(), "red");
		PaintballMain.PaintBallMain.pdata.setLobby(player.getName(), arena);
		PAArenaHandler.CheckStarting(arena);
		
		PAPlayerDataStore.redteam.add(player.getName());
		PaScoreBoard.loadOnJoin(player);
	}
	
	

}
