package me.net.minigames.main.config;

import me.net.minigames.main.handlers.ConfigHandler;

public class MainConfig {
	
	public static void MainConfigDefaults() {
		
		if(ConfigHandler.MainConfig.contains("Auto-Update-Message")) {
			ConfigHandler.MainConfig.removeKey("Auto-Update-Message");
		}
		ConfigHandler.MainConfig.set("ReleaseVersion", "0.3.6.1");
		ConfigHandler.MainConfig.set("-DevBuildVersion", "0.3.6.1.1");
		ConfigHandler.MainConfig.saveConfig();
	}

}
