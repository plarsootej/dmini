package me.net.minigames.parkour.commands;

import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PCommandLeave {
	
	public static void leave(CommandSender sender) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			PArena arena = ParkourMain.ParkourMain.pdata.getPlayerArena(player.getName());
			arena.arenaph.leaveParkour(player);
		}else {
			Messages.sendMessage(sender, ParkourMessages.Console);
		}
	}

}
