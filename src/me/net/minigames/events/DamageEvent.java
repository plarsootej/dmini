package me.net.minigames.events;

import java.util.HashSet;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.events.PaDamage;
import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.handlers.TPlayerDataStore;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageEvent implements Listener{

	MainClass plugin;
	public DamageEvent (MainClass instance) {
		plugin = instance;
	}
	
	
	
	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) 
	{
		
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Snowball)
	    {
	        if(((Snowball)event.getDamager()).getShooter() instanceof Player)
	        {
	        	//Paintball shooting event
	        	PaDamage.Damage(event);
	        }    
        }
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			
			
			
			//canceling spleef ingame damaged event
			for (SArena arena : SpleefMain.SpleefMain.pdata.getArenas())
	        {
				 for (String player : new HashSet<String>(SpleefMain.SpleefMain.pdata.getArenaPlayers(arena)))
	             {
					 Player player2 = Bukkit.getServer().getPlayerExact(player);
					 if(SpleefMain.SpleefMain.pdata.plingame.containsKey(player2.getName())) {
						 event.setCancelled(true);
					 }
	             }
	        }
			
			//canceling parkour ingame event
			for (PArena arena : ParkourMain.ParkourMain.pdata.getArenas())
	        {
				 for (String player : new HashSet<String>(ParkourMain.ParkourMain.pdata.getArenaPlayers(arena)))
	             {
					 Player player2 = Bukkit.getServer().getPlayerExact(player);
					 if(ParkourMain.ParkourMain.pdata.plingame.containsKey(player2.getName())) {
						 event.setCancelled(true);
					 }
	             }
	        }
			//canceling team deathmatch inlobby event
			for(TArenas arena : TeamDeathMatchMain.TeamDeathMatchMain.pdata.getArenas()) {
				 for (String player : new HashSet<String>(TeamDeathMatchMain.TeamDeathMatchMain.pdata.getLobbyPlayers(arena)))
	             {
					 if(TPlayerDataStore.lobbied.contains(player)) {
						 event.setCancelled(true);
					 }
	             }
			}
			//canceling tntrun ingame event
			
			for(TNTArena arena : TNTRunMain.TNTRunMain.pdata.getArenas()) {
				for(String player : new HashSet<String>(TNTRunMain.TNTRunMain.pdata.getArenaPlayers(arena)))
				{
					if(TNTRunMain.TNTRunMain.pdata.plingame.containsKey(player)) {
						event.setCancelled(true);
					}
				}
			}
			
			
			
		}
	}
}
