package me.net.minigames.main.maincommands;

import me.net.minigames.main.helppages.HelpConsole;
import me.net.minigames.main.helppages.HelpMain;
import me.net.minigames.main.helppages.HelpPaintBall;
import me.net.minigames.main.helppages.HelpParkour;
import me.net.minigames.main.helppages.HelpSpleef;
import me.net.minigames.main.helppages.HelpTeamDeathMatch;
import me.net.minigames.main.helppages.HelpTntRun;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MCommandHelp {
	
	public static void MHelpCommand(CommandSender sender, String[] args) {
		if(sender instanceof Player) {


	
			
			/** PAINTBALL **/
			if(args.length > 1 && args[1].equalsIgnoreCase("paintball")) {
				HelpPaintBall.PaintballHelp(sender, args);
			}


			/** Spleef **/
			if(args.length > 1 && args[1].equalsIgnoreCase("spleef")) {
				HelpSpleef.SpleefHelp(sender, args);
			}
			
			/** TNT RUN **/
			if(args.length > 1 && args[1].equalsIgnoreCase("tntrun")) {
				HelpTntRun.tntrunhelp(sender, args);
			}
			/** Parkour **/
			if(args.length > 1 && args[1].equalsIgnoreCase("parkour")) {
				HelpParkour.parkourhelp(sender, args);
			}
			/** TDM **/
			
			if(args.length > 1 && args[1].equalsIgnoreCase("tdm")) {
				HelpTeamDeathMatch.TdmHelp(sender, args);
			}
			
			/** Main Help **/
			

			if(args.length < 2 && args[0].equalsIgnoreCase("help")) {
				HelpMain.MainHelp(sender, args);
			}
			
			/** CONSOLE HELP **/
		}else {
			
			HelpConsole.ConsoleHelp(sender, args);
			
		}
			
	}
	

}
