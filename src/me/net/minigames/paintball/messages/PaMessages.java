package me.net.minigames.paintball.messages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaMessages {
	
	public static void sendMessage(Player player, String paintballMessages) {
		player.sendMessage(paintballMessages);
	}
	public static void sendMessage(CommandSender sender, String paintballMessages) {
		sender.sendMessage(paintballMessages);
	}
	public static void sendMessage(Player player, String plname, String paintballMessages) {
		paintballMessages = paintballMessages.replace("{PLAYER}", plname);
		player.sendMessage(paintballMessages);
	}

}
