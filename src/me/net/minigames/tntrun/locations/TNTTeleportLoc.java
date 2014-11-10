package me.net.minigames.tntrun.locations;

import me.net.minigames.main.handlers.ConfigHandler;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TNTTeleportLoc {
	
	public static void TeleportLobbyLoc(Player player, String arenaname) {
		
		final String world = ConfigHandler.TNTRunArenas.getString("Arenas" + "." + arenaname + "." + "Locations" + "." + "Lobby" + "." + "World");
		final int x = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + "." + "Locations" + "." + "Lobby" + "." + "X");
    	final int y = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + "." + "Locations" + "." + "Lobby" + "." + "Y");
    	final int z = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + "." + "Locations" + "." + "Lobby" + "." + "Z");
    	
    	Location loc = new Location(Bukkit.getServer().getWorld(world), x, y, z);
    	player.teleport(loc);
		
	}
	
	public static void TeleportSpawnLoc(Player player, String arenaname) {
		
		final String world = ConfigHandler.TNTRunArenas.getString("Arenas" + "." + arenaname + "." + "Locations" + "." + "Spawn" + "." + "World");
		final int x = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + "." + "Locations" + "." + "Spawn" + "." + "X");
    	final int y = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + "." + "Locations" + "." + "Spawn" + "." + "Y");
    	final int z = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + "." + "Locations" + "." + "Spawn" + "." + "Z");
    	
    	Location loc = new Location(Bukkit.getServer().getWorld(world), x, y, z);
    	player.teleport(loc);
		
	}
	
	public static void TeleportSpectateLoc(Player player, String arenaname) {
		
		final String world = ConfigHandler.TNTRunArenas.getString("Arenas" + "." + arenaname + "." + "Locations" + "." + "Spectate" + "." + "World");
		final int x = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + "." + "Locations" + "." + "Spectate" + "." + "X");
    	final int y = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + "." + "Locations" + "." + "Spectate" + "." + "Y");
    	final int z = ConfigHandler.TNTRunArenas.getInt("Arenas" + "." + arenaname + "." + "Locations" + "." + "Spectate" + "." + "Z");
    	
    	Location loc = new Location(Bukkit.getServer().getWorld(world), x, y, z);
    	player.teleport(loc);
		
	}

}
