package me.net.minigames.spleef.handlers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class SPlayerDataStore {
	
	public HashMap<String, SArena> plingame = new HashMap<String, SArena>();
    public HashMap<String, SArena> arenanames = new HashMap<String, SArena>();
    static HashMap<SArena, HashSet<String>> arenaplayers = new HashMap<SArena, HashSet<String>>();
	
    public void setPlayerArena(String player, SArena arena)
    {
            plingame.put(player, arena);
            arenaplayers.get(arena).add(player);
    }

    public SArena getPlayerArena(String player)
    {
            return plingame.get(player);
    }
    
    
    
    public HashSet<String> getArenaPlayers(SArena arena)
    {
            return arenaplayers.get(arena);
    }
	
    public void putArenaInHashMap(SArena arena)
    {
            arenanames.put(arena.getArenaName(), arena);
            arenaplayers.put(arena, new HashSet<String>());
    }
    
    public SArena getArenaByName(String name)
    {
            return arenanames.get(name);
            
    }

    
    public Set<SArena> getArenas()
    {
            return arenaplayers.keySet();
    }
    
	public void removePlayerFromArena(String player){
        SArena arena = plingame.get(player);
        arenaplayers.get(arena).remove(player);
        plingame.remove(player);
	}
	public void removeArenaFromHashMap(SArena arena) {
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
