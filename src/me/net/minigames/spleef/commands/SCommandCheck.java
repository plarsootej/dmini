package me.net.minigames.spleef.commands;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.command.CommandSender;

public class SCommandCheck {
	
	public static void CheckCommand(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("check")) {
			if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(args[1])) {
				SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(args[1]);
				String info = arena.isArenaConfigured();
				if(info.endsWith("yes")) {
					sender.sendMessage("§f" + args[1] + "§a Is ready to play!");
				}else {
					sender.sendMessage("§c" + arena.isArenaConfigured() + " For arena: §f" + args[1]);
				}
			}else {
				Messages.sendMessage(sender, SpleefMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage:§f /spleef check <arenaname>");
		}
		
		
		
	}

}
