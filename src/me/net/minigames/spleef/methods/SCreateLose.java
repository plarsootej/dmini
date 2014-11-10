package me.net.minigames.spleef.methods;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public class SCreateLose {
	
public static Block block;

	
	public static void CreateLose(String arenaname) {
		
		SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(arenaname);
		Vector p1 = arena.getLoseP1();
		Vector p2 = arena.getLoseP2();
		String world = arena.getLoseWorld().getName();
		final Location loc1 = new Location(Bukkit.getServer().getWorld(world), p1.getX(), p1.getY(), p1.getZ());
		final Location loc2 = new Location(Bukkit.getServer().getWorld(world), p2.getX(), p2.getY(), p2.getZ());
		
		Material water = Material.WATER;
		 int tntminX = Math.min(loc1.getBlockX(), loc2.getBlockX());
	     int tntminY = Math.min(loc1.getBlockY(), loc2.getBlockY());
	     int tntminZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
	     int tntmaxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
	     int tntmaxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
	     int tntmaxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
	     for(int x = tntminX; x <= tntmaxX; x++) {
	          for(int y = tntminY; y <= tntmaxY; y++) {
	              for(int z = tntminZ; z <=tntmaxZ; z++) {
	                  block = Bukkit.getWorld(world).getBlockAt(x, y, z);
	                    
	                  block.setType(water);
	                  
	               
	              }
	          }
	      }
		
		
	}


}
