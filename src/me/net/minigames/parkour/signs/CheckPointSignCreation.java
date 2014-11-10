package me.net.minigames.parkour.signs;

import me.net.minigames.parkour.handlers.PCheckPointHandler;

import org.bukkit.event.block.SignChangeEvent;

public class CheckPointSignCreation {
	

	public static void UpdateSign(SignChangeEvent sign, String arenaname, String checkpoint) {
		
		sign.setLine(0, "§0[§bParkour§0]");
		sign.setLine(1, "§aCheckPoint");
		sign.setLine(2, "§4" + arenaname);
		sign.setLine(3, checkpoint);
		
		PCheckPointHandler.CreateCheckPoint(sign.getBlock().getLocation(), checkpoint, arenaname);
		
	}

}
