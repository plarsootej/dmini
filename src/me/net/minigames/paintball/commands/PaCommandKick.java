package me.net.minigames.paintball.commands;

import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaCommandKick {

	public static void kick(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("kick")){
			Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
			if(targetPlayer != null) {
				PAArenas arena = PaintballMain.PaintBallMain.pdata.getPlayerArena(targetPlayer.getName());
				arena.arenaph.kickPlayer(targetPlayer);
			}else {
				sender.sendMessage("§cThat Player is not online!");
			}
			
			
		}else {
			sender.sendMessage("§cCommand Ussage: §/pb kick <player>");
		}
		
	}

}
