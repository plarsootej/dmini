package me.net.minigames.paintball.commands;

import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaCommandSpectate {
	
	public static void Pspectate(String[] args, CommandSender sender) {
		if(args.length == 2 && args[0].equalsIgnoreCase("spectate")) {
			if(sender instanceof Player) {
				if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(args[1])) {
					Player player = (Player) sender;
					PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(args[1]);
					if(arena.getSpectatePoint() != null) {
						player.teleport(arena.getSpectatePoint());
						PaMessages.sendMessage(player, PaintballMessages.spectate);
					}else {
						sender.sendMessage("§cSpectate Location doesn't exsists for this arena");
					}
				}else {
					PaMessages.sendMessage(sender, PaintballMessages.ArenaDoesntExists);
				}
			}else {
				PaMessages.sendMessage(sender, PaintballMessages.PlayerOnlyCmd);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb spectate <arenaname>");
		}
		
	}

}
