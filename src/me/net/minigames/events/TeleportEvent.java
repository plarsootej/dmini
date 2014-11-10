package me.net.minigames.events;

import me.net.minigames.main.MainClass;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class TeleportEvent implements Listener{
	
	MainClass plugin;
	public TeleportEvent(MainClass instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void Teleport(PlayerTeleportEvent event) {
		if(event.getCause() == TeleportCause.ENDER_PEARL) {
			event.setCancelled(true);
		}
	}

}
