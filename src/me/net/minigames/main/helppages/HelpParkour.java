package me.net.minigames.main.helppages;

import org.bukkit.command.CommandSender;

public class HelpParkour {
	
	public static void parkourhelp(CommandSender sender, String[] args) {
		
		//parkour admin
		if(sender.hasPermission("dm.parkour.admin")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/2 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/dm help parkour <page> §4see the help page");
					sender.sendMessage("§a/parkour join <parkour> §fJoins the parkour");
					sender.sendMessage("§a/parkour leave §fleave the parkour");
					sender.sendMessage("§a/parkour list §fSee a full list of aviable parkours");
					sender.sendMessage("§a/parkour create <parkourname> §fCreates new parkour");
					sender.sendMessage("§a/parkour setspawn <parkourname> §fSets the spawn location");

				}
				if(args[2].equalsIgnoreCase("2")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §22/2 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/dm help parkour <page> §4see the help page");
					sender.sendMessage("§a/parkour kick <playername> §fKicks a player from parkour");
					sender.sendMessage("§a/parkour enable <parkour> §fEnables an parkour");
					sender.sendMessage("§a/parkour disable §fDisables an parkour");

				}else {
					sender.sendMessage("§cCommand Ussage: §f/dm help parkour <1|2>");
				}
			}else{
				sender.sendMessage("§cCommand Ussage: §f/dm help parkour <1>");
			}
		}else
		//parkour moderator
		if(sender.hasPermission("dm.parkour.moderator")) {
			if(args.length == 3) {
				if(args[2].equalsIgnoreCase("1")) {
					sender.sendMessage("§0========== §4DMinigames Help <Page> §21/1 §0==========");
					sender.sendMessage("§0=============== §4ADMIN §0================");
					sender.sendMessage("§6/dm help parkour <page> §4see the help page");
					sender.sendMessage("§a/parkour join <parkour> §fJoins the parkour");
					sender.sendMessage("§a/parkour leave §fleave the parkour");
					sender.sendMessage("§a/parkour list §fSee a full list of aviable parkours");
					sender.sendMessage("§a/parkour kick <playername> §fKicks a player from parkour");
					sender.sendMessage("§a/parkour enable <parkour> §fEnables an parkour");
					sender.sendMessage("§a/parkour disable §fDisables an parkour");


				}else {
					sender.sendMessage("§cCommand Ussage: §f/dm help parkour <1|2>");
				}
			}else{
				sender.sendMessage("§cCommand Ussage: §f/dm help parkour <1|2|3>");
			}
		}else {
			if(args.length == 2 && args[0].equalsIgnoreCase("help") && args[1].equalsIgnoreCase("parkour")) {
				//parkour User
				sender.sendMessage("§0========== §4DMinigames Help <Page> §21/1 §0==========");
				sender.sendMessage("§0=============== §4ADMIN §0================");
				sender.sendMessage("§6/dm help parkour <page> §4see the help page");
				sender.sendMessage("§a/parkour join <parkour> §fJoins the parkour");
				sender.sendMessage("§a/parkour leave §fleave the parkour");
				sender.sendMessage("§a/parkour list §fSee a full list of aviable parkours");

			}else {
				sender.sendMessage("§cUser Command Ussage: §f/dm help parkour");
			}

		}
	}

}
