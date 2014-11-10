package me.net.minigames.events;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.teamdeathmatch.events.TKillEvent;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener{
	
	MainClass plugin;
	public DeathEvent (MainClass instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void Death(PlayerDeathEvent event) {
		if(event.getEntity() instanceof Player && event.getEntity().getKiller() instanceof Player) {
			Player death = event.getEntity();
			Player killer = event.getEntity().getKiller();
			
			if(TeamDeathMatchMain.TeamDeathMatchMain.pdata.plingame.containsKey(killer.getName()) && TeamDeathMatchMain.TeamDeathMatchMain.pdata.plingame.containsKey(death.getName())) {
				TKillEvent.KillMethod(killer, death, event);
				event.setDeathMessage("");
				event.getDrops().clear();
			}
		
			//Spleef
			if(SpleefMain.SpleefMain.pdata.plingame.containsKey(death.getName())) {
				SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(death.getName());
				arena.arenaph.LeavePlayer(death);
			}
			//parkour
			if(ParkourMain.ParkourMain.pdata.plingame.containsKey(death.getName())) {
				PArena arena = ParkourMain.ParkourMain.pdata.getPlayerArena(death.getName());
				arena.arenaph.leaveParkour(death);
			}
			//paintball
			if(PaintballMain.PaintBallMain.pdata.plingame.containsKey(death.getName())) {
				PAArenas arena = PaintballMain.PaintBallMain.pdata.getPlayerArena(death.getName());
				arena.arenaph.LeavePlayer(death);
			}
		}
		
	}

}
