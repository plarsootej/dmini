package me.net.minigames.paintball.commands;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaCommandCreate {

	public static void Create(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 2 && args[0].equalsIgnoreCase("create")) {
				String arenaname = args[1];
				if(!PaintballMain.PaintBallMain.pdata.arenanames.containsKey(arenaname)) {
					PAArenas arena = new PAArenas(arenaname, MainClass.main, PaintballMain.PaintBallMain);
					
					Player player = (Player) sender;
					arena.setArenaWorld(player.getWorld().getName());
					arena.saveToConfig();
					
					sender.sendMessage("§aArena succesfully created!");
					sender.sendMessage("§aFor more setup information §f/pb setup");
				}else {
					sender.sendMessage("§aThat arena already exists!");
					sender.sendMessage("§cTo delete the old arena with name: §6" +arenaname +" §f/pb delete <arenaname>");
				}
				
			}else {
				sender.sendMessage("§cCommand Ussage: §f/pb create <arenename>");
			}
		}else {
			PaMessages.sendMessage(sender, PaintballMessages.PlayerOnlyCmd);
		}
		
	}

}
