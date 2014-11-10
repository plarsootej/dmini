package me.net.minigames.parkour.handlers;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import me.net.minigames.main.MainClass;
import me.net.minigames.parkour.main.ParkourMain;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Vector;

public class PArena {
	
	public MainClass plugin;
	protected ParkourMain SpleefMain;
	public PPlayerHandler arenaph;

	public PArena(String name, MainClass plugin, ParkourMain spleefmain) {
		arenaname = name;
		this.plugin = plugin;
		this.SpleefMain = spleefmain;
		arenaph = new PPlayerHandler(plugin,this);
		arenafile = new File(plugin.getDataFolder()+File.separator+"/Parkour/Arenas"+File.separator+arenaname+".yml");
		SpleefMain.pdata.putArenaInHashMap(this);
	}
	
	 private boolean enabled = true;
	 public HashSet<PCheckPoint> checkpoints = new HashSet<PCheckPoint>();
     
	
	private String arenaname; 
	public String getArenaName()
	{
		return arenaname;
	}
	
    public boolean enableArena()
    {

          enabled = true;
          return true;
        
    }
    public boolean disableArena() 
    {
    	enabled = false;
    	return false;
    }
    
    public boolean isArenaEnabled()
    {
            return enabled;
    }
    
    private String arenaworld;
    public World getArenaWorld()
    {
            return Bukkit.getWorld(arenaworld);
    }
    public boolean SetArenaWorld(String world) {
    	arenaworld = world;
    	return true;
    }
    
    //Spawn location
    private Location spawnpoint = null;
    public Location getSpawnPoint()
    {
            return spawnpoint;
    }
   
    
    public boolean setSpawnPoint(Location loc)
    {
         
                    spawnpoint = loc;
					return true;
          
    }
    
	/** 
	 * Checkpoints 
	 **/
    public boolean setCheckPoint(String cpname, Location loc1)
    {
        PCheckPoint cp = getCheckPointByName(cpname);
        if (cp == null)
        {
                cp = new PCheckPoint(cpname);
                checkpoints.add(cp);
        }
        cp.setCheckPoint(loc1);
        return true;
            
     
    }
    public PCheckPoint getCheckPointByName(String name)
    {
            for (PCheckPoint cp : checkpoints)
            {
                    if (cp.getCheckPointName().equals(name)) 
                    {
                            return cp;
                    }
            }
            return null;
    }
    
 
    
    //spectate location
    private Location spectatepoint = null;
    public Location getSpectatePoint()
    {
            return spectatepoint;
    }
   
    
    public boolean setSpectatePoint(Location loc)
    {
         
                    spectatepoint = loc;
					return true;
          
    }
    
    public String isArenaConfigured()
    {
            if (spawnpoint == null) {return "Parkour Spawn point not set";}
            return "yes";
    }
    
    
    private File arenafile;
	public void saveToConfig()
	{
		FileConfiguration arenaconfig = new YamlConfiguration();
		//saving the name
		arenaconfig.set("Name", arenaname);
		
		//saving the arena bounds
		try {
            arenaconfig.set("World", arenaworld);
		} catch (Exception e) {}
		
		
		//saving the spawnpoint
        try {
            arenaconfig.set("SpawnPoint", spawnpoint.toVector());
        } catch (Exception e) {}
        
        
        //saving the spectate point
        try {
            arenaconfig.set("SpectatePoint", spectatepoint.toVector());
        } catch (Exception e) {}
        //saving enabled, disabled
        arenaconfig.set("Enabled", enabled);
        
        //saving the checkpoints
        for (PCheckPoint sl : checkpoints)
        {
                try {
                        sl.saveToConfig(arenaconfig);
                } catch (Exception e) {}
        }
		
		//saving the config
		try {
			arenaconfig.save(arenafile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

        
		
		
	}
	public void loadFromConfig() {
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(arenafile);
		
		arenaname = config.getString("Name");
		try {
			arenaworld = config.getString("World");
		}catch (Exception e) {}
		
		ConfigurationSection sl = config.getConfigurationSection("CheckPoints");
        if (sl != null)
        {
                for (String slname : sl.getKeys(false))
                {
                        try{
                                PCheckPoint gl = new PCheckPoint(slname);
                                gl.loadFromConfig(config);
                                checkpoints.add(gl);
                        } catch (Exception e) {}
                }
        }
		
		try {
			Vector v = config.getVector("SpawnPoint");
			spawnpoint = new Location(Bukkit.getServer().getWorld(arenaworld), v.getX(), v.getY(), v.getZ());
		}catch (Exception e) {}
		try {
			Vector v = config.getVector("SpectatePoint");
			spectatepoint = new Location(Bukkit.getServer().getWorld(arenaworld), v.getX(), v.getY(), v.getZ());
		}catch (Exception e) {}
		enabled = config.getBoolean("Enabled");
	}
	

}
