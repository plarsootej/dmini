package me.net.minigames.teamdeathmatch.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;

public class TKitHandler {
	
    public HashMap<String, TKit> kitnames = new HashMap<String, TKit>();
    public HashMap<Material, Integer> items = new HashMap<Material, Integer>();
    public HashMap<String, TKit> pkit = new HashMap<String, TKit>();
    public List<TKit> kits = new ArrayList<TKit>();

	
    public void putArenaInHashMap(TKit kit)
    {
    	kitnames.put(kit.getKitName(), kit);
    	kits.add(kit);
    }
    public void setPlayerKit(String player, TKit kit) {
    	pkit.put(player, kit);
    }
    public TKit getPlayerKit(String player) {
    	return pkit.get(player);
    }
    
    public TKit getKitByName(String kit) {
    	return kitnames.get(kit);
    }
    public List<TKit> getKits()
    {
            return kits;
    }
    public void RemovePlayerFromLists(String player) {
    	pkit.remove(player);
    }

}
