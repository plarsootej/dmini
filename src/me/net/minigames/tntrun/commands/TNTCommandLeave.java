package me.net.minigames.tntrun.commands;


import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTCommandLeave {
	
	public static void LeaveTNT(CommandSender sender, String[] args) {
		if(args.length == 1 && args[0].equalsIgnoreCase("leave")){
			if(sender instanceof Player) {
				
				Player player = (Player) sender;
				
				if(TNTRunMain.TNTRunMain.pdata.plingame.containsKey(player.getName())) {
					
					TNTArena arena = TNTRunMain.TNTRunMain.pdata.getPlayerArena(player.getName());
					if(arena != null) {
						arena.arenaph.LeavePlayer(player, true);
					}
					
					
				}else {
					sender.sendMessage("§cYou are not in a TNT RUN game!");
				}
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.PlayerOnlyCmd);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt leave");
		}
		
	}

}
