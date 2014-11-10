package me.net.minigames.paintball.commands;

import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.command.CommandSender;

public class PaCommandDisable {

	public static void disable(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("disable")) {
			if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(args[1])) {
				PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(args[1]);
				arena.disableArena();
				PaMessages.sendMessage(sender, PaintballMessages.ArenaDisabled);
			}else {
				PaMessages.sendMessage(sender, PaintballMessages.ArenaDisabled);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb disable <arenaname>");
		}
		
		
	}

}
