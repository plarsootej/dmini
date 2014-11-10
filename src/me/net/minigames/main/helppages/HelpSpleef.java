package me.net.minigames.main.helppages;

import org.bukkit.command.CommandSender;

public class HelpSpleef {
	
	public static void SpleefHelp(CommandSender sender, String[] args) {
		
		//spleef admin
		if(sender.hasPermission("dm.spleef.admin")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/dm help spleef <page> §4see the help page");
					sender.sendMessage("§a/spleef spectate §fSpectate the game");
					sender.sendMessage("§a/spleef join §fJoin the game");
					sender.sendMessage("§a/spleef leave §fLeave the minigame");
					sender.sendMessage("§a/spleef list §fSee a full list of spleef arenas");
					sender.sendMessage("§a/spleef kick <targetplayer> §fkicks a player from the arena");
				}
				if(args[2].equalsIgnoreCase("2")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §22/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/dm help spleef <page> §4see the help page");
					sender.sendMessage("§a/spleef setup §fsee the setup help pages");
					sender.sendMessage("§a/spleef wand §fget the wandtool");
					sender.sendMessage("§a/spleef create <arenaname> §fcreates an arena!");
					sender.sendMessage("§a/spleef createfloor <arenaname> §fcreates an floor for arena");
					sender.sendMessage("§a/spleef setloselevel <arenaname> §fSet the lose level for arena");
				}if(args[0].equalsIgnoreCase("3")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §23/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/dm help spleef <page> §4see the help page");
					sender.sendMessage("§a/spleef setspawn <arenaname> §fSet the spawn location");
					sender.sendMessage("§a/spleef setspectate <arenaname> §fSet the spectate location");
					sender.sendMessage("§a/spleef setlobby <arenaname> §fsee the lobby location");
					sender.sendMessage("§a/spleef check <arenaname> §fCheck if arena is ready");
					sender.sendMessage("§a/spleef delete <arenaname> §fdeletes the arena");
				}if(args[0].equalsIgnoreCase("4")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §23/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/dm help spleef <page> §4see the help page");
					sender.sendMessage("§a/spleef enable <arenaname> §fEnables an arena");
					sender.sendMessage("§a/spleef disable <arenaname> §fDisables an arena");
					sender.sendMessage("§a/spleef restore <arenaname> §frepairs the arenafloors");
					sender.sendMessage("§a/spleef setcountdown <arenaname> <seconds> §fSets the lobby countdown");
				}else {
					sender.sendMessage("§cCommand Ussage: §f/dm help spleef <1|2|3|4>");
				}
			}else{
				sender.sendMessage("§cCommand Ussage: §f/dm help spleef <1|2|3|4>");
			}
		}else
		//spleef moderator
		if(sender.hasPermission("dm.spleef.moderator")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/2 §0==========");
					sender.sendMessage("§0=============== §4Moderator §0================");
					sender.sendMessage("§6/dm help spleef <page> §4see the help page");
					sender.sendMessage("§a/spleef spectate §fSpectate the game");
					sender.sendMessage("§a/spleef join §fJoin the game");
					sender.sendMessage("§a/spleef leave §fLeave the minigame");
					sender.sendMessage("§a/spleef list §fSee a full list of spleef arenas");
					sender.sendMessage("§a/spleef kick <targetplayer> §fkicks a player from the arena");

				}
				if(args[2].equalsIgnoreCase("2")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §22/2 §0==========");
					sender.sendMessage("§0=============== §4Moderator §0================");
					sender.sendMessage("§6/dm help spleef <page> §4see the help page");
					sender.sendMessage("§a/spleef enable <arenaname> §fEnables an arena");
					sender.sendMessage("§a/spleef disable <arenaname> §fDisables an arena");
					sender.sendMessage("§a/spleef restore <arenaname> §frepairs the arenafloors");
					
				}else {
					sender.sendMessage("§cCommand Ussage: §f/dm help spleef <1|2>");
				}
			}else{
				sender.sendMessage("§cCommand Ussage: §f/dm help spleef <1|2|3>");
			}
		}else {
			if(args.length == 2 && args[0].equalsIgnoreCase("help") && args[1].equalsIgnoreCase("spleef")) {
				//Spleef User
				sender.sendMessage("§0========== §4DMinigames Help <Page> §21/1 §0==========");
				sender.sendMessage("§0=============== §4User §0================");
				sender.sendMessage("§6/dm help spleef <page> §4see the help page");
				sender.sendMessage("§a/spleef spectate §fSpectate the game");
				sender.sendMessage("§a/spleef join §fJoin the game");
				sender.sendMessage("§a/spleef leave §fLeave the minigame");
				sender.sendMessage("§a/spleef list §fSee a full list of spleef arenas");
			}else {
				sender.sendMessage("§cUser Command Ussage: §f/dm help spleef");
			}

		}
	}
	

}
