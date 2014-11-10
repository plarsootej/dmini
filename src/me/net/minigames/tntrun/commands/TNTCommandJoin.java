package me.net.minigames.tntrun.commands;

import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTCommandJoin {

	public static void JoinTNT(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 2 && args[0].equalsIgnoreCase("join")) {
				final String arenaname = args[1];
				if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
					
					TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(arenaname);
					if(arena.isArenaConfigured() == "yes") {
						if(arena.isArenaEnabled()) {
							Player player = (Player) sender;
							arena.arenaph.join(player);
						}else {
							TNTMessages.sendMessage(sender, TNTRunMessages.ArenaIsDisabled);
						}

					}else {
						sender.sendMessage("§cArena not configured. Please contact an admin!");
					}
					
				}else {
					TNTMessages.sendMessage(sender, TNTRunMessages.ArenaDoesntExists);
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/tnt join <arenaname>");
			}
		}else {
			TNTMessages.sendMessage(sender, TNTRunMessages.PlayerOnlyCmd);
		}
	}

}
