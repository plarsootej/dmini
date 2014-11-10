package me.net.minigames.parkour.commands;


import java.util.ArrayList;
import java.util.List;

import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;

import org.bukkit.command.CommandSender;

public class PCommandList {

	public static void Parkours(CommandSender sender, String[] args) {
		if(args.length == 1 && args[0].equalsIgnoreCase("list")) {
			if(ParkourMain.ParkourMain.pdata.arenanames.size() >0) {
				List<String> parkours = new ArrayList<String>();
				for(PArena parkour : ParkourMain.ParkourMain.pdata.getArenas()) {
					parkours.add(parkour.getArenaName());
				}
				sender.sendMessage("§aAviable parkours: §f" + parkours);
				
						
			}else {
				sender.sendMessage("§aNo aviable parkours");
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/parkour list");
		}
		
		
	}

}
