package me.net.minigames.events;

import me.net.minigames.main.MainClass;
import me.net.minigames.spleef.events.SpleefBlockDamageEvent;
import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;


public class BlockDamage implements Listener
{
	
	MainClass plugin;
	public BlockDamage (MainClass instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void OnBlockDamage(BlockDamageEvent event) {
		Player player = event.getPlayer();
		if(SpleefMain.SpleefMain.pdata.plingame.containsKey(player.getName())) {
			SpleefBlockDamageEvent.DamageEvent(event);
		}
	}

}
