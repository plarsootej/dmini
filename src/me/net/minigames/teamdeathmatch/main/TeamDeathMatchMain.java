package me.net.minigames.teamdeathmatch.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.net.minigames.main.MainClass;
import me.net.minigames.main.config.DefaultKits;
import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.handlers.TKit;
import me.net.minigames.teamdeathmatch.handlers.TKitHandler;
import me.net.minigames.teamdeathmatch.handlers.TPlayerDataStore;

import org.bukkit.entity.Player;

public class TeamDeathMatchMain {
	
	public static TeamDeathMatchMain TeamDeathMatchMain;
	public TPlayerDataStore pdata;
	public TKitHandler kdata;
	public static List<Player> wand = new ArrayList<Player>();
	
	public static List<Player> grenade = new ArrayList<Player>();
	public static List<Player> flash = new ArrayList<Player>();
	
	
	
	public void enableTDM() {
		TeamDeathMatchMain = this;
		pdata = new TPlayerDataStore();
		kdata = new TKitHandler();
		
		
		//loading arenas
        File arenasfolder = new File(MainClass.main.getDataFolder() + "/TeamDeathMatch/Arenas");
        arenasfolder.mkdirs(); 
        for (String file : arenasfolder.list())
        {
                TArenas arena = new TArenas(file.split("[.]")[0].toLowerCase(), MainClass.main, TeamDeathMatchMain);
                try {
                        arena.loadFromConfig();
                } catch (Exception e) {}
        }

        
        //loading kits
        File kitsfolder = new File(MainClass.main.getDataFolder() + "/TeamDeathMatch/Kits");
        kitsfolder.mkdirs(); 
    	for (String file : kitsfolder.list())
        {
                TKit kit = new TKit(file.split("[.]")[0].toLowerCase(), MainClass.main, TeamDeathMatchMain);
                try {
                	kit.loadFromConfig();
                } catch (Exception e) {}
        }
    	if(!TeamDeathMatchMain.kdata.kitnames.containsKey("soldier")) {
    		/**
    		 * Load default kits
    		 */
    		DefaultKits.load();
    		
        	for (String file : kitsfolder.list())
            {
                    TKit kit = new TKit(file.split("[.]")[0].toLowerCase(), MainClass.main, TeamDeathMatchMain);
                    try {
                    	kit.loadFromConfig();
                    } catch (Exception e) {}
            }
    	}
        
        
	}
	
	public void disableTDM() {
        for (TArenas arena : TeamDeathMatchMain.pdata.getArenas())
        {
                arena.saveToConfig();
        }
        for (TKit kit : TeamDeathMatchMain.kdata.getKits())
        {
                kit.saveToConfig();
        }
	}

}
