package me.net.minigames.main.maincommands;

import me.net.minigames.main.handlers.ConfigHandler;

import org.bukkit.command.CommandSender;

public class MCommandReload {
	
	public static void MReload(String[] args, CommandSender sender) {
		if(args.length == 1) {
			reloadAllConfigs(sender);
		}else
		if(args.length == 2 && args[1].equalsIgnoreCase("tdm") || args[1].equalsIgnoreCase("paintball")) {
			reloadConfig(args[1], sender);
		}else {
			sender.sendMessage("§cCommandUssage:§f/dm reload <tdm|paintball>");
		}
	}
	
	public static void reloadAllConfigs(CommandSender sender) {
		ConfigHandler.Paintball.reloadConfig();
		ConfigHandler.MainTDM.reloadConfig();
		ConfigHandler.TNTMainConfig.reloadConfig();
		ConfigHandler.MainSpleef.reloadConfig();
		ConfigHandler.ParkourMain.reloadConfig();
		sender.sendMessage("§2All Configs Succesfull reloaded");
		sender.sendMessage("§2To reload the arena's or parkours config's you need to reload the server");
	}
	
	public static void reloadConfig(String args, CommandSender sender) {
		if(args.equalsIgnoreCase("tdm")) {
			ConfigHandler.MainTDM.reloadConfig();
			sender.sendMessage("§2Team Death Match Config Succesfully reloaded");
			sender.sendMessage("§2To reload the team deathmatch arena's config's you need to reload the server");
		}
		if(args.equalsIgnoreCase("paintball")) {
			ConfigHandler.Paintball.reloadConfig();
			sender.sendMessage("§2Paintball Config Succesfully reloaded");
		}
		if(args.equalsIgnoreCase("spleef")) {
			ConfigHandler.MainSpleef.reloadConfig();
			sender.sendMessage("§2Spleef Config succesfully reloaded");
			sender.sendMessage("§2To reload the arena's config's you need to reload the server");
		}
		if(args.equalsIgnoreCase("tnt") || args.equalsIgnoreCase("tntrun")) {
			ConfigHandler.TNTMainConfig.reloadConfig();
			sender.sendMessage("§2TNT Run config succesfully reloaded");
			sender.sendMessage("§2To reload the tnt run arena's config's you need to reload the server");
		}
		if(args.equalsIgnoreCase("parkour") || args.equalsIgnoreCase("pk")) {
			ConfigHandler.ParkourMain.reloadConfig();
			sender.sendMessage("§2Parkour Config succesfully reloaded");
			sender.sendMessage("§2To reload the parkour's config's you need to reload the server");
		}
	}

}
