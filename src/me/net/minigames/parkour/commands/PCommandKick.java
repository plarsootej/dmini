package me.net.minigames.parkour.commands;

import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PCommandKick {

	public static void kick(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("kick")) {
			String targetPlayer = args[1];
			if(targetPlayer != null) {
				Player p = Bukkit.getServer().getPlayerExact(targetPlayer);
				if(ParkourMain.ParkourMain.pdata.plingame.containsKey(targetPlayer)) {
					PArena arena = ParkourMain.ParkourMain.pdata.getPlayerArena(targetPlayer);
					arena.arenaph.kickPlayer(sender, p);
				}else {
					Messages.sendMessage(sender, ParkourMessages.ArenaDoesntExists);
				}
			}else {
				sender.sendMessage("§cThat player is not online!");
			}
			
		}else{
			sender.sendMessage("§cCommand Ussage: §f/parkour kick <targetplayer>");
		}
		
		
	}

}
