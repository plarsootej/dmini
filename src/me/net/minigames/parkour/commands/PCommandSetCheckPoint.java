package me.net.minigames.parkour.commands;

import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PCommandSetCheckPoint {

	public static void PSetCheck(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 3 && args[0].equalsIgnoreCase("addcheckpoint")) {
				String arenaname = args[1];
				String checkpoint = args[2];
				PArena arena = ParkourMain.ParkourMain.pdata.getArenaByName(arenaname);
				Player player = (Player) sender;
				Location loc = player.getLocation();
				arena.setCheckPoint(checkpoint, loc);
				arena.saveToConfig();
				Messages.sendMessage(player, ParkourMessages.CheckPointSet);
			}
		}
		
	}

}
