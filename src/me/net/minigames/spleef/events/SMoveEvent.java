package me.net.minigames.spleef.events;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.handlers.ArenaHandler;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.methods.Game;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class SMoveEvent {
	
	public static void SpleefMoveEvent(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		
		SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(player.getName());
		Vector p1 = arena.getLoseP1();
		Vector p2 = arena.getLoseP2();
		String world = arena.getLoseWorld().getName();

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
	
		if((player.getLocation().getBlockX() > xmin && player.getLocation().getBlockX() < xmax) || player.getLocation().getBlockX() == xmin || player.getLocation().getBlockX() == xmax) {
			if((player.getLocation().getBlockY() > ymin && player.getLocation().getBlockY() < ymax) || player.getLocation().getBlockY() == ymin || player.getLocation().getBlockY() == ymax) {
                if((player.getLocation().getBlockZ() > zmin && player.getLocation().getBlockZ() < zmax) || player.getLocation().getBlockZ() == zmin || player.getLocation().getBlockZ() == zmax) {
                	if(player.getWorld().getName().equalsIgnoreCase(world)) {
                		if(SpleefMain.SpleefMain.pdata.getArenaPlayers(arena).size() >= 2) {
                			Game.Loser(player);
                			ArenaHandler.checkSize(arena);
                		}
                		if(SpleefMain.SpleefMain.pdata.getArenaPlayers(arena).size() <= 1) {
                			Game.Winner(player);
                		}
                		
                	}
                }
            }
		}
                	

	}
}
