package me.net.minigames.paintball.events;

import java.util.HashMap;

import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.handlers.PAPlayerDataStore;
import me.net.minigames.paintball.scoreboards.PaScoreBoard;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PaDamage {
	
	public static HashMap<String, Integer> kills = new HashMap<String, Integer>();
	public static HashMap<String, Integer> deaths = new HashMap<String, Integer>();
	public static HashMap<String, Integer> killsbdeath = new HashMap<String, Integer>();
	public static HashMap<String, Integer> hits = new HashMap<String, Integer>();

	public static void Damage(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Snowball)
	    {
            Player killer = (Player) ((Snowball)event.getDamager()).getShooter();
			Player death = (Player) event.getEntity();
			if(PaintballMain.PaintBallMain.pdata.plingame.containsKey(death.getName()) && PaintballMain.PaintBallMain.pdata.plingame.containsKey(killer.getName())) {
				KillMethod(killer, death);
			}
	    }
		
	}
	public static void KillMethod(Player killer, Player death) {
		
		if(hits.containsKey(killer.getName())) {
			int oldkills = hits.get(killer.getName());
			int newkills = oldkills + 1;
			hits.put(killer.getName(), newkills);	
		}else {
			hits.put(killer.getName(), 1);
		}
		
		PAArenas arena = PaintballMain.PaintBallMain.pdata.getPlayerArena(death.getName());
		
		int killsbeforedeath = ConfigHandler.Paintball.getInt("Kills-Before-Death");
		if(killsbdeath.containsKey(death.getName())) {
			int oldhits = killsbdeath.get(death.getName());
			if(oldhits + 1 == killsbeforedeath ) {
				//death
				 if(PAPlayerDataStore.blueteam.contains(death.getName())) {
					 death.teleport(arena.getBlueSpawn());
					 death.sendMessage("§aYou have been killed by: §6" + killer.getName());
					 killer.sendMessage("§aYou killed §6" + death.getName());
					 killsbdeath.remove(death.getName());
				 }
				 if(PAPlayerDataStore.redteam.contains(death.getName())) {
					 death.teleport(arena.getRedSpawn());
					 death.sendMessage("§aYou have been killed by: §6" + killer.getName());
					 killer.sendMessage("§aYou killed §6" + death.getName());
					 killsbdeath.remove(death.getName());
					 
					 
				 }
				 
				if(kills.containsKey(killer.getName())) {
					int oldkills = kills.get(killer.getName());
					int newkills = oldkills + 1;
					kills.put(killer.getName(), newkills);	
				}else {
					kills.put(killer.getName(), 1);
				}
				if(deaths.containsKey(death.getName())) {
					int olddeaths = deaths.get(death.getName());
					int newdeaths = olddeaths + 1;
					deaths.put(death.getName(), newdeaths);	
				}else {
					deaths.put(death.getName(), 1);
				}
					
				 killsbdeath.remove(death.getName());
				 
				
			}else {
				int newhits = oldhits + 1;
				death.sendMessage("§aYou have been hit by §6" + killer.getName() + "§f [" + newhits + "/" + killsbeforedeath + "] §a Hits");
				killer.sendMessage("§aYou hit §6"+ death.getName() + "§f [" + newhits + "/" + killsbeforedeath + "] §a Hits");
				killsbdeath.put(death.getName(), newhits);
			}
		}else 
			if(!killsbdeath.containsKey(death.getName())) {
			killsbdeath.put(death.getName(), 1);
			death.sendMessage("§aYou have been hit by §6" + killer.getName() + "§f [" + 1 + "/" + killsbeforedeath + "] §a Hits");
			killer.sendMessage("§aYou hit §6"+ death.getName() + "§f [" + 1 + "/" + killsbeforedeath + "] §a Hits");
		}
		PaScoreBoard.updatekdeathScoreBoard(death);
		PaScoreBoard.updatekillerScoreBoard(killer);
        
	}
	
	

}
