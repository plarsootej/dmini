package me.net.minigames.tntrun.events;


import me.net.minigames.main.MainClass;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerMoveEvent;

public class TNTMoveEventFloor {
	
	public static int taskID;

	public static void MoveEventFloor(PlayerMoveEvent event) {
		
		Location loc = event.getPlayer().getLocation();
		String world = event.getPlayer().getWorld().getName();
		Block block = loc.getBlock();
		int x = loc.getBlockX();
		int z = loc.getBlockZ();
		int y = block.getY()-1;
		int sandy = block.getY()-1;
		int tnty = block.getY()-2;
		
		Location blockloc = new Location(Bukkit.getServer().getWorld(world), x, y, z);
		final Location sandloc = new Location(Bukkit.getServer().getWorld(world), x, sandy, z);
		final Location tntloc = new Location(Bukkit.getServer().getWorld(world), x, tnty, z);
		
		final Block newblock = blockloc.getBlock();
		
		

		long delay = 4;
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.main, new Runnable()
        {
                public void run()
                {
                	
					if(newblock.getType() == Material.SAND) {
						sandloc.getBlock().setType(Material.AIR);
						tntloc.getBlock().setType(Material.AIR);
					}
                }
        }, delay);
		
	}
	
	
	public static void StopScheduler() {
		Bukkit.getScheduler().cancelTask(taskID);
	}

}
