package me.net.minigames.parkour.handlers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class PPlayerDataStore {
	
	public HashMap<String, PArena> plingame = new HashMap<String, PArena>();
    public HashMap<String, PArena> arenanames = new HashMap<String, PArena>();
    static HashMap<PArena, HashSet<String>> arenaplayers = new HashMap<PArena, HashSet<String>>();
    static HashMap<String, String> pcheckpoint = new HashMap<String, String>();
    static HashMap<String, Integer> pfells = new HashMap<String, Integer>();
	
    public void setPlayerArena(String player, PArena arena)
    {
            plingame.put(player, arena);
            arenaplayers.get(arena).add(player);
            pcheckpoint.put(player, "0");
            pfells.put(player, 0);
    }
    public Integer getPlayerFells(String player) {
    	return pfells.get(player);
    }
    public void setPlayerFells(String player, Integer fells) {
    	pfells.put(player, fells);
    }

    public PArena getPlayerArena(String player)
    {
            return plingame.get(player);
    }
    
    
    
    public HashSet<String> getArenaPlayers(PArena arena)
    {
            return arenaplayers.get(arena);
    }
	
    public void putArenaInHashMap(PArena arena)
    {
            arenanames.put(arena.getArenaName(), arena);
            arenaplayers.put(arena, new HashSet<String>());
    }
    
    public PArena getArenaByName(String name)
    {
            return arenanames.get(name);
            
    }
    
	public void setPlayerCheckpoint(String name, String checkpoint) {
		pcheckpoint.put(name, checkpoint);
	}
	public String getPlayerCheckPoint(String player) {
		return pcheckpoint.get(player);
	}

    
    public Set<PArena> getArenas()
    {
            return arenaplayers.keySet();
    }
    
	public void removePlayerFromArena(String player){
        PArena arena = plingame.get(player);
        arenaplayers.get(arena).remove(player);
        plingame.remove(player);
        pfells.remove(player);
        pcheckpoint.remove(player);
	}
	public void removeArenaFromHashMap(PArena arena) {
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
