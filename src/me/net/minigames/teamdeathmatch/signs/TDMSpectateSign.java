package me.net.minigames.teamdeathmatch.signs;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class TDMSpectateSign {
	
	public static void Spectate(Player player, String arenaname) {
		player.performCommand("tdm spectate " + arenaname);
	}

	public static void UpdateSign(SignChangeEvent sign, String arenaname) {
		
		sign.setLine(0, "§6[DMinigames]");
		sign.setLine(1, "§0[§bTDM§0]");
		sign.setLine(2, "§aSpectate");
		sign.setLine(3, "§4" + arenaname);
		
	}

}
