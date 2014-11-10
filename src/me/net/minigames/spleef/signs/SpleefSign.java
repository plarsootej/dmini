package me.net.minigames.spleef.signs;

import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class SpleefSign {

	public static void JoinSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(3);
		if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(arenaname)) {
			
			player.sendMessage("§aJoin Sign succesfully created for arena: §f" + arenaname);
			SJoinSign.UpdateSign(event, arenaname);
		}else {
			player.sendMessage(arenaname + "§c Is not a valid Spleef arena!");
			event.setCancelled(true);
		}
		
	}

	public static void SpectateSign(org.bukkit.event.block.SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(3);
		if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(arenaname)) {
			
			player.sendMessage("§aSpectate Sign succesfully created for arena: §f" + arenaname);
			SSpectateSign.UpdateSign(event, arenaname);
		}else {
			player.sendMessage(arenaname + "§c Is not a valid Spleef arena!");
			event.setCancelled(true);
		}		
	}

	
	

}
