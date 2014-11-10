package me.net.minigames.parkour.messages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messages {
	
	public static void sendMessage(Player player, String ParkourMessages) {
		player.sendMessage(ParkourMessages);
	}
	public static void sendMessage(CommandSender sender, String ParkourMessages) {
		sender.sendMessage(ParkourMessages);
	}
	public static void sendMessage(Player player, String plname, String ParkourMessages) {
		ParkourMessages = ParkourMessages.replace("{PLAYER}", plname);
		player.sendMessage(ParkourMessages);
	}


}
