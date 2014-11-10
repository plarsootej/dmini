package me.net.minigames.events;


import me.net.minigames.main.MainClass;
import me.net.minigames.main.handlers.SignHandler;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.events.PaShootEvent;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.methods.SWandTool;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.methods.TNTWandTool;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener{
	
	MainClass plugin;
	public InteractEvent (MainClass instance) {
		plugin = instance;
	}
	


	
	@EventHandler
	public void onPlayerIntract (PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		
		if(TNTRunMain.wand.contains(player)) {
			TNTWandTool.WandTool(event);
			
		}
		
		if(PaintballMain.PaintBallMain.pdata.plingame.containsKey(player.getName())) {
			PaShootEvent.Shoot(event);
		}
		
			
		if(SpleefMain.wand.contains(player)) {
			SWandTool.WandTool(event);
			
		}
		Block block = event.getClickedBlock();
		if(block != null) {
			if(block.getType() == Material.SIGN || block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {
				if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					SignHandler.HandlerSigns(player, block);
				}
			}
		}
		

	}

}
