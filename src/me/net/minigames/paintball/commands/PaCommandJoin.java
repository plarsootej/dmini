package me.net.minigames.paintball.commands;

import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.handlers.PAPlayerDataStore;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaCommandJoin {
	
	
	public static void Pjoin(String[] args, CommandSender sender) {
		if(sender instanceof Player) {
			if(args.length == 2 ) {
				Player player = (Player )sender;
				if(!PaintballMain.PaintBallMain.pdata.plingame.containsKey(player.getName())) {
					String arenaname = args[1];
					if(PaintballMain.PaintBallMain.pdata.arenanames.containsKey(arenaname)) {
						PAArenas arena = PaintballMain.PaintBallMain.pdata.getArenaByName(arenaname);
						if(arena.isArenaConfigured() == "yes") {
							if(arena.isArenaEnabled()) {
								if(PAPlayerDataStore.redteam.size() == PAPlayerDataStore.blueteam.size()) {
									arena.arenaph.joinBlue(player);
								}
								else if (PAPlayerDataStore.redteam.size() < PAPlayerDataStore.blueteam.size()) {
									if(!(PAPlayerDataStore.blueteam.contains(player.getName()))) {
										arena.arenaph.joinRed(player);
									}
								}
								else if (PAPlayerDataStore.redteam.size() > PAPlayerDataStore.blueteam.size()) {
									if(!(PAPlayerDataStore.redteam.contains(player.getName()))) {
										arena.arenaph.joinBlue(player);
									}
								}
							}else {
								PaMessages.sendMessage(player, PaintballMessages.ArenaDisabled);
							}
							
						}else {
							sender.sendMessage("§cArena is not configured Contact an admin!");
						}
					}else {
						PaMessages.sendMessage(sender, PaintballMessages.ArenaDoesntExists);
					}
					
				}else {
					PaMessages.sendMessage(sender, PaintballMessages.alreadyingame);
					
				}
				
			}else {
				sender.sendMessage("§cCommand Ussage: §f/pb join <arenaname>");
			}
		}else {
			PaMessages.sendMessage(sender, PaintballMessages.PlayerOnlyCmd);
		}
	}

}
