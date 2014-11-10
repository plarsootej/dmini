package me.net.minigames.paintball.commands;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaCommandSetSpectate{

	MainClass plugin; 
	public PaCommandSetSpectate (MainClass instance) {
		plugin = instance;
	}
	
	public static void PSetSpectateCommand(String[] args, CommandSender sender) {
		if(args.length == 2 && args[0].equalsIgnoreCase("setspectate")) {
			if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(args[1])) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(args[1]);
					Location loc = player.getLocation();
					arena.setSpectatePoint(loc);
					arena.saveToConfig();
					
					player.sendMessage("§aSpectate Location succesfully set for arena: §f" + args[1]);
				}else {
					PaMessages.sendMessage(sender, PaintballMessages.PlayerOnlyCmd);
				}
			}else {
				PaMessages.sendMessage(sender, PaintballMessages.ArenaDoesntExists);
			}

			
		}else {
			sender.sendMessage("§cCommand Ussage: §f/pb setspectate <arenaname>");
		}
			
			
	}
	
}
