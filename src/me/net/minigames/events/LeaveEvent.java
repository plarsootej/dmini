package me.net.minigames.events;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener{
	
	MainClass plugin;
	public LeaveEvent (MainClass instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		
		//Spleef
		if(SpleefMain.SpleefMain.pdata.plingame.containsKey(player.getName())) {
			SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(player.getName());
			arena.arenaph.LeavePlayer(player);
		}
		//parkour
		if(ParkourMain.ParkourMain.pdata.plingame.containsKey(player.getName())) {
			PArena arena = ParkourMain.ParkourMain.pdata.getPlayerArena(player.getName());
			arena.arenaph.leaveParkour(player);
		}
		//team deathmatch
		if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.plingame.containsKey(player.getName())) {
			TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getPlayerArena(player.getName());
			arena.arenaph.LeavePlayer(player, true);
		}
		//paintball
		if(PaintballMain.PaintBallMain.pdata.plingame.containsKey(player.getName())) {
			PAArenas arena = PaintballMain.PaintBallMain.pdata.getPlayerArena(player.getName());
			arena.arenaph.LeavePlayer(player);
		}
		//tnt run
		if(TNTRunMain.TNTRunMain.pdata.plingame.containsKey(player.getName())) {
			TNTArena arena = TNTRunMain.TNTRunMain.pdata.getPlayerArena(player.getName());
			arena.arenaph.LeavePlayer(player, true);
		}
	}

}
