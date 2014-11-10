package me.net.minigames.tntrun.commands;

import java.util.ArrayList;
import java.util.List;

import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.command.CommandSender;

public class TNTCommandArenas {

	public static void CommandArenas(CommandSender sender, String[] args) {
		if(args.length == 1 && args[0].equalsIgnoreCase("list")) {
			if(TNTRunMain.TNTRunMain.pdata.arenanames.size() >0) {
				List<String> arenas = new ArrayList<String>();
				for(TNTArena arena : TNTRunMain.TNTRunMain.pdata.getArenas()) {
					if(arena.isArenaEnabled()) {
						arenas.add(arena.getArenaName());
					}
					
				}
				sender.sendMessage("§aAviable arenas: §f" + arenas);
				
						
			}else {
				sender.sendMessage("§aNo aviable arenas");
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt list");
		}
		
		
	}

}
