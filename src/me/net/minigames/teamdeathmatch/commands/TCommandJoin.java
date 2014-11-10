package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.handlers.TPlayerDataStore;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TCommandJoin {

	public static void join(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 2 ) {
				Player player = (Player )sender;
				if(!TeamDeathMatchMain.TeamDeathMatchMain.pdata.plingame.containsKey(player.getName())) {
					String arenaname = args[1];
					if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.arenanames.containsKey(arenaname)) {
						TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaByName(arenaname);
						if(arena.isArenaConfigured() == "yes") {
							if(arena.isArenaEnabled()) {
								if(TPlayerDataStore.redteam.size() == TPlayerDataStore.blueteam.size()) {
									arena.arenaph.joinBlue(player);
								}
								else if (TPlayerDataStore.redteam.size() < TPlayerDataStore.blueteam.size()) {
									if(!(TPlayerDataStore.blueteam.contains(player.getName()))) {
										arena.arenaph.joinRed(player);
									}
								}
								else if (TPlayerDataStore.redteam.size() > TPlayerDataStore.blueteam.size()) {
									if(!(TPlayerDataStore.redteam.contains(player.getName()))) {
										arena.arenaph.joinBlue(player);
									}
								}
							}else {
								TMessages.sendMessage(player, TeamDeathMatchMessages.ArenaIsDisabled);
							}
							
						}else {
							sender.sendMessage("§cThat arena is not configured Contact an admin!");
						}
					}else {
						TMessages.sendMessage(sender, TeamDeathMatchMessages.ArenaDoesntExists);
					}
					
				}else {
					TMessages.sendMessage(sender, TeamDeathMatchMessages.alreadyingame);
					
				}
				
			}else {
				sender.sendMessage("§cCommand Ussage: §f/tdm join <red|blue> <arenaname>");
			}
		}else {
			TMessages.sendMessage(sender, TeamDeathMatchMessages.PlayerOnlyCmd);
		}
		
	}

}
