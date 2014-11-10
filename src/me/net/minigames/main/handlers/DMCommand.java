package me.net.minigames.main.handlers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public interface DMCommand extends CommandExecutor{
	
	
	public boolean onCommand(CommandSender s, Command cmd, String cl,String[] args);


}
