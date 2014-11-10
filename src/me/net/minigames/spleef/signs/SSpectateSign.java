package me.net.minigames.spleef.signs;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class SSpectateSign {
	
	public static void UpdateSign(SignChangeEvent sign, String arenaname) {
		
		sign.setLine(0, "§6[DMinigames]");
		sign.setLine(1, "§0[§bSpleef§0]");
		sign.setLine(2, "§aSpectate");
		sign.setLine(3, "§4" + arenaname);
	}

	public static void Spectate(Player player, String arenaname) {
		player.performCommand("spleef spectate " + arenaname);
		
	}

}
