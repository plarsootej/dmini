package me.net.minigames.main.helppages;

import org.bukkit.command.CommandSender;

public class HelpTntRun {
	
	public static void tntrunhelp(CommandSender sender, String[] args) {
		if(sender.hasPermission("dm.tntrun.admin")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/tnt help <page> §4see the help page");
					sender.sendMessage("§a/tnt join <arenaname> §fJoin the tnt run minigame");
					sender.sendMessage("§a/tnt leave §fleave the minigame");
					sender.sendMessage("§a/tnt spectate <arenaname> §fteleport to the arena spectate location");
					sender.sendMessage("§a/tnt list §fsee full list of aviable arenas");
					sender.sendMessage("§a/tnt kick <player> §fKicks a player out of tntrun");
					
				}
				if(args[2].equalsIgnoreCase("2")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §22/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/tnt help <page> §4see the help page");
					sender.sendMessage("§a/tnt enable <arenaname> §fEnables an arena");
					sender.sendMessage("§a/tnt disable <arenename> §fDisables an arena");
					sender.sendMessage("§a/tnt setcountdown <arenaname> <seconds> §fSet the lobby Countdown");
					sender.sendMessage("§a/tnt check <arenaname> §fSee if the arena is ready to play");
					sender.sendMessage("§a/tnt wand §fgets the wand tool");
					
				}
				if(args[2].equalsIgnoreCase("3")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §23/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/tnt help <page> §4see the help page");
					sender.sendMessage("§a/tnt setup §fSee the setup help page");
					sender.sendMessage("§a/tnt create <arenaname> §fcreates an arena");
					sender.sendMessage("§a/tnt createfloor <arenename> <floor> §fCreate a floor");
					sender.sendMessage("§a/tnt createlose <arenaname> §fCreate lose area");
					sender.sendMessage("§a/tnt locations §fSee the help page for the arenas");
					
				}
				if(args[2].equalsIgnoreCase("4")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §24/4 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/tnt help <page> §4see the help page");
					sender.sendMessage("§a/tnt setlobby <arenaname> §fSets the lobby for area");
					sender.sendMessage("§a/tnt setspawn <arenaname> §fSets the spawn for area");
					sender.sendMessage("§a/tnt setspectate <arenaname> §fSets the spectate for area");
					sender.sendMessage("§a/tnt repair <arenaname> §frepairs an arena");
					sender.sendMessage("§a/tnt delete <arenaname> §fDelete arena");
				}

			}else {
				sender.sendMessage("§cCommand Ussage: §f/dm help tntrun <1|2|3|4>");
			}

		}else
			
		if(sender.hasPermission("dm.tntrun.moderator")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/2 §0==========");
					sender.sendMessage("§0=============== §4MODERATOR §0================");
					sender.sendMessage("§6/tnt help <page> §4see the help page");
					sender.sendMessage("§a/tnt join <arenaname> §fJoin the tnt run minigame");
					sender.sendMessage("§a/tnt leave §fleave the minigame");
					sender.sendMessage("§a/tnt list §fsee full list of aviable arenas");
					sender.sendMessage("§a/tnt repair <arenaname> §frepairs an arena");
					sender.sendMessage("§a/tnt kick <player> §fKicks a player out of tntrun");

				}if(args[2].equalsIgnoreCase("2")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §22/2 §0==========");
					sender.sendMessage("§0=============== §4MODERATOR §0================");
					sender.sendMessage("§6/tnt help <page> §4see the help page");
					sender.sendMessage("§a/tnt enable <arenaname> §fEnables an arena");
					sender.sendMessage("§a/tnt disable <arenename> §fDisables an arena");
				}else {
					sender.sendMessage("§cCommand Ussage: §f/dm help tntrun <1>");
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/dm help tntrun <1>");
			}
		}else {
			//tntrun User
			sender.sendMessage("§0========== §4DMinigames Help <Page> §21/1 §0==========");
			sender.sendMessage("§0=============== §4USER §0================");
			sender.sendMessage("§6/tnt help <page> §4see the help page");
			sender.sendMessage("§a/tnt join <arenaname> §fJoin the tnt run minigame");
			sender.sendMessage("§a/tnt spectate <arenaname> §fteleport to the arena spectate location");
			sender.sendMessage("§a/tnt leave §fleave the minigame");
			sender.sendMessage("§a/tnt list §fsee full list of aviable arenas");
		}
	}

}
