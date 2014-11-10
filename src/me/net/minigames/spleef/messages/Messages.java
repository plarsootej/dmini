package me.net.minigames.spleef.messages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messages {
	
	public static void sendMessage(Player player, String SpleefMessages) {
		player.sendMessage(SpleefMessages);
	}
	public static void sendMessage(CommandSender sender, String SpleefMessages) {
		sender.sendMessage(SpleefMessages);
	}
	public static void sendMessage(Player player, String plname, String SpleefMessages) {
		SpleefMessages = SpleefMessages.replace("{PLAYER}", plname);
		player.sendMessage(SpleefMessages);
	}

}
