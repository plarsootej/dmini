package me.net.minigames.tntrun.handlers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import me.net.minigames.main.MainClass;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.methods.TNTCountDown;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Vector;

public class TNTArena {
	
	public MainClass plugin;
	protected TNTRunMain TNTRunMain;
	public TNTPlayerHandler arenaph;
	public TNTCountDown TNTCountDown;

	public TNTArena(String name, MainClass plugin, TNTRunMain TNTRunMain) {
		arenaname = name;
		this.plugin = plugin;
		this.TNTRunMain = TNTRunMain;
		arenaph = new TNTPlayerHandler(plugin,this);
		TNTCountDown = new TNTCountDown(TNTRunMain, this);
		arenafile = new File(plugin.getDataFolder()+File.separator+"/TntRun/Arenas"+File.separator+arenaname+".yml");
		TNTRunMain.pdata.putArenaInHashMap(this);
	}
	
	 private boolean enabled = true;
     private boolean starting = false;
     private boolean running = false;
     private boolean counting = false;
     
     public HashSet<TNTSpawnLocation> spawnlocations = new HashSet<TNTSpawnLocation>();
     public HashSet<TNTFloorLevel> floorlevels = new HashSet<TNTFloorLevel>();
     
     private int count = 20;

     public void setCountDown(int countdown) {
    	 count = countdown;
     }
     public int getCountdown()
     {
    	 return count;
     }
     
     public boolean isArenaStarting()
     {
             return starting;
     }
     public void setStarting(boolean booolean)
     {
             starting = booolean;
     }
     public boolean isCounting() {
    	 return counting;
     }
     public void setCounting(boolean booolean) {
    	 counting = booolean;
     }
     public boolean isArenaRunning()
     {
             return running;
     }
     public void setRunning(boolean booolean)
     {
             running = booolean;
     }
	
	private String arenaname; 
	public String getArenaName()
	{
		return arenaname;
	}
	
	
	/** 
	 * Spawn Locations 
	 **/
    public boolean setSpawnPoint(String glname, Location loc1)
    {
        TNTSpawnLocation sl = getSpawnLocationByName(glname);
        if (sl == null)
        {
                sl = new TNTSpawnLocation(glname);
                spawnlocations.add(sl);
        }
        sl.setSpawnLocation(loc1);
        return true;
            
     
    }
    public TNTSpawnLocation getSpawnLocationByName(String name)
    {
            for (TNTSpawnLocation sl : spawnlocations)
            {
                    if (sl.getSpawnLocationName().equals(name)) 
                    {
                            return sl;
                    }
            }
            return null;
    }
    
	/** 
	 * Floor Levels 
	 **/
    public boolean setFloorLevel(String glname, Location loc1, Location loc2)
    {
        TNTFloorLevel fl = getFloorLevelByName(glname);
        if (fl == null)
        {
                fl = new TNTFloorLevel(glname);
                floorlevels.add(fl);
        }
        fl.setGameLocation(loc1, loc2);
        return true;
    }
    private TNTFloorLevel getFloorLevelByName(String name)
    {
            for (TNTFloorLevel fl : floorlevels)
            {
                    if (fl.getGameLevelName().equals(name)) 
                    {
                            return fl;
                    }
            }
            return null;
    }
	
