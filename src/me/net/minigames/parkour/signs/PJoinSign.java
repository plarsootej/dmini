package me.net.minigames.parkour.signs;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class PJoinSign {

	public static void Join(Player player, String arenaname) {
		player.performCommand("parkour join " + arenaname);
	}
	
	public static void UpdateSign(SignChangeEvent sign, String arenaname) {
		
		sign.setLine(0, "§6[DMinigames]");
		sign.setLine(1, "§0[§bParkour§0]");
		sign.setLine(2, "§aJoin");
		sign.setLine(3, "§4" + arenaname);
	}

}
