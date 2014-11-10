package me.net.minigames.paintball.commands;


import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaCommandSetSpawn {
	
	
	public static void PSetspawnCommand(String[] args, CommandSender sender) {
		if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(args[2])) {
			if(args.length == 3 && args[0].equalsIgnoreCase("setspawn")) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(args[2]);
					String team = args[1];
					Location loc = player.getLocation();
					if(team.equalsIgnoreCase("red")) {
						//set red team spawn
						arena.setRedSpawn(loc);
						sender.sendMessage("§cRed §aSpawn location succesfully set for arena §f" + args[2]);
						
					}
					if(team.equalsIgnoreCase("blue")) {
						//set blue team spawn
						arena.setBlueSpawn(loc);
						sender.sendMessage("§9Blue §aSpawn location succesfully set for arena §f" + args[2]);
						
					}
					arena.saveToConfig();

					
				}else {
					PaMessages.sendMessage(sender, PaintballMessages.PlayerOnlyCmd);
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/pb setspawn <red|blue> <arenaname>");
			}
		}else {
			PaMessages.sendMessage(sender, PaintballMessages.ArenaDoesntExists);
		}
			
			

	}
}
