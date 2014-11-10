package me.net.minigames.main.handlers;

import org.bukkit.command.CommandExecutor;

import me.net.minigames.main.MainClass;
import me.net.minigames.main.commands.Commands;

public class CommandHandler {
	
	MainClass plugin;
	public CommandHandler (MainClass instance) {
		plugin = instance;
	}
	
	public void ExecuteCommands() {
		
		CommandExecutor commands = new Commands(plugin);
		plugin.getCommand("paintball").setExecutor(commands);
		plugin.getCommand("pb").setExecutor(commands);
		plugin.getCommand("teamdeathmatch").setExecutor(commands);
		plugin.getCommand("tdm").setExecutor(commands);
		plugin.getCommand("dm").setExecutor(commands);
		plugin.getCommand("dminigames").setExecutor(commands);
		plugin.getCommand("spleef").setExecutor(commands);
		plugin.getCommand("s").setExecutor(commands);
		plugin.getCommand("tntrun").setExecutor(commands);
		plugin.getCommand("tnt").setExecutor(commands);
		plugin.getCommand("parkour").setExecutor(commands);
		plugin.getCommand("pk").setExecutor(commands);

		
	}
	

}
