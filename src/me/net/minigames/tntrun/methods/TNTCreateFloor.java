package me.net.minigames.tntrun.methods;

import me.net.minigames.main.handlers.ConfigHandler;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class TNTCreateFloor {
	
	public static Block block;
	
	public static void CreateFloor(String arenaname, String floor) {
		
		final String world = ConfigHandler.TNTRunArenas.getString("Arenas" + "." + arenaname + ".Floors." + floor + "." + "World");
		final int x1 = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + ".Floors." + floor + "." + "X1");
		final int z1 = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + ".Floors." + floor + "." + "Z1");
		final int sandy1 = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + ".Floors." + floor + "." + "Y1");
		final int tnty1 = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + ".Floors." + floor + "." + "Y1")-1;
		
		final int x2 = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + ".Floors." + floor + "." + "X2");
		final int z2 = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + ".Floors." + floor + "." + "Z2");
		final int sandy2 = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + ".Floors." + floor + "." + "Y2");
		final int tnty2 = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + ".Floors." + floor + "." + "Y2")-1;

		
		final Location sandloc1 = new Location(Bukkit.getServer().getWorld(world), x1, sandy1, z1);
		final Location sandloc2 = new Location(Bukkit.getServer().getWorld(world), x2, sandy2, z2);
		
		final Location tntloc1 = new Location(Bukkit.getServer().getWorld(world), x1, tnty1, z1);
		final Location tntloc2 = new Location(Bukkit.getServer().getWorld(world), x2, tnty2, z2);
		
		
		//create tnt layer
		Material tnt = Material.TNT;
		 int tntminX = Math.min(tntloc1.getBlockX(), tntloc2.getBlockX());
	     int tntminY = Math.min(tntloc1.getBlockY(), tntloc2.getBlockY());
	     int tntminZ = Math.min(tntloc1.getBlockZ(), tntloc2.getBlockZ());
	     int tntmaxX = Math.max(tntloc1.getBlockX(), tntloc2.getBlockX());
	     int tntmaxY = Math.max(tntloc1.getBlockY(), tntloc2.getBlockY());
	     int tntmaxZ = Math.max(tntloc1.getBlockZ(), tntloc2.getBlockZ());
	     for(int x = tntminX; x <= tntmaxX; x++) {
	          for(int y = tntminY; y <= tntmaxY; y++) {
	              for(int z = tntminZ; z <=tntmaxZ; z++) {
	                  block = Bukkit.getWorld(world).getBlockAt(x, y, z);
	                    
	                  block.setType(tnt);
	                  
	               
	              }
	          }
	      }
	     
	     //create sand layer
			Material sand = Material.SAND;
			 int sandminX = Math.min(sandloc1.getBlockX(), sandloc2.getBlockX());
		     int sandminY = Math.min(sandloc1.getBlockY(), sandloc2.getBlockY());
		     int sandminZ = Math.min(sandloc1.getBlockZ(), sandloc2.getBlockZ());
		     int sandmaxX = Math.max(sandloc1.getBlockX(), sandloc2.getBlockX());
		     int sandmaxY = Math.max(sandloc1.getBlockY(), sandloc2.getBlockY());
		     int sandmaxZ = Math.max(sandloc1.getBlockZ(), sandloc2.getBlockZ());
		     for(int x = sandminX; x <= sandmaxX; x++) {
		          for(int y = sandminY; y <= sandmaxY; y++) {
		              for(int z = sandminZ; z <=sandmaxZ; z++) {
		                  block = Bukkit.getWorld(world).getBlockAt(x, y, z);
		                    
		                  block.setType(sand);
		                    
		              }
		          }
		      }
		      
		
	}

}
