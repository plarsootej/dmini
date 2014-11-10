package me.net.minigames.spleef.commands;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandSetLobby {

	public static void SetLobby(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(args[1])) {
				if(args.length == 2  && args[0].equalsIgnoreCase("setlobby")) {
					Player player = (Player) sender;
					SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(args[1]);
					Location loc = player.getLocation();
					arena.setLobbyPoint(loc);
					arena.saveToConfig();
					
					player.sendMessage("§aLobby Location succesfully set for arena: §f" + args[1]);
				}else {
					sender.sendMessage("§cCommand Ussage: §f/spleef setlobby <arenaname>");
				}
			}else {
				Messages.sendMessage(sender, SpleefMessages.ArenaDoesntExists);
			}
			
		}else {
			Messages.sendMessage(sender, SpleefMessages.PlayerOnlyCmd);
		}
		
	}

}
