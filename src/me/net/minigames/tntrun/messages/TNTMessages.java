package me.net.minigames.tntrun.messages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTMessages {
	
	public static void sendMessage(Player player, String TNTRunMessages) {
		player.sendMessage(TNTRunMessages);
	}
	public static void sendMessage(CommandSender sender, String TNTRunMessages) {
		sender.sendMessage(TNTRunMessages);
	}
	public static void sendMessage(Player player, String plname, String TNTRunMessages) {
		TNTRunMessages = TNTRunMessages.replace("{PLAYER}", plname);
		player.sendMessage(TNTRunMessages);
	}

}
