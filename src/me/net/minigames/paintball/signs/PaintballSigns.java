package me.net.minigames.paintball.signs;

import me.net.minigames.paintball.PaintballMain;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class PaintballSigns {
	
	public static void JoinSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(3);
		if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(arenaname)) {
			
			player.sendMessage("§aJoin Sign succesfully created for Arena: §f" + arenaname);
			PaJoinSign.UpdateSign(event, arenaname);
		}else {
			player.sendMessage(arenaname + "§c Is not a valid Arena!");
			event.setCancelled(true);
		}
		
	}

	public static void SpectateSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(3);
		if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(arenaname)) {
			
			player.sendMessage("§aSpectate Sign succesfully created for Arena: §f" + arenaname);
			PaSpectateSign.UpdateSign(event, arenaname);
		}else {
			player.sendMessage(arenaname + "§c Is not a valid Arena!");
			event.setCancelled(true);
		}		
	}



}
