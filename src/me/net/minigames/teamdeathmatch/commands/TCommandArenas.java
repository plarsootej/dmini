package me.net.minigames.teamdeathmatch.commands;

import java.util.ArrayList;
import java.util.List;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.command.CommandSender;

public class TCommandArenas {
	
	private static List<String> arenasnames = new ArrayList<String>();

	public static void Arenas(CommandSender sender, String[] args) {
		if(args.length == 1 && args[0].equalsIgnoreCase("list")) {
			for(TArenas arenas : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenas()) {
				if(arenas.isArenaEnabled()) {
					arenasnames.add(arenas.getArenaName());
				}
				
			}
			sender.sendMessage("§aAviable arenas : §f" + arenasnames);
		}
	}

}
