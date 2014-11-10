package me.net.minigames.spleef.commands;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandKick {

	public static void KickCommand(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("kick")){
			Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
			if(targetPlayer != null) {
				SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(targetPlayer.getName());
				arena.arenaph.kickPlayer(targetPlayer);
			}else {
				sender.sendMessage("§cThat Player is not online!");
			}

			
		}else {
			sender.sendMessage("§cCommand Ussage: §f/spleef kick <player>");
		}
		
	}
	
	

}
