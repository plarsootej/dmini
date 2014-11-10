package me.net.minigames.tntrun.commands;

import me.net.minigames.Permissions.Permissions;
import me.net.minigames.Permissions.TNTRunPermissions;
import me.net.minigames.main.helppages.HelpTntRun;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;
import me.net.minigames.tntrun.methods.TNTSetupHelpPage;

import org.bukkit.command.CommandSender;

public class TNTRunCommands {


	public static void TNTCommands(CommandSender sender, String[] args) {
		
		/** Wand Command **/
		if (args.length == 1 && args[0].equalsIgnoreCase("wand")) {
			if(sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunwand)) {
				
				TNTCommandWand.WandCommand(sender);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
			
		}
		
		/** Create Command **/
		if(args.length >= 1 && args[0].equalsIgnoreCase("create")) {
			if(sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntruncreate)) {
				TNTCommandCreate.TNTCreate(sender, args);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
			
		}
		
		/** Create Floor Command **/
		if(args.length >= 1 && args[0].equalsIgnoreCase("createfloor")) {
			if(sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntruncreatefloor)) {
				TNTCommandCreateFloor.TNTCreateFloor(sender, args);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
		}
		
		/** Create Lose Command **/
		if(args.length >= 1 && args[0].equalsIgnoreCase("createlose")) {
			if(sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntruncreatelose)) {
				TNTCommandCreateLose.CreateLose(sender, args);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
		}
		
		/** Setup Help page command **/
		if(args.length >= 1 && args[0].equalsIgnoreCase("setup")) {
			if(sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunsetuppage)) {
				TNTSetupHelpPage.TNTSetupHelp(sender);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
		}

		/** Setlobby Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("setlobby")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunsetlobby)) {
				TNTCommandSetLobby.CreateLobby(sender, args);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
		}
		
		
		/** Setspawn Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("setspawn")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunsetspawn)) {
				TNTCommandSetSpawn.CreateSpawn(sender, args);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
		}
		
		/** Setspectate Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("setspectate")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunsetspectate)) {
				TNTCommandSetSpectate.CreateSpectate(sender, args);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
		}
		
		/** Join Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("join")) {
			TNTCommandJoin.JoinTNT(sender, args);
		}
		
		/** Leave Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("leave")) {
			TNTCommandLeave.LeaveTNT(sender, args);
		}
		
		/** Spectate Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("spectate")) {
			TNTCommandSpectate.SpectateTNT(sender, args);
		}
		
		/** Delete Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("delete")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrundelete)) {
				TNTCommandDelete.DeleteArena(sender, args);
			} else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
		}
		
		/** Repair Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("repair")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunmod)
					|| sender.hasPermission(new TNTRunPermissions().tntruncreatelose)) {
				TNTCommandRepair.RepairArena(sender, args);
			} else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
		}
		
		/** List Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("list")) {
			TNTCommandArenas.CommandArenas(sender, args);
		}
		
		/** help Command **/
		if (args.length >= 1 && args[0].equalsIgnoreCase("help")) {
			HelpTntRun.tntrunhelp(sender, args);
		}
		
		/** Enable Command **/
		if(args.length >= 1 && args[0].equalsIgnoreCase("enable")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunmod)
					|| sender.hasPermission(new TNTRunPermissions().tntrunenable)) {
				
				TNTCommandEnable.enable(sender, args);	
			} else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
			
		}
		
		/** Disable Command **/
		if(args.length >= 1 && args[0].equalsIgnoreCase("disable")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunmod)
					|| sender.hasPermission(new TNTRunPermissions().tntrundisable)) {
				TNTCommandDisable.disable(sender, args);
			} else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
			
		}
		
		/** Kick Command **/
		if(args.length >= 1 && args[0].equalsIgnoreCase("kick")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunmod)
					|| sender.hasPermission(new TNTRunPermissions().tntrunkick)) {
				TNTCommandKick.kick(sender, args);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
			
		}
		
		/** Check Command **/
		if(args.length >= 1 && args[0].equalsIgnoreCase("check")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunmod)
					|| sender.hasPermission(new TNTRunPermissions().tntruncheck)) {
				TNTCommandCheck.check(sender, args);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
			
		}
		
		/** Set Countdown Command **/
		if(args.length >= 1 && args[0].equalsIgnoreCase("setcountdown")) {
			if (sender.hasPermission(new Permissions().madmin)
					|| sender.hasPermission(new Permissions().mmoderator)
					|| sender.hasPermission(new TNTRunPermissions().tntrunadmin)
					|| sender.hasPermission(new TNTRunPermissions().tntrunmod)
					|| sender.hasPermission(new TNTRunPermissions().tntrunsetcountdown)) {
				TNTSetCountdown.setcountdown(sender, args);
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.Permmss);
			}
		}
	}

}
