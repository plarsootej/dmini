package me.net.minigames.paintball.commands;

import java.util.ArrayList;
import java.util.List;

import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;

import org.bukkit.command.CommandSender;

public class PaCommandArenas {
	
	private static List<String> arenasnames = new ArrayList<String>();


	public static void CommandArenas(CommandSender sender, String[] args) {
		if(args.length == 1 && args[0].equalsIgnoreCase("arenas")) {
			for(PAArenas arenas : PaintballMain.PaintBallMain.pdata.getArenas()) {
				if(arenas.isArenaEnabled()) {
					arenasnames.add(arenas.getArenaName());
				}
				
			}
			sender.sendMessage("§aAviable arenas : §f" + arenasnames);
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb arenas");
		}
	}

}
