package me.net.minigames.main.helppages;

import org.bukkit.command.CommandSender;

public class HelpConsole {
	
	public static void ConsoleHelp(CommandSender sender, String[] args) {
		
		if(args.length == 1) {
			sender.sendMessage("§f========== §4DMinigames Help <Page> §21/1 §f==========");
			sender.sendMessage("§f=============== §4CONSOLE §f================");
			sender.sendMessage("§f/dm help> §4See the help page of the Main commands of the plugin");
			sender.sendMessage("§a/dm reload §fReload all configs");
			sender.sendMessage("§a/dm reload <minigame> §fReload the <minigame> configs");
			sender.sendMessage("§a/dm help tdm <page> §fsee the help page of §6Team Deathmatch");
			sender.sendMessage("§a/dm help paintball <page> §fsee the help page of §6Paint ball");
			sender.sendMessage("§a/dm help spleef §fsee the help page of §6Spleef");
			sender.sendMessage("§a/dm help tntrun §fsee the help page of §tntrun");
			sender.sendMessage("§a/dm help spleef §fSee the help page of spleef");
			//tdm
		}
		if(args.length == 2) {
			
			if(args[1].equalsIgnoreCase("tdm")) {
				sender.sendMessage("§f========== §4DMinigames Help <Page> §21/1 §f==========");
				sender.sendMessage("§f=============== §4CONSOLE §f================");
				sender.sendMessage("§a/dm reload tdm §fReload the team deathmatch configs!");
				sender.sendMessage("§a/tdm seestats <player> §fsee the player's stats");
				sender.sendMessage("§a/tdm forceleave <player> §fkick the player out of the minigame");
				sender.sendMessage("§a/tdm forcejoin <player> §fAdd the player to the minigame");
				sender.sendMessage("§a/tdm players <arenaname> §fSee the players curently playing in that arena.");
				
			}
			//paintball
			if(args[1].equalsIgnoreCase("paintball")) {
				sender.sendMessage("§f========== §4DMinigames Help <Page> §21/1 §f==========");
				sender.sendMessage("§f=============== §4CONSOLE §f================");
				sender.sendMessage("§a/dm reload tdm §fReload the Paintball configs!");
				sender.sendMessage("§a/p seestats <player> §fsee the player's stats");
				sender.sendMessage("§a/p forceleave <player> §fkick the player out of the minigame");
				sender.sendMessage("§a/p forcejoin <player> §fAdd the player to the minigame");
				sender.sendMessage("§a/p players <arenaname> §fSee the players curently playing in that arena.");
			}
			//spleef
			if(args[1].equalsIgnoreCase("spleef")) {
				sender.sendMessage("§f========== §4DMinigames Help <Page> §21/1 §f==========");
				sender.sendMessage("§f=============== §4CONSOLE §f================");
				sender.sendMessage("§a/dm reload spleef §fReload the Paintball configs!");
				sender.sendMessage("§a/spleef check <arenaname> §fCheck if arena is ready to play");
				sender.sendMessage("§a/spleef list §fSee a full list of spleef arenas");
				sender.sendMessage("§a/spleef delete <arenaname> §fdelete an spleef arena");
				sender.sendMessage("§a/spleef disable <arenaname> §fdisable an spleef arena");
				sender.sendMessage("§a/spleef enable <arenaname> §fenable an spleef arena");
				sender.sendMessage("§a/spleef kick <player> §fkick the player out of the spleef game");
				sender.sendMessage("§a/spleef restore <arenaname> §repair an spleef arena");
			}
			//tntrun
			if(args[1].equalsIgnoreCase("tntrun")) {
				sender.sendMessage("§f========== §4DMinigames Help <Page> §21/1 §f==========");
				sender.sendMessage("§f=============== §4CONSOLE §f================");
				sender.sendMessage("§a/dm reload tntrun §fReload the Paintball configs!");
				sender.sendMessage("§a/tntrun arenas §fSee a full list of aviable tntrun arenas");
				sender.sendMessage("§a/tntrun delete <arenaname> §fDelete an tntrun arena");
				sender.sendMessage("§a/tntrun repair <arenaname> §frepair an tntrun arena");
				
			}
			//parkour
			if(args[1].equalsIgnoreCase("parkour")) {
				sender.sendMessage("§f========== §4DMinigames Help <Page> §21/1 §f==========");
				sender.sendMessage("§f=============== §4CONSOLE §f================");
				sender.sendMessage("§a/dm reload parkour §fReload the Paintball configs!");
				sender.sendMessage("§a/parkour kick <player> §fkick Player out of the parkour");
				sender.sendMessage("§a/parkour list §fSee a full list of aviable parkours");

			}
			
		}
	}

}
