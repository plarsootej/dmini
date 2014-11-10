package me.net.minigames.paintball.commands;

import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.command.CommandSender;

public class PaCommandSetCountDown {

	public static void setCountDown(CommandSender sender, String[] args) {
		if(args.length == 3 && args[0].equalsIgnoreCase("setcountdown")) {
			String arenaname = args[1];
			
			if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(arenaname)) {
				PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(arenaname);
				int seconds = Integer.parseInt(args[2]);
				arena.setCountDown(seconds);
				arena.saveToConfig();
				sender.sendMessage("§aCountdown succesfully set to §6" + seconds + "§a for arena §f" + arenaname);
			}else {
				PaMessages.sendMessage(sender, PaintballMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb setcountdown <arenaname> <seconds>");
		}
	}

}
