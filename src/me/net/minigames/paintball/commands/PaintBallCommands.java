package me.net.minigames.paintball.commands;

import me.net.minigames.Permissions.PaintballPermissions;
import me.net.minigames.Permissions.Permissions;
import me.net.minigames.main.MainClass;
import me.net.minigames.main.helppages.HelpPaintBall;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;

import org.bukkit.command.CommandSender;

public class PaintBallCommands {

	MainClass plugin;

	public PaintBallCommands(MainClass instance) {
		plugin = instance;
	}

	public static void PCommands(String[] args, CommandSender sender) {
		
		/** Setspawn **/
		if (args.length > 0 && args[0].equalsIgnoreCase("setspawn")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballsetspawn)
					|| sender.hasPermission(new Permissions().madmin)) {
				
				PaCommandSetSpawn.PSetspawnCommand(args, sender);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}
		}
		
		/** Setspectate **/
		if (args.length > 0 && args[0].equalsIgnoreCase("setspectate")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballsetspectate)
					|| sender.hasPermission(new Permissions().madmin)) {
				
				PaCommandSetSpectate.PSetSpectateCommand(args, sender);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}
		}
		
		/** Setlobby **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("setlobby")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballsetlobby)
					|| sender.hasPermission(new Permissions().madmin)) {
				
				PaCommandSetLobby.lobby(sender, args);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}

		}
		
		/** Create **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("create")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballcreate)
					|| sender.hasPermission(new Permissions().madmin)) {
				
				PaCommandCreate.Create(sender, args);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}

		}
		
		/** Setup help pages **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("setup")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballsetuppage)
					|| sender.hasPermission(new Permissions().madmin)) {
				
				PaCommandSetup.setup(sender, args);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}

		}
		
		/** Check **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("check")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballcheck)
					|| sender.hasPermission(new Permissions().madmin)) {
					
				
				PaCommandCheck.check(sender, args);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}

		}
		
		/** Delete **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("delete")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballdelete)
					|| sender.hasPermission(new Permissions().madmin)) {
				
				PaCommandDelete.delete(sender, args);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}

		}
		
		/** Disable **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("disable")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballmod)
					|| sender.hasPermission(new PaintballPermissions().paintballdisable)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)) {
				
				PaCommandDisable.disable(sender, args);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}

		}
		
		/** Enable **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("enable")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballmod)
					|| sender.hasPermission(new PaintballPermissions().paintballenable)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)) {
				
				PaCommandEnable.enable(sender, args);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}

		}
		
		/** Kick **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("kick")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballmod)
					|| sender.hasPermission(new PaintballPermissions().paintballkick)
					|| sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)) {
				
				PaCommandKick.kick(sender, args);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}
			
		}
		
		/** setcountdown **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("setcountdown")) {
			if (sender.hasPermission(new PaintballPermissions().paintballadmin)
					|| sender.hasPermission(new PaintballPermissions().paintballsetcountdown)
					|| sender.hasPermission(new Permissions().madmin)) {
				
				PaCommandSetCountDown.setCountDown(sender, args);
			} else {
				PaMessages.sendMessage(sender, PaintballMessages.Permmss);
			}
			
		}
		
		/** Join **/
		if (args.length > 0 && args[0].equalsIgnoreCase("join")) {
			PaCommandJoin.Pjoin(args, sender);
		}
		
		/** Leave **/
		if (args.length == 1 && args[0].equalsIgnoreCase("leave")) {
			PaCommandLeave.Pleave(args, sender);
		}
		
		/** Spectate **/
		if (args.length == 2 && args[0].equalsIgnoreCase("spectate")) {
			PaCommandSpectate.Pspectate(args, sender);
		}
		
		/** Arenas **/
		if (args.length == 1 && args[0].equalsIgnoreCase("arenaes")) {
			PaCommandArenas.CommandArenas(sender, args);
		}
		
		/** Help **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("help")) {
			HelpPaintBall.PaintballHelp(sender, args);
		}
	}
}
