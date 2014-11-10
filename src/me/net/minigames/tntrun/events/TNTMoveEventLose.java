package me.net.minigames.tntrun.events;


import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.handlers.TNTArenaHandler;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public class TNTMoveEventLose {
	

	
	public static void MoveEventLose(PlayerMoveEvent event) {
		
		Player player = event.getPlayer();
		TNTArena arena = TNTRunMain.TNTRunMain.pdata.getPlayerArena(player.getName());
		if(arena.getLoseP1() != null && arena.getLoseP2() != null) {
			final String world = arena.getArenaWorld().getName();
			final int x1 = arena.getLoseP1().getBlockX();
			final int z1 = arena.getLoseP1().getBlockZ();
			final int y1 = arena.getLoseP1().getBlockY();
			
			final int x2 = arena.getLoseP2().getBlockX();
			final int z2 = arena.getLoseP2().getBlockZ();
			final int y2 = arena.getLoseP2().getBlockY();
			
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
			
			
			 if((player.getLocation().getBlockX() > xmin && player.getLocation().getBlockX() < xmax) || player.getLocation().getBlockX() == xmin || player.getLocation().getBlockX() == xmax) {
	                if((player.getLocation().getBlockY() > ymin && player.getLocation().getBlockY() < ymax) || player.getLocation().getBlockY() == ymin || player.getLocation().getBlockY() == ymax) {
	                    if((player.getLocation().getBlockZ() > zmin && player.getLocation().getBlockZ() < zmax) || player.getLocation().getBlockZ() == zmin || player.getLocation().getBlockZ() == zmax) {	                    	
	                    	if(player.getWorld().getName().equalsIgnoreCase(world)) {
	                    		if(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena).size() >= 2) {
	                    			arena.arenaph.leaveOnEnd(player, false);
	                    			TNTArenaHandler.checkSize(arena);
	                    		}
		                    	
	                    	}
	                    }
	                }
	            }
		}
	}

}
