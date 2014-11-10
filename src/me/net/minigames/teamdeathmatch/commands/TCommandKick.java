package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TCommandKick {

	public static void kick(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("kick")){
			Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
			if(targetPlayer != null) {
				TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getPlayerArena(targetPlayer.getName());
				arena.arenaph.kickPlayer(targetPlayer);
			}else {
				sender.sendMessage("§cThat player is not online!");
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §/tdm kick <player>");
		}
		
	}

}
