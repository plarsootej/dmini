package me.net.minigames.main.config;

import me.net.minigames.main.MainClass;
import me.net.minigames.teamdeathmatch.handlers.TKit;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.Material;
@SuppressWarnings("deprecation")
public class DefaultKits {
	
	
	
	public static void SoldierKit() {
		TKit kit = new TKit("soldier".toLowerCase(), MainClass.main, TeamDeathMatchMain.TeamDeathMatchMain);
		//armor
		kit.setChestPlate(Material.getMaterial(307));
		kit.setLeggings(Material.getMaterial(308));
		kit.setBoots(Material.getMaterial(309));
		kit.SetItemInHand(Material.getMaterial(267));
		
		//Items
		kit.addItem(Material.getMaterial(282), 20);
		
		kit.saveToConfig();
	}
	public static void ArcherKit() {
		TKit kit = new TKit("archer".toLowerCase(), MainClass.main, TeamDeathMatchMain.TeamDeathMatchMain);
		
		//armor
		kit.setChestPlate(Material.getMaterial(299));
		kit.setLeggings(Material.getMaterial(300));
		kit.setBoots(Material.getMaterial(301));
		kit.SetItemInHand(Material.getMaterial(261));
		
		//Items
		kit.addItem(Material.getMaterial(262), 64);
		kit.addItem(Material.getMaterial(282), 20);
		
		kit.saveToConfig();
	}
	
	public static void HeavyKit() {
		TKit kit = new TKit("heavy".toLowerCase(), MainClass.main, TeamDeathMatchMain.TeamDeathMatchMain);
		
		//armor
		kit.setChestPlate(Material.getMaterial(311));
		kit.setLeggings(Material.getMaterial(312));
		kit.setBoots(Material.getMaterial(313));
		kit.SetItemInHand(Material.getMaterial(276));
		
		//Items
		kit.addItem(Material.getMaterial(282), 20);

		
		kit.saveToConfig();
	}
	
	public static void NinjaKit() {
		TKit kit = new TKit("ninja".toLowerCase(), MainClass.main, TeamDeathMatchMain.TeamDeathMatchMain);
		
		//armor
		kit.setChestPlate(Material.getMaterial(303));
		kit.setLeggings(Material.getMaterial(304));
		kit.setBoots(Material.getMaterial(305));
		kit.SetItemInHand(Material.getMaterial(276));
		
		//Items
		kit.addItem(Material.getMaterial(282), 20);
		
		kit.saveToConfig();
	}
	
	public static void MedicKit() {
		TKit kit = new TKit("medic".toLowerCase(), MainClass.main, TeamDeathMatchMain.TeamDeathMatchMain);
		
		//armor
		kit.setChestPlate(Material.getMaterial(299));
		kit.setLeggings(Material.getMaterial(300));
		kit.setBoots(Material.getMaterial(301));
		kit.SetItemInHand(Material.getMaterial(276));
		
		//Items
		kit.addItem(Material.getMaterial(282), 20);
		
		kit.saveToConfig();
	}
	public static void load() {
		SoldierKit();
		ArcherKit();
		HeavyKit();
		NinjaKit();
		MedicKit();
	}
	
	

}
