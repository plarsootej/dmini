package me.net.minigames.tntrun.signs;

import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class TNTRunSigns {
	
	public static void JoinSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(3);
		if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
			
			player.sendMessage("§aJoin Sign succesfully created for Arena: §f" + arenaname);
			TNTJoinSign.UpdateSign(event, arenaname);
		}else {
			player.sendMessage(arenaname + "§c Is not a valid Arena!");
			event.setCancelled(true);
		}
		
	}

	public static void SpectateSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(3);
		if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
			
			player.sendMessage("§aSpectate Sign succesfully created for Arena: §f" + arenaname);
			TNTSpectateSign.UpdateSign(event, arenaname);
		}else {
			player.sendMessage(arenaname + "§c Is not a valid Arena!");
			event.setCancelled(true);
		}		
	}

}
