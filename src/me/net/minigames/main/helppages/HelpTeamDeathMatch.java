package me.net.minigames.main.helppages;

import org.bukkit.command.CommandSender;

public class HelpTeamDeathMatch {
	
	/** Team DeathMatch **/
	public static void TdmHelp(CommandSender sender, String[] args) {
		if(sender.hasPermission("dm.teamdeathmatch.admin")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/tdm help <page> §4see the help page");
					sender.sendMessage("§a/tdm spectate <arenaname> §fSpectate and game");
					sender.sendMessage("§a/tdm join <red|blue> <arenaname> §fJoin a game");
					sender.sendMessage("§a/tdm leave §fLeave the minigame");
					sender.sendMessage("§a/tdm kit <kitname|list> §fGive yourself the kit or see a list");
					sender.sendMessage("§a/tdm arenas §fSee a full list of aviable arenas");
				}
				if(args[2].equalsIgnoreCase("2")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §22/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/tdm help <page> §4see the help page");
					sender.sendMessage("§a/tdm kick<player> §fkick a player out of team deathmatch");
					sender.sendMessage("§a/tdm setup §fSee the setup help page");
					sender.sendMessage("§a/tdm check <arenaname> §fCheck if arena is ready");
					sender.sendMessage("§a/tdm create <arenaname> §fCreates an arena");
					sender.sendMessage("§a/tdm setspawn <red|blue> <arenaname> §fSet the spawn location");
					
					
					
				}
				if(args[2].equalsIgnoreCase("3")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §23/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/tdm help <page> §4see the help page");
					sender.sendMessage("§a/tdm setlobby §fSets the lobby location");
					sender.sendMessage("§a/tdm setspectate §fSets the spectate location");
					sender.sendMessage("§a/tdm setcountdown <arenaname> <seconds> §fChange the lobby countdown");
					sender.sendMessage("§a/tdm delete <arenaname> §fDeletes an arena");
					sender.sendMessage("§a/tdm disable <arenaname> §fDisable an arena");
					
				}
				if(args[2].equalsIgnoreCase("4")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §23/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/tdm help <page> §4see the help page");
					sender.sendMessage("§a/tdm enable <arenaname> §fEnable an arena");
					sender.sendMessage("§a/tdm wand §fget the wand tool to created borderd arenas");
				}else {
					sender.sendMessage("§cCommand Ussage: §f/dm help tdm <1|2|3|4>");
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/dm help tdm <page>");
			}
			
		}else 
		//moderator team deathmatch
		if(sender.hasPermission("dm.teamdeathmatch.moderator")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/2 §0==========");
					sender.sendMessage("§0=============== §4Moderator §0================");
					sender.sendMessage("§6/tdm help <page> §4see the help page");
					sender.sendMessage("§a/tdm spectate <arenaname> §fSpectate and game");
					sender.sendMessage("§a/tdm join <red|blue> <arenaname> §fJoin a game");
					sender.sendMessage("§a/tdm leave §fLeave the minigame");
					sender.sendMessage("§a/tdm kit <kitname|list> §fGive yourself the kit or see a list");
					sender.sendMessage("§a/tdm arenas §fSee a full list of aviable arenas");
				}
				if(args[2].equalsIgnoreCase("2")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §22/2 §0==========");
					sender.sendMessage("§0=============== §4Moderator §0================");
					sender.sendMessage("§6/tdm help <page> §4see the help page");
					sender.sendMessage("§a/tdm kick<player> §fkick a player out of team deathmatch");
					sender.sendMessage("§a/tdm enable <arenaname> §fEnable an arena");
					sender.sendMessage("§a/tdm disable <arenaname> §fDisable an arena");
					
				}else {
					sender.sendMessage("§cCommand Ussage: §f/dm help tdm <1|2>");
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/dm help tdm <page>");
			}
			
		}else {
			//user team deathmatch
			sender.sendMessage("§0========== §4DMinigames Help <Page> §21/1 §0==========");
			sender.sendMessage("§0=============== §4User §0================");
			sender.sendMessage("§6/tdm help <page> §4see the help page");
			sender.sendMessage("§a/tdm spectate <arenaname> §fSpectate and game");
			sender.sendMessage("§a/tdm join <red|blue> <arenaname> §fJoin a game");
			sender.sendMessage("§a/tdm leave §fLeave the minigame");
			sender.sendMessage("§a/tdm kit <kitname|list> §fGive yourself the kit or see a list");
			sender.sendMessage("§a/tdm arenas §fSee a full list of aviable arenas");
		}
	}

}
