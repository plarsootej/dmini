package me.net.minigames.paintball;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.handlers.PAArenas;
import me.net.minigames.paintball.handlers.PAPlayerDataStore;

import org.bukkit.entity.Player;

public class PaintballMain {
	


	public  MainClass plugin;
	public static PaintballMain PaintBallMain;
	
	
	
	public static List<Player> grenade = new ArrayList<Player>();
	public static List<Player> flash = new ArrayList<Player>();
	
	public PAPlayerDataStore pdata;
	
	public PaintballMain(MainClass instance) {
		this.plugin = instance;
	}

	public void enablePaintBall() {
		
		//listeners
		this.pdata = new PAPlayerDataStore();
		PaintBallHandler.loadPaintBallClasses();
		PaintBallMain = this;
		
		//loading arenas
        File arenasfolder = new File(MainClass.main.getDataFolder() + "/Paintball/Arenas");
        arenasfolder.mkdirs(); 
        for (String file : arenasfolder.list())
        {
                PAArenas arena = new PAArenas(file.split("[.]")[0].toLowerCase(), MainClass.main, PaintBallMain);
                try {
                        arena.loadFromConfig();
                } catch (Exception e) {}
        }
	}
	
	public void disablePaintball(){
        for (PAArenas arena : PaintBallMain.pdata.getArenas())
        {
                arena.saveToConfig();
        }
	}

}
