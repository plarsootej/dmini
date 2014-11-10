package me.net.minigames.spleef.commands;

import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;
import me.net.minigames.spleef.methods.SCreateFloor;

import org.bukkit.command.CommandSender;

public class SCommandRestore {
	
	public static void RestoreCommand(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("restore")) {
			if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(args[1])) {
				String arenaname = args[1];
				SCreateFloor.CreateFloor(arenaname);
			}else {
				Messages.sendMessage(sender, SpleefMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/spleef restore <arenaname>");
		}
	}

}
