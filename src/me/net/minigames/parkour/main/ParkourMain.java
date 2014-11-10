package me.net.minigames.parkour.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.net.minigames.main.MainClass;
import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.handlers.PPlayerDataStore;

import org.bukkit.entity.Player;

public class ParkourMain {
	
	public static List<Player> wand = new ArrayList<Player>();
	public static ParkourMain ParkourMain;
	public PPlayerDataStore pdata;
	
	MainClass plugin;
	public ParkourMain (MainClass instance) {
		plugin = instance;
	}
	
	public void enableParkour() {
		ParkourMain = this;
		pdata = new PPlayerDataStore();
		
		
		//load arenas
        File arenasfolder = new File(MainClass.main.getDataFolder() + "/Parkour/Arenas");
        arenasfolder.mkdirs(); 
        for (String file : arenasfolder.list())
        {
                PArena arena = new PArena(file.split("[.]")[0].toLowerCase(), MainClass.main, ParkourMain);
                try {
                        arena.loadFromConfig();
                } catch (Exception e) {}
        }
        
		
	}

}
