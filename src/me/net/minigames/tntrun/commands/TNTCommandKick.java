package me.net.minigames.tntrun.commands;

import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTCommandKick {

	public static void kick(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("kick")){
			Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
			if(targetPlayer != null) {
				TNTArena arena = TNTRunMain.TNTRunMain.pdata.getPlayerArena(targetPlayer.getName());
				arena.arenaph.kickPlayer(targetPlayer);
			}else {
				sender.sendMessage("§cThat Player is not online!");
			}

			
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt kick <player>");
		}
		
	}

}
