package me.net.minigames.events;

import me.net.minigames.main.MainClass;
import me.net.minigames.teamdeathmatch.handlers.TPlayerDataStore;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDrop implements Listener{
	
	MainClass plugin;
	public ItemDrop(MainClass instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onDropEvent(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if(TPlayerDataStore.lobbied.contains(player.getName()) || TeamDeathMatchMain.TeamDeathMatchMain.pdata.plingame.containsKey(player.getName())) {
			event.setCancelled(true);
		}
	}

}
