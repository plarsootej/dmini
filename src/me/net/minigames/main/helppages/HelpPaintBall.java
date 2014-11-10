package me.net.minigames.main.helppages;

import org.bukkit.command.CommandSender;

public class HelpPaintBall {
	
	public static void PaintballHelp(CommandSender sender, String[] args) {
		
		if(sender.hasPermission("dm.paintball.admin")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/2 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/dm help <page> §4see the help page");
					sender.sendMessage("§a/p spectate <arenaname> §fSpectate and game");
					sender.sendMessage("§a/p join <red|blue> <arenaname> §fJoin a game");
					sender.sendMessage("§a/p leave §fLeave the minigame");
					sender.sendMessage("§a/p stats §fSee your own stats");
				}
				if(args[2].equalsIgnoreCase("2")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §22/2 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/dm help <page> §4see the help page");
					sender.sendMessage("§a/p setspawn <red|blue> <arenaname> §fSet the spawn location");
					sender.sendMessage("§a/p setspectate <red|blue> <arenaname> §fSet the spectate location");
					sender.sendMessage("§a/p seestats <player> §fsee the player's stats");
					sender.sendMessage("§a/p forceleave <player> §fkick the player out of the minigame");
					sender.sendMessage("§a/p forcejoin <player> §fAdd the player to the minigame");
				}else {
					sender.sendMessage("§cCommand Ussage: §f/dm help paintball <1|2>");
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/dm help paintball <page>");
			}
			
		}else
		//moderator paintball
		if(sender.hasPermission("dm.paintball.moderator")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/2 §0==========");
					sender.sendMessage("§0=============== §4Moderator §0================");
					sender.sendMessage("§6/dm help <page> §4see the help page");
					sender.sendMessage("§a/p spectate <arenaname> §fSpectate the game");
					sender.sendMessage("§a/p join <red|blue> <arenaname> §fJoin a game");
					sender.sendMessage("§a/p leave §fLeave the minigame");
					sender.sendMessage("§a/p stats §fSee your own stats");
				}
				if(args[2].equalsIgnoreCase("2")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §22/2 §0==========");
					sender.sendMessage("§0=============== §Moderator §0================");
					sender.sendMessage("§a/p seestats <player> §fsee the player's stats");
					sender.sendMessage("§a/p forceleave <player> §fkick the player out of the minigame");
					sender.sendMessage("§a/p forcejoin <player> §fAdd the player to the minigame");
				}else {
					sender.sendMessage("§cCommand Ussage: §f/dm help paintball <1|2>");
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/dm help paintball <page>");
			}
			
		}else {
			//user paintball
			sender.sendMessage("§0========== §4DMinigames Help <Page> §21/1 §0==========");
			sender.sendMessage("§0=============== §4User §0================");
			sender.sendMessage("§6/dm help <page> §4see the help page");
			sender.sendMessage("§a/p spectate <arenaname> §fSpectate the game");
			sender.sendMessage("§a/p join <red|blue> <arenaname> §fJoin a game");
			sender.sendMessage("§a/p leave §fLeave the minigame");
			sender.sendMessage("§a/p stats §fSee your own stats");
		}
		
	}

}
