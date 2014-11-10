package me.net.minigames.tntrun.methods;

import me.net.minigames.tntrun.handlers.TNTArena;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;


public class TNTCreateLose {
	
	public static Block block;
	
	public static void CreateLoseFloor (TNTArena arena, String arenaname) {
		
		
		final World world = arena.getArenaWorld();
		Vector v1 = arena.getLoseP1();
		Vector v2 = arena.getLoseP2();
		Location loc1 = v1.toLocation(world);
		Location loc2 = v2.toLocation(world);
		
		//create w
				Material water = Material.AIR;
				 int tntminX = Math.min(loc1.getBlockX(), loc2.getBlockX());
			     int tntminY = Math.min(loc1.getBlockY(), loc2.getBlockY());
			     int tntminZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
			     int tntmaxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
			     int tntmaxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
			     int tntmaxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
			     for(int x = tntminX; x <= tntmaxX; x++) {
			          for(int y = tntminY; y <= tntmaxY; y++) {
			              for(int z = tntminZ; z <=tntmaxZ; z++) {
			                  block = world.getBlockAt(x, y, z);
			                    
			                  block.setType(water);
			                  
			               
			              }
			          }
			      }
			     
	}

}
