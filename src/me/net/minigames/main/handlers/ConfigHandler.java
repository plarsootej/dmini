package me.net.minigames.main.handlers;

import me.net.minigames.main.MainClass;
import me.net.minigames.main.config.Config;
import me.net.minigames.main.config.ConfigManager;
import me.net.minigames.main.config.PMainConfig;

public class ConfigHandler{
	
	MainClass plugin;
	public ConfigHandler (MainClass instance) {
		plugin = instance;
	}
	
	
	public static Config MainConfig;
	
	/**Paintball**/
	public static Config Paintball;
	
	/**Team Deathmatch**/
	public static Config MainTDM;
	
	/**Spleef**/
	public static Config MainSpleef;

	
	/** TNT Run **/
	public static Config TNTMainConfig;
	
	/** Parkour **/
	public static Config ParkourMain;
	

	public static ConfigManager manager;
	
	public void LoadYamls() {
		manager = new ConfigManager(plugin);
		
		/**MainConfig**/
		String[] MainConfigHeader = {"<- Main Config ->", "Coded by- DracinisScripting"};
		
		MainConfig = manager.getNewConfig("Config.yml", MainConfigHeader);
		
		/**Paintball**/
        String[] PaintballHeader = {"<- Paintball ->","Main Config", "Coded by-'DracinisScripting'"};

        
		Paintball = manager.getNewConfig("/Paintball/Config.yml", PaintballHeader);
		
		/** Team Deathmatch**/
		String[] TDMMainConfigHeader = {"<- TDM ->","Main Config", "Coded by-'DracinisScripting'"};
		
		MainTDM = manager.getNewConfig("/TeamDeathMatch/Config.yml", TDMMainConfigHeader);
	    /** Spleef **/
	    
	    String[] SpleefMainConfigHeader = {"<- Spleef ->","Main Config", "Coded by-'DracinisScripting'"};
		
	    MainSpleef = manager.getNewConfig("/Spleef/Config.yml", SpleefMainConfigHeader);
		
		/**TNT Run **/
		String[] TNTMainConfigHeader = {"<- TNT Run ->","Main Config", "Coded by-'DracinisScripting'"};
		
		
		TNTMainConfig = manager.getNewConfig("/TntRun/Config.yml", TNTMainConfigHeader);
		
		/**Parkour **/
		String[] ParkourMainConfigHeader = {"<- parkour ->","Main Config", "Coded by-'DracinisScripting'"};
		
		
		ParkourMain = manager.getNewConfig("/Parkour/Config.yml", ParkourMainConfigHeader);
		
		if(!MainSpleef.contains("Floor-Block-Type")) {
			MainSpleef.set("Floor-Block-Type", 35, "change the spleef floor block id ");
			MainSpleef.set("Wand-Tool-ID", 275, "Wand tool used to set the arena locations");
			MainSpleef.saveConfig();
		}
		
		if(!MainConfig.contains("Auto-Update-Message")) {
			me.net.minigames.main.config.MainConfig.MainConfigDefaults();
		}
		
		if(!MainTDM.contains("Default-Kit")) {
			MainTDM.set("Default-Kit", "soldier");
			MainTDM.set("Wand-Tool-ID", 275);
			MainTDM.saveConfig();
		}

	    
		PMainConfig.PMainloadDefaults();
		
		
		if(!TNTMainConfig.contains("Wand-Tool-ID")) {
			TNTMainConfig.set("Wand-Tool-ID", 275);
			if(TNTMainConfig.contains("Arena-Block-ID")) {
				TNTMainConfig.removeKey("Arena-Block-ID");
			}
			TNTMainConfig.saveConfig();
		}
		if(!ParkourMain.contains("Finish-Block")) {
			ParkourMain.set("Finish-Block", 43, "There are 2 Finish Block ID's Thats because if you want to use slabs");
			ParkourMain.set("Finish-Block2", 44);
			ParkourMain.set("Fall-Block", 88);
			ParkourMain.set("Speed-Block", 42);
			ParkourMain.set("Slow-Block", 22);
			ParkourMain.set("Jump-Block", 82);
			ParkourMain.saveConfig();
		}
	    
	}
	
	
}
