package me.net.minigames.teamdeathmatch.handlers;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

import me.net.minigames.main.MainClass;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class TKit {
	
	public MainClass plugin;
	protected TeamDeathMatchMain TeamDeathMatchMain;
	
	public TKit(String name, MainClass plugin, TeamDeathMatchMain Teamdeathmatchmain) {
		kitname = name;
		this.plugin = plugin;
		this.TeamDeathMatchMain = Teamdeathmatchmain;
		arenafile = new File(plugin.getDataFolder()+File.separator+"/TeamDeathMatch/Kits"+File.separator+kitname+".yml");
		Teamdeathmatchmain.kdata.putArenaInHashMap(this);
	}
	
	private String kitname;
	public String getKitName()
	{
		return kitname;
	}
	
	//chestplate
	private Integer chestplate;
	public Integer getChestPlate() {
		return chestplate;
	}
	
	@SuppressWarnings("deprecation")
	public void setChestPlate(Material item) {
		chestplate = item.getId();
	}
	
	//leggings
	private Integer leggings;
	public Integer getLeggings() {
		return leggings;
	}
	
	@SuppressWarnings("deprecation")
	public void setLeggings(Material item) {
		leggings = item.getId();
	}
	
	//boots
	private Integer boots;
	public Integer getBoots() {
		return boots;
	}
	
	@SuppressWarnings("deprecation")
	public void setBoots(Material item) {
		boots = item.getId();
	}
	
	public void addItem(Material material, int amount) {
		TeamDeathMatchMain.kdata.items.put(material, amount);
	}
	@SuppressWarnings("deprecation")
	public void SaveItems(FileConfiguration config) {
		for(Entry<Material, Integer> entry : TeamDeathMatchMain.kdata.items.entrySet())
		{
		    config.set("Items." + entry.getKey().getId(), entry.getValue());
		}
	}
	
	@SuppressWarnings("deprecation")
	public void loadItems(FileConfiguration config) {
		Set<String> names = config.getConfigurationSection("Items").getKeys(false);
		for(String name : names) {
			int material = Integer.parseInt(name);
			int amount = config.getInt("Items." + name);
			TeamDeathMatchMain.kdata.items.put(Material.getMaterial(material), amount);
		}
	}
	private boolean inuse = true;
	public boolean getInUse() {
		return inuse;
	}
	public void setInUse(boolean booolean) {
		inuse = booolean;
	}
	private Integer inhand;
	@SuppressWarnings("deprecation")
	public void SetItemInHand(Material item) {
		inhand = item.getId();
	}
	public Integer getInHand() {
		return inhand;
	}
	
	private Integer healitem;
	@SuppressWarnings("deprecation")
	public void SetHealItem(Material item) {
		healitem = item.getId();
	}
	public Integer getHealItem() {
		return healitem;
	}
	private File arenafile;
	public void saveToConfig()
	{
		FileConfiguration arenaconfig = new YamlConfiguration();
		arenaconfig.options().header("To add new items just add below ~Items:~ =ITEMID, AMOUNT=  \nIf you have problems with kits delete the kits and reload the server to get the default kits");
		//saving the name
		arenaconfig.set("Name", kitname);
		arenaconfig.set("InUse", inuse);		
		//saving the arena bounds
		try {
			arenaconfig.set("ChestPlate", chestplate);
		} catch (Exception e) {}
		

		
		try {
			arenaconfig.set("Leggings", leggings);
		} catch (Exception e) {}
		
		try {
			arenaconfig.set("Boots", boots);
		} catch (Exception e) {}
		try {
			arenaconfig.set("ItemInHand", inhand);
		} catch (Exception e) {}
		try {
			arenaconfig.set("Heal-Item", healitem);
		} catch (Exception e) {}
		try {
			SaveItems(arenaconfig);
		} catch (Exception e) {}
		
		//saving the config
		try {
			arenaconfig.save(arenafile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

        
		
		
	}
	public void loadFromConfig() {
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(arenafile);
		
		kitname = config.getString("Name");
		inuse = config.getBoolean("InUse");
		
		//chestplate
		try {
			chestplate = config.getInt("ChestPlate");
		}catch (Exception e) {}
		
		try {
			leggings = config.getInt("Leggings");
		}catch (Exception e) {}
		
		try {
			boots = config.getInt("Boots");
		}catch (Exception e) {}
		
		try {
			inhand = config.getInt("ItemInHand");
		}catch (Exception e) {}
		try {
			healitem = config.getInt("Heal-Item");
		} catch (Exception e) {}
		
		try {
			loadItems(config);
		}catch (Exception e) {}
	}

}
