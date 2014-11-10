package me.net.minigames.spleef.events;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.util.Vector;

public class SpleefBlockDamageEvent {

	public static void DamageEvent(BlockDamageEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		
		SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(player.getName());
		Vector p1 = arena.getFloorP1();
		Vector p2 = arena.getFloorP2();
		String world = arena.getFloorWorld().getName();

		int x1 = p1.getBlockX();
		int y1 = p1.getBlockY();
		int z1 = p1.getBlockZ();
		
		int x2 = p2.getBlockX();
		int y2 = p2.getBlockY();
		int z2 = p2.getBlockZ();
		
		final int xmax;
		final int xmin;
		
		final int zmax;
		final int zmin;
		
		final int ymax;
		final int ymin;
		 
		/** X **/
		if(x1 >= x2) {
			xmax = x1;
			xmin = x2;
		}else {
			xmax = x2;
			xmin = x1;
		}
		
		/** Z **/
		if(z1 >= z2) {
			zmax = z1;
			zmin = z2;
		}else {
			zmax = z2;
			zmin = z1;
		}
		
		/** Y **/
		if(y1 >= y2) {
			ymax = y1;
			ymin = y2;
		}else {
			ymax = y2;
			ymin = y1;
		}
	
		if((block.getLocation().getBlockX() > xmin && block.getLocation().getBlockX() < xmax) || block.getLocation().getBlockX() == xmin || block.getLocation().getBlockX() == xmax) {
			if((block.getLocation().getBlockY() > ymin && block.getLocation().getBlockY() < ymax) || block.getLocation().getBlockY() == ymin || block.getLocation().getBlockY() == ymax) {
                if((block.getLocation().getBlockZ() > zmin && block.getLocation().getBlockZ() < zmax) || block.getLocation().getBlockZ() == zmin || block.getLocation().getBlockZ() == zmax) {
                	if(block.getWorld().getName().equalsIgnoreCase(world)) {
                		block.setType(Material.AIR);
                	}
                }
			}
		}
		
	}

}
