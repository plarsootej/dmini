package me.net.minigames.spleef.handlers;

import java.io.File;
import java.io.IOException;

import me.net.minigames.main.MainClass;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.methods.SCountdown;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Vector;

public class SArena {
	
	public MainClass plugin;
	protected SpleefMain SpleefMain;
	public SPlayerHandler arenaph;
	public SCountdown SCountdown;

	public SArena(String name, MainClass plugin, SpleefMain spleefmain) {
		arenaname = name;
		this.plugin = plugin;
		this.SpleefMain = spleefmain;
		this.SCountdown = new SCountdown(spleefmain, this);
		arenaph = new SPlayerHandler(plugin,this);
		arenafile = new File(plugin.getDataFolder()+File.separator+"/Spleef/Arenas"+File.separator+arenaname+".yml");
		SpleefMain.pdata.putArenaInHashMap(this);
	}
	
	 private boolean enabled = true;
     private boolean starting = false;
     private boolean running = false;
     
     private int countdown = 20;
     public int getCountdown()
     {
             return countdown;
     }
     public void setCountDown(int countdown) {
    	 this.countdown = countdown;
     }
     
     public boolean isArenaStarting()
     {
             return starting;
     }
     public void setStarting(boolean booolean)
     {
             starting = booolean;
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
            if (arenap1 == null || arenap2==null || arenaworld == null) {return "Arena bounds not set";}
            if (floorp1 == null || floorp2==null || floorworld == null) {return "Floor not set";}
            if(losep1 == null || losep2 == null || loseworld == null) {return "Lose level not set!";}
            if (spawnpoint == null) {return "Arena Spawn point not set";}
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
    
    public void setArenaPoints(Location loc1, Location loc2)
    {
            arenaworld = loc1.getWorld().getName();
            arenap1 = loc1.toVector();
            arenap2 = loc2.toVector();
    }
    
    /** Floor Vectors **/
    private Vector floorp1 = null;
    public Vector getFloorP1()
    {
            return floorp1;
    }
    private Vector floorp2 = null;
    public Vector getFloorP2()
    {
            return floorp2;
    }
    private String floorworld;
    public World getFloorWorld()
    {
            return Bukkit.getWorld(floorworld);
    }
    
    public void setFloorPoints(Location loc1, Location loc2)
    {
            floorworld = loc1.getWorld().getName();
            floorp1 = loc1.toVector();
            floorp2 = loc2.toVector();
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
    
    
    private File arenafile;
	public void saveToConfig()
	{
		FileConfiguration arenaconfig = new YamlConfiguration();
		//saving the name
		arenaconfig.set("Name", arenaname);
		
		//saving the arena bounds
		try {
            arenaconfig.set("ArenaBorders.World", arenaworld);
            arenaconfig.set("ArenaBorders.p1", arenap1);
            arenaconfig.set("ArenaBorders.p2", arenap2);
		} catch (Exception e) {}
		
		//saving the floor
		try {
            arenaconfig.set("Floor.World", floorworld);
            arenaconfig.set("Floor.p1", floorp1);
            arenaconfig.set("Floor.p2", floorp2);
		} catch (Exception e) {}
		
		try {
            arenaconfig.set("Lose.World", loseworld);
            arenaconfig.set("Lose.p1", losep1);
            arenaconfig.set("Lose.p2", losep2);
		} catch (Exception e) {}
		
		//saving the spawnpoint
        try {
            arenaconfig.set("SpawnPoint", spawnpoint.toVector());
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
		try {
			arenaworld = config.getString("ArenaBorders.World");
			arenap1 = config.getVector("ArenaBorders.p1");
			arenap2 = config.getVector("ArenaBorders.p2");
		}catch (Exception e) {}
		
		try {
			loseworld = config.getString("Lose.World");
			losep1 = config.getVector("Lose.p1");
			losep2 = config.getVector("Lose.p2");
		}catch (Exception e) {}
		try {
			floorworld = config.getString("Floor.World");
			floorp1 = config.getVector("Floor.p1");
			floorp2 = config.getVector("Floor.p2");
		}catch (Exception e) {}
		
		try {
			Vector v = config.getVector("SpawnPoint");
			spawnpoint = new Location(Bukkit.getServer().getWorld(arenaworld), v.getX(), v.getY(), v.getZ());
		}catch (Exception e) {}
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
