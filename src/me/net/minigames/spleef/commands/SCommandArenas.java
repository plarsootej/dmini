package me.net.minigames.spleef.commands;

import java.util.ArrayList;
import java.util.List;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.command.CommandSender;

public class SCommandArenas {

	public static void arenas(CommandSender sender, String[] args) {
		if(args.length == 1 && args[0].equalsIgnoreCase("list")) {
			if(SpleefMain.SpleefMain.pdata.arenanames.size() >0) {
				List<String> arenas = new ArrayList<String>();
				for(SArena arena : SpleefMain.SpleefMain.pdata.getArenas()) {
					if(arena.isArenaEnabled()) {
						arenas.add(arena.getArenaName());
					}
					
				}
				sender.sendMessage("§aAviable arenas: §f" + arenas);
				
						
			}else {
				sender.sendMessage("§aNo aviable arenas");
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/spleef list");
		}
		
	}

}
