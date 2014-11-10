package me.net.minigames.events;


import me.net.minigames.main.MainClass;
import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.handlers.TKit;
import me.net.minigames.teamdeathmatch.handlers.TPlayerDataStore;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.methods.TRestoreKit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnEvent implements Listener{
	
	MainClass plugin;
	public RespawnEvent(MainClass instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.plingame.containsKey(player.getName())) {
			
			TKit kit = TeamDeathMatchMain.TeamDeathMatchMain.kdata.getPlayerKit(player.getName());
			
			TRestoreKit.RestoreKit(player, kit);
			player.getInventory().clear();
			
			
			TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getPlayerArena(player.getName());
			
			if(TPlayerDataStore.redteam.contains(player.getName())) {
				player.teleport(arena.getRedSpawn());
			}
			if(TPlayerDataStore.blueteam.contains(player.getName())) {
				player.teleport(arena.getBlueSpawn());
			}
			
			
		}
	}

}
