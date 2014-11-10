package me.net.minigames.parkour.commands;

import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PCommandJoin {
	
	public static void Join(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 2 && args[0].equalsIgnoreCase("join")) {
				if(ParkourMain.ParkourMain.pdata.arenanames.containsKey(args[1])) {
					PArena arena = ParkourMain.ParkourMain.pdata.getArenaByName(args[1]);
					Player player = (Player) sender;
					
						if(!arena.isArenaConfigured().equalsIgnoreCase("yes")) {Messages.sendMessage(player, ParkourMessages.NotConfigured); return;}
						if(!arena.isArenaEnabled()) {Messages.sendMessage(player, ParkourMessages.ArenaIsDisabled); return;}
						
						arena.arenaph.JoinPlayer(player);
						
						return;
					
				}else {
					Messages.sendMessage(sender, ParkourMessages.ArenaDoesntExists);
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/parkour join <arenaname>");
			}
			
		}else {
			Messages.sendMessage(sender, ParkourMessages.Console);
		}
	}

}
