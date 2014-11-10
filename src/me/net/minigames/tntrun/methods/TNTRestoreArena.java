package me.net.minigames.tntrun.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.net.minigames.main.handlers.ConfigHandler;

public class TNTRestoreArena {
	
	public static void restoreArena(String arenaname) {
		List<String> floors = new ArrayList<String>();
		Set<String> names = ConfigHandler.TNTRunArenas.getConfigurationSection("Arenas." + arenaname + ".Floors").getKeys(false);
		
		for(String name : names) {
			floors.add(name);
		}
		for(String floor : floors) {
			TNTCreateFloor.CreateFloor(arenaname, floor);
		}
		 
	}

}
