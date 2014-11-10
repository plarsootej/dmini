package me.net.minigames.main.config;

import me.net.minigames.main.handlers.ConfigHandler;

public class PMainConfig {
	
	
	public static void PMainloadDefaults() {
		
		if(!ConfigHandler.Paintball.contains("Kills-Before-Death")) {
			ConfigHandler.Paintball.set("Kills-Before-Death", 3);
		}

		if(!ConfigHandler.Paintball.contains("Weapons")) {
			if(!ConfigHandler.Paintball.contains("Weapons.ShotGun-ID")) {
				
				ConfigHandler.Paintball.set("Weapons.ShotGun-ID", 275, "Shot Gun");
				ConfigHandler.Paintball.set("Weapons.ShotGun-Name", "§6ShotGun", "Enter 'None' if you want to use the minecraft item name");
			}
			if(!ConfigHandler.Paintball.contains("Weapons.SniperGun-ID")) {
				
				ConfigHandler.Paintball.set("Weapons.SniperGun-ID", 279, "Sniper Gun");
				ConfigHandler.Paintball.set("Weapons.SniperGun-Name", "§6Sniper", "Enter 'None' if you want to use the minecraft item name");
			}
			if(!ConfigHandler.Paintball.contains("Weapons.Shoot-Weapon-ID")) {
				
				ConfigHandler.Paintball.set("Weapons.Shoot-Weapon-ID", 271, "Normal Gun");
				ConfigHandler.Paintball.set("Weapons.Shoot-Weapon-Name", "§6Normal Gun", "Enter 'None' if you want to use the minecraft item name");
			}
			if(!ConfigHandler.Paintball.contains("Weapons.Damage-Grenade-ID")) {
				
				ConfigHandler.Paintball.set("Weapons.Damage-Grenade-ID", 368,"Damage Grenade");
				ConfigHandler.Paintball.set("Weapons.Damage-Grenade-Name", "§6Grenade", "Enter 'None' if you want to use the minecraft item name");
			}
			if(!ConfigHandler.Paintball.contains("Weapons.Flash-Grenade-ID")) {
				
				ConfigHandler.Paintball.set("Weapons.Flash-Grenade-ID", 341, "Flash grenade");
				ConfigHandler.Paintball.set("Weapons.Flash-Grenade-Name", "§6Flash Grenade", "Enter 'None' if you want to use the minecraft item name");
			}
		}

		ConfigHandler.Paintball.saveConfig();
	}

}
