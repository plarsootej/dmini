package me.net.minigames.spleef.commands;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.handlers.ArenaHandler;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandJoin {

	public static void Join(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 2 && args[0].equalsIgnoreCase("join")) {
				if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(args[1])) {
					SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(args[1]);
					Player player = (Player) sender;
					
						if(arena.isArenaRunning()) {Messages.sendMessage(player, SpleefMessages.arenaStillRunning); return;}
						if(!arena.isArenaConfigured().equalsIgnoreCase("yes")) {SpleefMessages.NotConfigured(player, arena.getArenaName()); return;}
						if(!arena.isArenaEnabled()) {SpleefMessages.DisabledArena(player); return;}
						
						arena.arenaph.lobbyPlayer(player);
						ArenaHandler.CheckStarting(arena);
						
						return;
					
				}else {
					Messages.sendMessage(sender, SpleefMessages.ArenaDoesntExists);
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/spleef join <arenaname>");
			}
			
		}else {
			Messages.sendMessage(sender, SpleefMessages.PlayerOnlyCmd);
		}
		
		
	}

}
