package me.net.minigames.parkour.commands;

import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PCommandSetSpawn {

	public static void PSetSpawn(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 2 && args[0].equalsIgnoreCase("setspawn")) {
				if(ParkourMain.ParkourMain.pdata.arenanames.containsKey(args[1])) {
					PArena arena = ParkourMain.ParkourMain.pdata.getArenaByName(args[1]);
					Player player = (Player) sender;
					Location loc = player.getLocation();
					arena.setSpawnPoint(loc);
					arena.saveToConfig();
					sender.sendMessage("§aSpawn Succesfully set for parkour: §f" + args[1]);
				}else {
					Messages.sendMessage(sender, ParkourMessages.ArenaDoesntExists);
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/parkour setspawn <arenaname>");
			}
		}else {
			Messages.sendMessage(sender, ParkourMessages.Console);
		}
	}
	
	

}
