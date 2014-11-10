package me.net.minigames.paintball.commands;

import java.io.File;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaCommandDelete {

	public static void delete(CommandSender sender, String[] args) {
		if(args.length == 2 && args[0].equalsIgnoreCase("delete")) {
			if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(args[1])) {
				PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(args[1]);
				for(String p : PaintballMain.PaintBallMain.pdata.getArenaPlayers(arena)) {
					Player players = Bukkit.getServer().getPlayerExact(p);
					players.teleport(arena.getLobbyPoint());
					PaMessages.sendMessage(players, PaintballMessages.DeletedArena);
					PaintballMain.PaintBallMain.pdata.removePlayerFromArena(p);
					PaintballMain.PaintBallMain.pdata.removeArenaFromHashMap(arena);
					File file = new File(MainClass.main.getDataFolder() + "/Paintball/Arenas" + args[1] + ".yml");
					file.delete();
					
				}
				
			}else {
				PaMessages.sendMessage(sender, PaintballMessages.ArenaDoesntExists);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb delete <arenaname>");
		}
		
		
	}

}
