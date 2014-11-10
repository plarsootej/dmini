package me.net.minigames.main.commands;

import me.net.minigames.main.MainClass;
import me.net.minigames.main.handlers.DMCommand;
import me.net.minigames.main.maincommands.MainCommands;
import me.net.minigames.paintball.commands.PaintBallCommands;
import me.net.minigames.parkour.commands.ParkourCommands;
import me.net.minigames.spleef.commands.SpleefCommands;
import me.net.minigames.teamdeathmatch.commands.TeamDeathMatchCommands;
import me.net.minigames.tntrun.commands.TNTRunCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements DMCommand, CommandExecutor{
	
	MainClass plugin;
	public Commands (MainClass instance) {
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String cl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("paintball") || cmd.getName().equalsIgnoreCase("pb")) {
			PaintBallCommands.PCommands(args, s);
		}
		if(cmd.getName().equalsIgnoreCase("teamdeathmatch") || cmd.getName().equalsIgnoreCase("tdm")) {
			TeamDeathMatchCommands.TCommands(args, s);
		}
		if(cmd.getName().equalsIgnoreCase("dm") || cmd.getName().equalsIgnoreCase("dminigames")) {
			MainCommands.MCommands(args, s);
		}
		if(cmd.getName().equalsIgnoreCase("s") || cmd.getName().equalsIgnoreCase("spleef")) {
			SpleefCommands.SCommands(s, args);
		}
		if(cmd.getName().equalsIgnoreCase("tnt") || cmd.getName().equalsIgnoreCase("tntrun")) {
			TNTRunCommands.TNTCommands(s, args);
		}
		if(cmd.getName().equalsIgnoreCase("pk") || cmd.getName().equalsIgnoreCase("parkour")) {
			ParkourCommands.PCommands(s, args);
		}
		return false;
	}

}
