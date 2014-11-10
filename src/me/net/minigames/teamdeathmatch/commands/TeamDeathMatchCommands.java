package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.Permissions.Permissions;
import me.net.minigames.Permissions.TDMPermissions;
import me.net.minigames.main.helppages.HelpTeamDeathMatch;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.command.CommandSender;

public class TeamDeathMatchCommands {

	public static void TCommands(String[] args, CommandSender sender) {
		if (args.length >= 1 && args[0].equalsIgnoreCase("create")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmcreate)) {
				TCommandCreate.create(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("setup")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmsetuppage)) {
				TCommandSetup.setuphelppages(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("check")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmcheck)) {
				TCommandCheck.check(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("delete")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmdelete)) {
				TCommandDelete.delete(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}

		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("disable")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmmod)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new TDMPermissions().tdmdisable)) {
				TCommandDisable.disablearena(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("enable")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmmod)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new TDMPermissions().tdmenable)) {
				TCommandEnable.enablearena(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}

		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("join")) {
			TCommandJoin.join(sender, args);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("kick")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmmod)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new TDMPermissions().tdmkick)) {
				TCommandKick.kick(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("leave")) {
			TCommandLeave.leave(sender, args);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("setlobby")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmsetlobby)) {
				TCommandSetLobby.setLobby(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}

		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("setspawn")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmsetspawn)) {
				TCommandSetSpawn.setSpawn(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}

		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("setspectate")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmsetspectate)) {
				TCommandSetSpectate.setSpectate(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}

		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("kit")) {
			TCommandKit.kit(sender, args);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("spectate")) {
			TCommandSpectate.spectate(sender, args);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("setcountdown")) {
			if (sender.hasPermission(new TDMPermissions().tdmadmin)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TDMPermissions().tdmsetcountdown)) {
				TCommandSetCountDown.setCountDown(sender, args);
			} else {
				TMessages.sendMessage(sender, TeamDeathMatchMessages.Permmss);
			}
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("list")) {
			TCommandArenas.Arenas(sender, args);
		}
		if (args.length >= 1 && args[0].equalsIgnoreCase("help")) {
			HelpTeamDeathMatch.TdmHelp(sender, args);
		}

		if (args.length >= 1 && args[0].equalsIgnoreCase("players")) {
			// TCommandPlayers.players(sender, args);
		}

		if (args.length >= 1 && args[0].equalsIgnoreCase("stats")) {
			// TCommandStats.stats(sender, args);
		}
	}

}
