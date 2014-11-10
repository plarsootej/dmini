package me.net.minigames.tntrun.commands;

import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.command.CommandSender;

public class TNTCommandCheck {

	public static void check(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("check")) {
			if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(args[1])) {
				TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(args[1]);
				String info = arena.isArenaConfigured();
				if(info.endsWith("yes")) {
					sender.sendMessage("§f" + args[1] + "§a Is ready to play!");
				}else {
					sender.sendMessage("§c" + arena.isArenaConfigured() + " For arena: §f" + args[1]);
				}
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage:§f /tnt check <arenaname>");
		}
		
	}

}
