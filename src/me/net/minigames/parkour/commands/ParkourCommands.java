package me.net.minigames.parkour.commands;

import me.net.minigames.Permissions.ParkourPermissions;
import me.net.minigames.Permissions.Permissions;
import me.net.minigames.main.helppages.HelpParkour;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.command.CommandSender;

public class ParkourCommands {

	public static void PCommands(CommandSender sender, String[] args) {
		if (args.length >= 1 && args[0].equalsIgnoreCase("create")) {
			if (sender.hasPermission(new ParkourPermissions().parkadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new ParkourPermissions().parkcreate)) {
				PCommandCreate.ParkourCreate(sender, args);
			} else {
				Messages.sendMessage(sender, ParkourMessages.Permmss);
			}
		}
		/**
		if (args.length >= 1 && args[0].equalsIgnoreCase("addcheckpoint")) {
			if (sender.hasPermission(new ParkourPermissions().parkadmin)
					|| sender.hasPermission(new Permissions().madmin)) {
				PCommandSetCheckPoint.PSetCheck(sender, args);
			} else {
				Messages.sendMessage(sender, ParkourMessages.Permmss);
			}
		}
		**/
		if (args.length >= 1 && args[0].equalsIgnoreCase("setspawn")) {
			if (sender.hasPermission(new ParkourPermissions().parkadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new ParkourPermissions().parksetspawn)) {
				PCommandSetSpawn.PSetSpawn(sender, args);
			} else {
				Messages.sendMessage(sender, ParkourMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("join")) {
			PCommandJoin.Join(sender, args);
		}
		if (args.length == 1 && args[0].equalsIgnoreCase("leave")) {
			PCommandLeave.leave(sender);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("help")) {
			HelpParkour.parkourhelp(sender, args);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("kick")) {
			if (sender.hasPermission(new ParkourPermissions().parkmod)
					|| sender.hasPermission(new ParkourPermissions().parkadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new ParkourPermissions().parkkick)) {
				PCommandKick.kick(sender, args);
			} else {
				Messages.sendMessage(sender, ParkourMessages.Permmss);
			}

		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("list")) {
			PCommandList.Parkours(sender, args);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("enable")) {
			if (sender.hasPermission(new ParkourPermissions().parkmod)
					|| sender.hasPermission(new ParkourPermissions().parkadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new ParkourPermissions().parkenable)) {
				PCommandEnable.enable(sender, args);
			} else {
				Messages.sendMessage(sender, ParkourMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("disable")) {
			if (sender.hasPermission(new ParkourPermissions().parkmod)
					|| sender.hasPermission(new ParkourPermissions().parkadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new ParkourPermissions().parkdisable)) {
				PCommandDisable.disable(sender, args);
			} else {
				Messages.sendMessage(sender, ParkourMessages.Permmss);
			}

		}

	}

}
