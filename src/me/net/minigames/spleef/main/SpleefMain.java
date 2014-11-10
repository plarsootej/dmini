package me.net.minigames.spleef.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.net.minigames.main.MainClass;
import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.handlers.SPlayerDataStore;

import org.bukkit.entity.Player;


public class SpleefMain {
	
	
	
	
	public static List<Player> wand = new ArrayList<Player>();
	
	public static SpleefMain SpleefMain;
	
	
	public static HashMap<String, String> running = new HashMap<String, String>();
	public static HashMap<String, String> counting = new HashMap<String, String>();
	public static HashMap<String, String> arenaselected = new HashMap<String, String>();


	protected MainClass plugin;
	public SPlayerDataStore pdata;

	public SpleefMain(MainClass mainClass) {

		this.plugin = mainClass;
	}



	public void EnableSpleef() {
		
		SpleefMain = this;
		
		pdata = new SPlayerDataStore();
		
		//load arenas
        File arenasfolder = new File(MainClass.main.getDataFolder() + "/Spleef/Arenas");
        arenasfolder.mkdirs(); 
        for (String file : arenasfolder.list())
        {
                SArena arena = new SArena(file.split("[.]")[0].toLowerCase(), MainClass.main, SpleefMain);
                try {
                        arena.loadFromConfig();
                } catch (Exception e) {}
        }
		
		
		
	}

}
