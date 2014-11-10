package me.net.minigames.spleef.commands;

import me.net.minigames.Permissions.Permissions;
import me.net.minigames.Permissions.SpleefPermissions;
import me.net.minigames.main.helppages.HelpSpleef;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;

import org.bukkit.command.CommandSender;

public class SpleefCommands {

	public static void SCommands(CommandSender sender, String[] args) {
		if (args.length == 1 && args[0].equalsIgnoreCase("wand")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefwand)) {
				SCommandWand.WandCommand(sender);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("create")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefcreate)) {
				SCommandCreate.SpleefCreate(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("join")) {
			SCommandJoin.Join(sender, args);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("setspawn")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefsetspawn)) {
				SCommandSetSpawn.SetSpawn(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("createfloor")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefcreatefloor)) {
				SCommandCreateFloor.SpleefCreateFloor(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("setloselevel")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefcreatelose)) {
				SCommandCreateLose.SetLoseLevel(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("check")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefcheck)) {
				SCommandCheck.CheckCommand(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("setlobby")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefsetlobby)) {
				SCommandSetLobby.SetLobby(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("delete")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefdelete)) {
				SCommandDelete.DeleteArena(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("setspectate")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefsetspectate)) {
				SCommandSetSpectate.SetSpectate(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("spectate")) {
			SCommandSpectate.TeleportSpectate(sender, args);
		}
		if (args.length == 1 && args[0].equalsIgnoreCase("leave")) {
			SCommandLeave.LeaveSpleef(sender);
		}
		
		
		if (args.length >= 1 && args[0].equalsIgnoreCase("enable")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new SpleefPermissions().spleefmod)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new SpleefPermissions().spleefenable)) {
				SCommandEnable.EnableArena(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("disable")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new SpleefPermissions().spleefmod)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefdisable)) {
				SCommandDisable.DisableArena(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("kick")) {
			if (sender.hasPermission(new SpleefPermissions().spleefmod)
					|| sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefkick)) {
				SCommandKick.KickCommand(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("restore")) {
			if (sender.hasPermission(new SpleefPermissions().spleefmod)
					|| sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new SpleefPermissions().spleefrestore)) {
				SCommandRestore.RestoreCommand(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length == 1 && args[0].equalsIgnoreCase("setup")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefsetuppage)) {
				SCommandSetup.SetupCommand(sender);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("help")) {
			HelpSpleef.SpleefHelp(sender, args);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("list")) {
			SCommandArenas.arenas(sender, args);
		}
		
		if(args.length >= 1 && args[0].equalsIgnoreCase("setcoundown")) {
			if (sender.hasPermission(new SpleefPermissions().spleefadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new SpleefPermissions().spleefsetcountdown)) {
				SCommandSetCountDown.setcountdown(sender, args);
			} else {
				Messages.sendMessage(sender, SpleefMessages.Permmss);
			}
		}

	}

}
