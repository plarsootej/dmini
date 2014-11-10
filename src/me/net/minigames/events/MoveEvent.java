package me.net.minigames.events;



import me.net.minigames.main.MainClass;
import me.net.minigames.parkour.events.ParkourMoveEvent;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.spleef.events.SMoveEvent;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.tntrun.events.TNTMoveEventFloor;
import me.net.minigames.tntrun.events.TNTMoveEventLose;
import me.net.minigames.tntrun.handlers.TNTPlayerDataStore;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener{
	
	MainClass plugin;
	public MoveEvent (MainClass instance) {
		plugin = instance;
	}
	

	@EventHandler
	public void onMoveEvent(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if(SpleefMain.SpleefMain.pdata.plingame.containsKey(player.getName())) {
			SMoveEvent.SpleefMoveEvent(event);
		}
		
		if(ParkourMain.ParkourMain.pdata.plingame.containsKey(player.getName())) {
			ParkourMoveEvent.MoveEvent(event, player);
		}
		if(TNTPlayerDataStore.playing.contains(player.getName())) {
			TNTMoveEventLose.MoveEventLose(event);
			TNTMoveEventFloor.MoveEventFloor(event);
		}
		
	}

}
