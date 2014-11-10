package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.command.CommandSender;

public class TCommandCheck {

	public static void check(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("check")) {
			if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(args[1])) {
				TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(args[1]);
				String info = arena.isArenaConfigured();
				if(info.endsWith("yes")) {
					sender.sendMessage("§f" + args[1] + "§a Is ready to play!");
				}else {
					sender.sendMessage("§c" + arena.isArenaConfigured() + " For arena: §f" + args[1]);
				}
			}else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tdm check <arenaname>");
		}
		
	}

}
