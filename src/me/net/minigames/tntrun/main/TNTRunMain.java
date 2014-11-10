package me.net.minigames.tntrun.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.net.minigames.main.MainClass;
import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.handlers.TNTPlayerDataStore;
import me.net.minigames.tntrun.messages.TNTMessages;

import org.bukkit.entity.Player;

public class TNTRunMain {
	
	MainClass plugin;
	public TNTRunMain (MainClass instance) {
		plugin = instance;
	}
	
	public static List<Player> wand = new ArrayList<Player>();
	
	
	
	public TNTPlayerDataStore pdata;
	public static TNTRunMain TNTRunMain;
	public TNTMessages TNTMessages;
	
	
	
	
	public void EnableTNTRun(){
		
		pdata = new TNTPlayerDataStore();
		TNTMessages = new TNTMessages();
		TNTRunMain = this;
		
		//load arenas
        File arenasfolder = new File(MainClass.main.getDataFolder() + "/TntRun/Arenas");
        arenasfolder.mkdirs(); 
        for (String file : arenasfolder.list())
        {
                TNTArena arena = new TNTArena(file.split("[.]")[0].toLowerCase(), MainClass.main, TNTRunMain);
                try {
                        arena.loadFromConfig();
                } catch (Exception e) {}
        }
		

		
	}
	
	public void DisableTNTRun() {
        for (TNTArena arena : TNTRunMain.pdata.getArenas())
        {
                arena.saveToConfig();
        }
	}

}
