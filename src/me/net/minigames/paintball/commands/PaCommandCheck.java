package me.net.minigames.paintball.commands;

import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaintballMessages;
import me.net.minigames.teamdeathmatch.messages.TMessages;

import org.bukkit.command.CommandSender;

public class PaCommandCheck {

	public static void check(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("check")) {
			if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(args[1])) {
				PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(args[1]);
				String info = arena.isArenaConfigured();
				if(info.endsWith("yes")) {
					sender.sendMessage("§f" + args[1] + "§a Is ready to play!");
				}else {
					sender.sendMessage("§c" + arena.isArenaConfigured() + " For arena: §f" + args[1]);
				}
			}else {
				TMessages.sendMessage(sender, PaintballMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb check <arenaname>");
		}
		
	}

}
