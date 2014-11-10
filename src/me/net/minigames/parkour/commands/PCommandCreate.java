package me.net.minigames.parkour.commands;


import me.net.minigames.main.MainClass;
import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PCommandCreate {
	
	public static void ParkourCreate(CommandSender sender, String[] args) {
		if(args.length == 2) {
			if(sender instanceof Player) {
				String arenaname = args[1];
				if(!ParkourMain.ParkourMain.pdata.arenanames.containsKey(arenaname)) {
					Player player = (Player) sender;
					Location loc = player.getLocation();
					PArena arena = new PArena(arenaname, MainClass.main, ParkourMain.ParkourMain);
					arena.setSpawnPoint(loc);
					arena.SetArenaWorld(loc.getWorld().getName());
					arena.saveToConfig();
					Messages.sendMessage(player, ParkourMessages.ArenaCreated);
				}else {
					sender.sendMessage("§aThat arena already exists!");
					sender.sendMessage("§cTo delete the old arena with name: §6" +arenaname +" §f/parkour delete <arenaname>");
				}
				
			}else {
				Messages.sendMessage(sender, ParkourMessages.Console);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/parkour create <arenaname>");
		}
	}

}
