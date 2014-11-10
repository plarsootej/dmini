package me.net.minigames.events;


import me.net.minigames.main.MainClass;
import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.spleef.events.SpleefBlockBreak;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.teamdeathmatch.handlers.TPlayerDataStore;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreak implements Listener{
	
	MainClass plugin;
	public BlockBreak (MainClass instance) {
		plugin = instance;
	}
	
	private static int tntwandtoolid = ConfigHandler.TNTMainConfig.getInt("Wand-Tool-ID");
	private static int spleefwandtoolid = ConfigHandler.MainSpleef.getInt("Wand-Tool-ID");
	private static int tdmwandtoolid = ConfigHandler.MainTDM.getInt("Wand-Tool-ID");


	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockBreak (BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(SpleefMain.wand.contains(player)) {
			ItemStack inhand = player.getItemInHand();
			if(inhand.getType() == Material.getMaterial(spleefwandtoolid)) {
				event.setCancelled(true);
			}
			
		}
		if(TNTRunMain.wand.contains(player)) {
			ItemStack inhand = player.getItemInHand();
			if(inhand.getType() == Material.getMaterial(tntwandtoolid)) {
				event.setCancelled(true);
			}
			
		}
		if(TeamDeathMatchMain.wand.contains(player)) {
			ItemStack inhand = player.getItemInHand();
			if(inhand.getType() == Material.getMaterial(tdmwandtoolid)) {
				event.setCancelled(true);
			}
		}
		if(SpleefMain.SpleefMain.pdata.plingame.containsKey(player.getName())) {
			SpleefBlockBreak.BlockBreakEvent(event);
		}
		if(ParkourMain.ParkourMain.pdata.plingame.containsKey(player.getName())) {
			event.setCancelled(true);
		}
		if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.plingame.containsKey(player.getName())) {
			event.setCancelled(true);
		}
		if(TPlayerDataStore.lobbied.contains(player.getName())) {
			event.setCancelled(true);
		}
		if(TNTRunMain.TNTRunMain.pdata.plingame.containsKey(player.getName())) {
			event.setCancelled(true);
		}
		
	}

}
