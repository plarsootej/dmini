package me.net.minigames.teamdeathmatch.events;

import java.util.HashMap;

import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.handlers.TPlayerDataStore;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.scoreboards.TScoreBoard;


import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;


public class TKillEvent {
	
	public static HashMap<String, Integer> kills = new HashMap<String, Integer>();
	public static HashMap<String, Integer> deaths = new HashMap<String, Integer>();

	public static void KillMethod(Player killer, Player death, PlayerDeathEvent event) {
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
		
		 try {
	            Object nmsPlayer = death.getClass().getMethod("getHandle").invoke(death);
	            Object packet = Class.forName(nmsPlayer.getClass().getPackage().getName() + ".PacketPlayInClientCommand").newInstance();
	            Class<?> enumClass = Class.forName(nmsPlayer.getClass().getPackage().getName() + ".EnumClientCommand");
	 
	            for(Object ob : enumClass.getEnumConstants()){
	                if(ob.toString().equals("PERFORM_RESPAWN")){
	                    packet = packet.getClass().getConstructor(enumClass).newInstance(ob);
	                }
	            }
	 
	            Object con = nmsPlayer.getClass().getField("playerConnection").get(nmsPlayer);
	            con.getClass().getMethod("a", packet.getClass()).invoke(con, packet);
	        }
	        catch(Throwable t){
	            t.printStackTrace();
	        }
		 
		TScoreBoard.updatekdeathScoreBoard(death);
		TScoreBoard.updatekillerScoreBoard(killer);

        TArenas arena = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getPlayerArena(death.getName());
		 if(TPlayerDataStore.blueteam.contains(death.getName())) {
			 death.teleport(arena.getBlueSpawn());
			 death.sendMessage("§aYou have been killed by: §6" + killer.getName());
		 }
		 if(TPlayerDataStore.redteam.contains(death.getName())) {
			 death.teleport(arena.getRedSpawn());
			 death.sendMessage("§aYou have been killed by: §6" + killer.getName());
			 
		 }
		 
		 killer.sendMessage("§aYou killed §6" + death.getName());
        
        
	}

}
