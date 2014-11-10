package me.net.minigames.spleef.commands;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandLeave {
	
	public static void LeaveSpleef(CommandSender sender) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(SpleefMain.SpleefMain.pdata.plingame.containsKey(player.getName())) {
				SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(player.getName());
				
				if(arena != null) {
					arena.arenaph.LeavePlayer(player);
					if(SpleefMain.SpleefMain.pdata.getArenaPlayers(arena).size() == 0) {
						arena.setRunning(false);
					}
				}
			}else {
				sender.sendMessage("§cYou are not in the spleef game!");
			}
			
			
		}else {
			Messages.sendMessage(sender, SpleefMessages.PlayerOnlyCmd);
		}
	}

}
