package me.net.minigames.teamdeathmatch.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class TPlayerDataStore {
	
	public HashMap<String, TArenas> plingame = new HashMap<String, TArenas>();
    public HashMap<String, TArenas> arenanames = new HashMap<String, TArenas>();
    static HashMap<TArenas, HashSet<String>> arenaplayers = new HashMap<TArenas, HashSet<String>>();
    static HashMap<TArenas, HashSet<String>> lobbyplayers = new HashMap<TArenas, HashSet<String>>();
    static HashMap<String, String> pteam = new HashMap<String, String>();
    public static List<String> redteam = new ArrayList<String>();
    public static List<String> blueteam = new ArrayList<String>();
    public static List<String> lobbied = new ArrayList<String>();
	
    public void setPlayerArena(String player, TArenas arena)
    {
            plingame.put(player, arena);
            arenaplayers.get(arena).add(player);
    }

    public TArenas getPlayerArena(String player)
    {
            return plingame.get(player);
    }
    public void setLobby(String player, TArenas arena) {
    	lobbyplayers.get(arena).add(player);
    	lobbied.add(player);
    }
    
    public void removePlayerFromLobby(String player) {
    	TArenas arena = plingame.get(player);
    	lobbyplayers.get(arena).remove(player);
    	lobbied.remove(player);
    }
    
    public HashSet<String> getLobbyPlayers(TArenas arena) {
    	return lobbyplayers.get(arena);
    }
    public void setPlayerTeam(String player, String team) {
    	pteam.put(player, team);
    	if(team.equalsIgnoreCase("blue")) {
    		blueteam.add(player);
    	}
    	if(team.equalsIgnoreCase("red")) {
    		redteam.add(player);
    	}
    }
    public String getPlayerTeam(String player) {
    	return pteam.get(player);
    }
    /*
    public HashSet<String> getTeamPlayers(String team) {
    	return teamplayers.get(team);
    }
    */
    
    public HashSet<String> getArenaPlayers(TArenas arena)
    {
            return arenaplayers.get(arena);
    }
	
    public void putArenaInHashMap(TArenas arena)
    {
            arenanames.put(arena.getArenaName(), arena);
            arenaplayers.put(arena, new HashSet<String>());
            lobbyplayers.put(arena, new HashSet<String>());
    }
    
    public TArenas getArenaByName(String name)
    {
            return arenanames.get(name);
            
    }

    
    public Set<TArenas> getArenas()
    {
            return arenaplayers.keySet();
    }
    
	public void removePlayerFromArena(String player){
        TArenas arena = plingame.get(player);
        arenaplayers.get(arena).remove(player);
        plingame.remove(player);
        pteam.remove(player);
        if(lobbied.contains(player)) {
        	lobbied.remove(player);
        }
        Player p = Bukkit.getPlayerExact(player);
        if(redteam.contains(p) || redteam.contains(p.getName())) {
        	redteam.remove(p);
        	redteam.remove(p.getName());
        }
        if(blueteam.contains(p) || blueteam.contains(p.getName())) {
        	blueteam.remove(p);
        	blueteam.remove(p.getName());
        }
	}
	public void removeArenaFromHashMap(TArenas arena) {
        arenanames.remove(arena.getArenaName());
        arenaplayers.remove(arena);
    }
    
    private static HashMap<String, GameMode> pgamemode = new HashMap<String, GameMode>();
    private static HashMap<String, ItemStack[]> parmor = new HashMap<String, ItemStack[]>();
    private static HashMap<String, ItemStack[]> pinv = new HashMap<String, ItemStack[]>();
    private static HashMap<String, Location> ploc = new HashMap<String, Location>();
    private static HashMap<String, Integer> plhunger = new HashMap<String, Integer>();
    
	public static void storePlayerInventory(Player player) {
    	
    	PlayerInventory plinv = player.getInventory();
    	String playername = player.getName();
    	
        pinv.put(playername, plinv.getContents());
        plinv.clear();
        
    }
	
	public static void storePlayerArmor(Player player) {
		PlayerInventory plinv = player.getInventory();
		String playername = player.getName();
		
		parmor.put(playername, plinv.getArmorContents());
	}
	
	public static void storePlayerGameMode(Player player) {
		String playername = player.getName();
		pgamemode.put(playername, player.getGameMode());
		player.setGameMode(GameMode.SURVIVAL);
	}
	
	public static void storePlayerLocation(Player player) {
		String playername = player.getName();
		ploc.put(playername, player.getLocation());
	}
	
	public static void storePlayerHunger(Player player) {
		String playername = player.getName();
		plhunger.put(playername, player.getFoodLevel());
		player.setFoodLevel(20);
	}
	
	public static void restorePlayerInventory(Player player) {
		player.getInventory().setContents(pinv.get(player.getName()));
		pinv.remove(player.getName());
	}
	
	public static void restoreArmor(Player player) {
		player.getInventory().setArmorContents(parmor.get(player.getName()));
		parmor.remove(player.getName());
	}
	
	public static void restoreGameMode(Player player) {
		player.setGameMode(pgamemode.get(player.getName()));
		pgamemode.remove(player.getName());
	}
	
	public static void restoreLocation(Player player) {
		player.teleport(ploc.get(player.getName()));
		ploc.remove(player.getName());
	}
	
	public static void restoreHunger(Player player) {
		player.setFoodLevel(plhunger.get(player.getName()));
		plhunger.remove(player.getName());
	}
	

	
    
    
	

}
