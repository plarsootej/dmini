package me.net.minigames.spleef.commands;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.command.CommandSender;


public class SCommandDisable {
	
	public static void DisableArena(CommandSender sender, String[] args) {
		if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(args[1])) {
			SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(args[1]);
			arena.disableArena();
			Messages.sendMessage(sender, SpleefMessages.ArenaDisabled);
		}else {
			Messages.sendMessage(sender, SpleefMessages.ArenaDisabled);
		}
	}

}
