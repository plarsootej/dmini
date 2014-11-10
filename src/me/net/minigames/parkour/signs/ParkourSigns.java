package me.net.minigames.parkour.signs;

import me.net.minigames.Permissions.ParkourPermissions;
import me.net.minigames.Permissions.Permissions;
import me.net.minigames.parkour.main.ParkourMain;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class ParkourSigns {
	
	public static void CheckPointSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(2);
		final String checkpoint = event.getLine(3);
		if(event.getPlayer().hasPermission(new ParkourPermissions().parkadmin) || player.hasPermission(new Permissions().madmin)) {
			if(ParkourMain.ParkourMain.pdata.arenanames.containsKey(arenaname)) {
				CheckPointSignCreation.UpdateSign(event, arenaname, checkpoint);
				player.sendMessage("§aCheckpoint §b" +checkpoint + " §aSuccesfully created for arena §f" + arenaname);
				
			}else {
				player.sendMessage(arenaname + "§c Is not a valid Parkour!");
				event.setCancelled(true);
			}
		}
		
		
	}
	
	public static void JoinSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		final String arenaname = event.getLine(3);
		if(ParkourMain.ParkourMain.pdata.arenanames.containsKey(arenaname)) {
			
			player.sendMessage("§aJoin Sign succesfully created for Parkour: §f" + arenaname);
			PJoinSign.UpdateSign(event, arenaname);
		}else {
			player.sendMessage(arenaname + "§c Is not a valid Parkour!");
			event.setCancelled(true);
		}
		
	}

}
