package me.net.minigames.teamdeathmatch.messages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TMessages {
	
	public static void sendMessage(Player player, String TeamDeathMatchMessages) {
		player.sendMessage(TeamDeathMatchMessages);
	}
	public static void sendMessage(CommandSender sender, String TeamDeathMatchMessages) {
		sender.sendMessage(TeamDeathMatchMessages);
	}
	public static void sendMessage(Player player, String plname, String TeamDeathMatchMessages) {
		TeamDeathMatchMessages = TeamDeathMatchMessages.replace("{PLAYER}", plname);
		player.sendMessage(TeamDeathMatchMessages);
	}

}