    public boolean enableArena()
    {
            if (isArenaConfigured().equalsIgnoreCase("yes"))
            {
                   // arenagh.startArenaAntiLeaveHandler();
                    enabled = true;
                    return true;
            }
            return false;
    }
    public HashSet<TNTFloorLevel> getGameLevels()
    {
            return floorlevels;
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
    
    
    public String isArenaConfigured()
    {
    	if(floorlevels.size() == 0) {return "No Floor Levels Set";}
    	if(spawnlocations.size() == 0) {return "No Spawn locations Set";}
        if(lobbypoint == null) {return "Arena Lobby point not set";}
        if(spectatepoint == null) {return "Arena Spectate point not set";}
        return "yes";
    }
	
	/** Arena Vectors **/
    private Vector arenap1 = null;
    public Vector getArenaP1()
    {
            return arenap1;
    }
    private Vector arenap2 = null;
    public Vector getAreaP2()
    {
            return arenap2;
    }
    private String arenaworld;
    public World getArenaWorld()
    {
            return Bukkit.getWorld(arenaworld);
    }
    public void setArenaWorld(String world) {
    	arenaworld = world;
    }
    
    public void setArenaPoints(Location loc1, Location loc2)
    {
            arenaworld = loc1.getWorld().getName();
            arenap1 = loc1.toVector();
            arenap2 = loc2.toVector();
    }
    

    
    
    /** Lose Vectors **/
    private Vector losep1 = null;
    public Vector getLoseP1()
    {
            return losep1;
    }
    private Vector losep2 = null;
    public Vector getLoseP2()
    {
            return losep2;
    }
    private String loseworld;
    public World getLoseWorld()
    {
            return Bukkit.getWorld(loseworld);
    }
    
    public void setLosePoints(Location loc1, Location loc2)
    {
            loseworld = loc1.getWorld().getName();
            losep1 = loc1.toVector();
            losep2 = loc2.toVector();
    }
    //lobby location
    private Location lobbypoint = null;
    public Location getLobbyPoint()
    {
            return lobbypoint;
    }
   
    
    public boolean setLobbyPoint(Location loc)
    {
         
                    lobbypoint = loc;
					return true;
          
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
    
    
    
    public boolean isInArenaBounds(Location loc)
    {
            if (loc.toVector().isInAABB(arenap1, arenap2)) {return true;}
            return false;
    }
    
    public Integer getSpawnNumber() {
    	FileConfiguration config = YamlConfiguration.loadConfiguration(arenafile);
    	if(config.contains("SpawnLocations")) {
    		List<String> spawns = new ArrayList<String>();
    		Set<String> names = config.getConfigurationSection("SpawnLocations").getKeys(false);
    		
    		for(String name : names) {
    			spawns.add(name);
    		}
    		
    		return spawns.size();
    	}else {
    		return 0;
    	}
    }
    
    
    private File arenafile;
	public void saveToConfig()
	{
		FileConfiguration arenaconfig = new YamlConfiguration();
		//saving the name
		arenaconfig.set("Name", arenaname);
		arenaconfig.set("CountDown", count);
		
		//saving the arena bounds
		try {
            arenaconfig.set("ArenaBorders.World", arenaworld);
            arenaconfig.set("ArenaBorders.p1", arenap1);
            arenaconfig.set("ArenaBorders.p2", arenap2);
		} catch (Exception e) {}
		
		
        for (TNTSpawnLocation sl : spawnlocations)
        {
                try {
                        sl.saveToConfig(arenaconfig);
                } catch (Exception e) {}
        }
        
        for (TNTFloorLevel fl : floorlevels)
        {
                try {
                	fl.saveToConfig(arenaconfig);
                } catch (Exception e) {}
        }
		
		
		try {
            arenaconfig.set("Lose.World", loseworld);
            arenaconfig.set("Lose.p1", losep1);
            arenaconfig.set("Lose.p2", losep2);
		} catch (Exception e) {}
		

        //saving the lobby point
        try {
            arenaconfig.set("LobbyPoint", lobbypoint.toVector());
        } catch (Exception e) {}
        
        //saving the spectate point
        try {
            arenaconfig.set("SpectatePoint", spectatepoint.toVector());
        } catch (Exception e) {}
        //saving enabled, disabled
        arenaconfig.set("Enabled", enabled);
		
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
		count = config.getInt("CountDown");
		try {
			arenaworld = config.getString("ArenaBorders.World");
		}catch (Exception e) {}
		
		try {
			arenap1 = config.getVector("ArenaBorders.p1");
			arenap2 = config.getVector("ArenaBorders.p2");
		}catch (Exception e) {}
		
		try {
			loseworld = config.getString("Lose.World");
			losep1 = config.getVector("Lose.p1");
			losep2 = config.getVector("Lose.p2");
		}catch (Exception e) {}
		
		ConfigurationSection sl = config.getConfigurationSection("SpawnLocations");
        if (sl != null)
        {
                for (String slname : sl.getKeys(false))
                {
                        try{
                                TNTSpawnLocation gl = new TNTSpawnLocation(slname);
                                gl.loadFromConfig(config);
                                spawnlocations.add(gl);
                        } catch (Exception e) {}
                }
        }
		
        ConfigurationSection cs = config.getConfigurationSection("Floors");
        if (cs != null)
        {
                for (String glname : cs.getKeys(false))
                {
                        try{
                                TNTFloorLevel gl = new TNTFloorLevel(glname);
                                gl.loadFromConfig(config);
                                floorlevels.add(gl);
                        } catch (Exception e) {}
                }
        }
		try {
			Vector v = config.getVector("LobbyPoint");
			lobbypoint = new Location(Bukkit.getServer().getWorld(arenaworld), v.getX(), v.getY(), v.getZ());
		}catch (Exception e) {}
		
		
		try {
			Vector v = config.getVector("SpectatePoint");
			spectatepoint = new Location(Bukkit.getServer().getWorld(arenaworld), v.getX(), v.getY(), v.getZ());
		}catch (Exception e) {}
		enabled = config.getBoolean("Enabled");
	}
	
}
