package me.net.minigames.tntrun.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class TNTPlayerDataStore {

	public HashMap<String, TNTArena> plingame = new HashMap<String, TNTArena>();
    public HashMap<String, TNTArena> arenanames = new HashMap<String, TNTArena>();
    static HashMap<TNTArena, HashSet<String>> arenaplayers = new HashMap<TNTArena, HashSet<String>>();
    static HashMap<TNTArena, HashSet<String>> lobbyplayers = new HashMap<TNTArena, HashSet<String>>();
    public static ArrayList<String> playing = new ArrayList<String>();
    public static ArrayList<String> lobbied = new ArrayList<String>();


	
    public void setPlayerArena(String player, TNTArena arena)
    {
            plingame.put(player, arena);
            arenaplayers.get(arena).add(player);
    }

    public TNTArena getPlayerArena(String player)
    {
            return plingame.get(player);
    }
    
    
    
    public HashSet<String> getArenaPlayers(TNTArena arena)
    {
            return arenaplayers.get(arena);
    }
	
    public void putArenaInHashMap(TNTArena arena)
    {
        arenanames.put(arena.getArenaName(), arena);
        arenaplayers.put(arena, new HashSet<String>());
        lobbyplayers.put(arena, new HashSet<String>());
    }
    
    public TNTArena getArenaByName(String name)
    {
            return arenanames.get(name);
            
    }

    
    public Set<TNTArena> getArenas()
    {
            return arenaplayers.keySet();
    }
    
	public void removePlayerFromArena(String player){
		TNTArena arena = plingame.get(player);
        arenaplayers.get(arena).remove(player);
        plingame.remove(player);
	}
	public void removeArenaFromHashMap(TNTArena arena) {
        arenanames.remove(arena.getArenaName());
        arenaplayers.remove(arena);
    }
	
	public boolean isInLobby(TNTArena arena, String player ) {
		if(lobbyplayers.get(arena).contains(player)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setLobby(String player, TNTArena arena) {
    	lobbyplayers.get(arena).add(player);
    	lobbied.add(player);
    }
    
    public void removePlayerFromLobby(TNTArena arena, String player) {
    	lobbyplayers.get(arena).remove(player);
    	lobbied.remove(player);
    }
    
    public HashSet<String> getLobbyPlayers(TNTArena arena) {
    	return lobbyplayers.get(arena);
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
	
	public void restorePlayerInventory(Player player) {
		
		player.getInventory().setContents(pinv.get(player.getName()));
		pinv.remove(player.getName());
	}
	
	public void restoreArmor(Player player) {
		player.getInventory().setArmorContents(parmor.get(player.getName()));
		parmor.remove(player.getName());
	}
	
	public void restoreGameMode(Player player) {
		player.setGameMode(pgamemode.get(player.getName()));
		pgamemode.remove(player.getName());
	}
	
	public void restoreLocation(Player player) {
		player.teleport(ploc.get(player.getName()));
		ploc.remove(player.getName());
	}
	
	public void restoreHunger(Player player) {
		player.setFoodLevel(plhunger.get(player.getName()));
		plhunger.remove(player.getName());
	}
	
}
