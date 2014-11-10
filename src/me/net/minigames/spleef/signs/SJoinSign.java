package me.net.minigames.spleef.signs;


import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class SJoinSign {

	public static void UpdateSign(SignChangeEvent sign, String arenaname) {
		
		sign.setLine(0, "§6[DMinigames]");
		sign.setLine(1, "§0[§bSpleef§0]");
		sign.setLine(2, "§aJoin");
		sign.setLine(3, "§4" + arenaname);
	}
	
	//joining the player to the game
	public static void Join(Player player, String arenaname) {
		player.performCommand("spleef join " + arenaname);
	}

}
