package me.net.minigames.tntrun.signs;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class TNTSpectateSign {
	
	public static void Spectate(Player player, String arenaname) {
		player.performCommand("tnt spectate " + arenaname);
	}

	public static void UpdateSign(SignChangeEvent sign, String arenaname) {
		
		sign.setLine(0, "§6[DMinigames]");
		sign.setLine(1, "§0[§bTNT Run§0]");
		sign.setLine(2, "§aSpectate");
		sign.setLine(3, "§4" + arenaname);
		
	}

}
