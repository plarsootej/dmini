package me.net.minigames.teamdeathmatch.signs;

import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class TeamDeathMatchSigns {
	
	public static void JoinSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(3);
		if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(arenaname)) {
			
			player.sendMessage("§aJoin Sign succesfully created for Arena: §f" + arenaname);
			TDMJoinSign.UpdateSign(event, arenaname);
		}else {
			player.sendMessage(arenaname + "§c Is not a valid Arena!");
			event.setCancelled(true);
		}
		
	}

	public static void SpectateSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(3);
		if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(arenaname)) {
			
			player.sendMessage("§aSpectate Sign succesfully created for Arena: §f" + arenaname);
			TDMSpectateSign.UpdateSign(event, arenaname);
		}else {
			player.sendMessage(arenaname + "§c Is not a valid Arena!");
			event.setCancelled(true);
		}		
	}

	public static void KitSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String kitname = event.getLine(2);
		if(TeamDeathMatchMain.TeamDeathMatchMain.kdata.kitnames.containsKey(kitname)) {
			
			player.sendMessage("§aKit Sign succesfully created for Kit: §f" + kitname);
			TDMKitSign.UpdateSign(event, kitname);
		}else {
			player.sendMessage(kitname + "§c Is not a valid kit!");
			event.setCancelled(true);
		}	
		
	}

}
