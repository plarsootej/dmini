package me.net.minigames.tntrun.methods;


import me.net.minigames.tntrun.locations.TNTTeleportLoc;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class TNTStartGame {

	@SuppressWarnings("deprecation")
	public static void StartTNTRun(String arenaname) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(TNTRunMain.lobby.containsKey(p.getName())) {
				if(TNTRunMain.lobby.get(p.getName()).equals(arenaname)) {
					//repair arena before start
					TNTRestoreArena.restoreArena(arenaname);
					
					
					//teleporting the players to the spawn location
					TNTTeleportLoc.TeleportSpawnLoc(p, arenaname);
					
					//choosing arrylist
					TNTChooseArrayList.ChooseList(p, arenaname);
					
					//clearing inventory
					p.getInventory().clear();
					p.updateInventory();
					
					//gamemode
					p.setGameMode(GameMode.SURVIVAL);
					
					TNTRunMain.lobby.remove(p.getName());
					
				}
			}
		}
		
	}

}
