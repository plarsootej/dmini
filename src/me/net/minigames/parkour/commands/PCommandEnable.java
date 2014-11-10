package me.net.minigames.parkour.commands;

import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.command.CommandSender;

public class PCommandEnable {

	public static void enable(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("enable")) {
			if(ParkourMain.ParkourMain.pdata.arenanames.containsKey(args[1])) {
				PArena arena = ParkourMain.ParkourMain.pdata.getArenaByName(args[1]);
				arena.enableArena();
				Messages.sendMessage(sender, ParkourMessages.ArenaEnabled);
			}else {
				Messages.sendMessage(sender, ParkourMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/parkour enable <arenaname>");
		}
	}

}
