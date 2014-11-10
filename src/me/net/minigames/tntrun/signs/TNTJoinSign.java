package me.net.minigames.tntrun.signs;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class TNTJoinSign {
	
	public static void Join(Player player, String arenaname) {
		player.performCommand("tnt join " + arenaname);
	}

	public static void UpdateSign(SignChangeEvent sign, String arenaname) {
		
		sign.setLine(0, "§6[DMinigames]");
		sign.setLine(1, "§0[§bTNT Run§0]");
		sign.setLine(2, "§aJoin");
		sign.setLine(3, "§4" + arenaname);
		
	}

}
