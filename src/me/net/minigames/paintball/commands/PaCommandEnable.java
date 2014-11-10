package me.net.minigames.paintball.commands;

import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.command.CommandSender;

public class PaCommandEnable {

	public static void enable(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("enable")) {
			if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(args[1])) {
				PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(args[1]);
				arena.enableArena();
				PaMessages.sendMessage(sender, PaintballMessages.ArenaEnabled);
			}else {
				PaMessages.sendMessage(sender, PaintballMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb enable <arenaname>");
		}
		
	}

}
