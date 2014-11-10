package me.net.minigames.main.methods;

import java.util.HashSet;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.messages.PaMessages;
import me.net.minigames.paintball.messages.PaintballMessages;
import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.ParkourMessages;
import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;
import me.net.minigames.spleef.methods.SCreateFloor;
import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;
import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
public class DisableLeave {
	
	MainClass plugin;
	public DisableLeave (MainClass instance) {
		plugin = instance;
	}
	
	/**
	 * When the plugin disables the plugin deletes all the players from the lists, Give's them the're inventory back and if there is a spectate location they are getting
	 * teleported to the spectate location.
	 */

	public void LeaveOnDisable() {
		
		/** paintball **/
		for (PAArenas arena : PaintballMain.PaintBallMain.pdata.getArenas())
        {
			 for (String player : new HashSet<String>(PaintballMain.PaintBallMain.pdata.getArenaPlayers(arena)))
             {
				 Player p = Bukkit.getPlayerExact(player);
                 arena.arenaph.LeavePlayer(p);
                 PaMessages.sendMessage(p, PaintballMessages.Disabling);
             }
        }
		
		/** Team DeathMatch **/
		for (TArenas arena : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenas())
        {
			 for (String player : new HashSet<String>(TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenaPlayers(arena)))
             {
				 Player p = Bukkit.getPlayerExact(player);
                 arena.arenaph.LeaveOnDisable(p);
                 TMessages.sendMessage(p, TeamDeathMatchMessages.Disabling);
             }
        }
		
	
		/** TNT Run Leave on disable**/
		for (TNTArena arena : TNTRunMain.TNTRunMain.pdata.getArenas())
        {
			 for (String player : new HashSet<String>(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena)))
             {
				 Player p = Bukkit.getPlayerExact(player);
                 arena.arenaph.leaveOnDisable(p);
                 
             }
        }
		/** Spleef **/
		for (SArena arena : SpleefMain.SpleefMain.pdata.getArenas())
        {
			 for (String player : new HashSet<String>(SpleefMain.SpleefMain.pdata.getArenaPlayers(arena)))
             {
				 Player p = Bukkit.getPlayerExact(player);
                 arena.arenaph.LeavePlayer(p);
                 Messages.sendMessage(p, SpleefMessages.Disabling);
                 String arenaname = arena.getArenaName();
                 SCreateFloor.CreateFloor(arenaname);
                 arena.setRunning(false);
             }
        }
		/** Parkour **/
		for (PArena arena : ParkourMain.ParkourMain.pdata.getArenas())
        {
			 for (String player : new HashSet<String>(ParkourMain.ParkourMain.pdata.getArenaPlayers(arena)))
             {
				 Player p = Bukkit.getPlayerExact(player);
                 arena.arenaph.leaveParkour(p);
                 me.net.minigames.parkour.messages.Messages.sendMessage(p, ParkourMessages.Disabling);
             }
        }
		
		
		
		
	}
	

}
