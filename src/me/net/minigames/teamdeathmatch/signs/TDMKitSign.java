package me.net.minigames.teamdeathmatch.signs;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class TDMKitSign {
	
	public static void kit(Player player, String kitname) {
		player.performCommand("tdm kit " + kitname);
	}

	public static void UpdateSign(SignChangeEvent sign, String kitname) {
		sign.setLine(0, "§0[§bTDM§0]");
		sign.setLine(1, "§aKit");
		sign.setLine(2, "§4" + kitname);
		
	}

}
