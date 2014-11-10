package me.net.minigames.main.maincommands;



import me.net.minigames.Permissions.Permissions;

import org.bukkit.command.CommandSender;

public class MainCommands {
	
	public static void MCommands(String[] args, CommandSender sender) {
		if(args.length> 0 && args[0].equalsIgnoreCase("reload")) {
			if(sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mreload))
			MCommandReload.MReload(args, sender);
		}
		if(args.length >= 1 && args[0].equalsIgnoreCase("help")) {
			MCommandHelp.MHelpCommand(sender, args);
		}
		if(args.length >= 1 && args[0].equalsIgnoreCase("checkversion")) {
			//MCommandCheckVersion.CheckVersion(sender, args);
		}
		
		else {
			sender.sendMessage("§cWhrong Command Ussage: §f/dm help");
		}
	}

}
