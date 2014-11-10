package me.net.minigames.paintball.commands;


import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaCommandLeave {
	
	public static void Pleave(String[] args, CommandSender sender) {
		if(args.length == 1 && args[0].equalsIgnoreCase("leave")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				
				PAArenas arena = PaintballMain.PaintBallMain.pdata.getPlayerArena(player.getName());
				if(arena != null) {
					arena.arenaph.LeavePlayer(player);
				}
				
			}else {
				PaMessages.sendMessage(sender, PaintballMessages.PlayerOnlyCmd);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb leave");
		}
		
	}

}
