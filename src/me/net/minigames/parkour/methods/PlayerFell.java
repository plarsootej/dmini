package me.net.minigames.parkour.methods;

import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;

import org.bukkit.entity.Player;

public class PlayerFell {

	public static void CheckpointPlayer(Player player) {
		int fells = ParkourMain.ParkourMain.pdata.getPlayerFells(player.getName());
		int newfells = fells+1;
		ParkourMain.ParkourMain.pdata.setPlayerFells(player.getName(), newfells);
		
		//checkpoint
		
		String checkpoint = ParkourMain.ParkourMain.pdata.getPlayerCheckPoint(player.getName());
		PArena arena = ParkourMain.ParkourMain.pdata.getPlayerArena(player.getName());
		if(checkpoint.equalsIgnoreCase("0")) {
			player.teleport(arena.getSpawnPoint());
			player.sendMessage("§aSuccesfully teleport to last saved checkpoint");
			player.sendMessage("§cYou fell §aTotal Fells: §6" + newfells);
		}else {
			
			player.teleport(arena.getCheckPointByName(checkpoint).getP1().toLocation(arena.getArenaWorld()));
			player.sendMessage("§aSuccesfully teleport to last saved checkpoint");
			player.sendMessage("§cYou fell §aTotal Fells: §6" + newfells);
		}

		
	}

}
