package me.net.minigames.paintball.signs;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class PaSpectateSign {
	
	public static void Spectate(Player player, String arenaname) {
		player.performCommand("p spectate " + arenaname);
	}

	public static void UpdateSign(SignChangeEvent sign, String arenaname) {
		
		sign.setLine(0, "§6[DMinigames]");
		sign.setLine(1, "§0[§bPaint§0]");
		sign.setLine(2, "§aSpectate");
		sign.setLine(3, "§4" + arenaname);
		
	}

}
