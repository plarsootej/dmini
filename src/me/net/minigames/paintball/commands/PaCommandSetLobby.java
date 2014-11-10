package me.net.minigames.paintball.commands;

import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaCommandSetLobby {

	public static void lobby(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(args[1])) {
				if(args.length == 2  && args[0].equalsIgnoreCase("setlobby")) {
					Player player = (Player) sender;
					PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(args[1]);
					Location loc = player.getLocation();
					arena.setLobbyPoint(loc);
					arena.saveToConfig();
					
					player.sendMessage("§aLobby Location succesfully set for arena: §f" + args[1]);
				}else {
					sender.sendMessage("§cCommand Ussage: §f/pb setlobby <arenaname>");
				}
			}else {
				PaMessages.sendMessage(sender, PaintballMessages.ArenaDoesntExists);
			}
			
		}else {
			PaMessages.sendMessage(sender, PaintballMessages.PlayerOnlyCmd);
		}
		
	}

}
