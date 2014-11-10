package me.net.minigames.paintball.handlers;

import java.io.File;
import java.io.IOException;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.PaintballMain;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Vector;

public class PAArenas {
	
	public MainClass plugin;
	protected PaintballMain PaintballMain;
	public PAPlayerHandler arenaph;
	public PACountdown PACountDown;

	public PAArenas(String name, MainClass plugin, PaintballMain PaintballMain) {
		arenaname = name;
		this.plugin = plugin;
		this.PaintballMain = PaintballMain;
		arenaph = new PAPlayerHandler(plugin,this);
		PACountDown = new PACountdown(PaintballMain, this);
		arenafile = new File(plugin.getDataFolder()+File.separator+"/Paintball/Arenas"+File.separator+arenaname+".yml");
		PaintballMain.pdata.putArenaInHashMap(this);
	}
	
	 private boolean enabled = true;
     private boolean starting = false;
     private boolean running = false;
     private boolean counting = false;
     
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
            if (redspawn == null) {return "Red Spawn point not set";}
            if(bluespawn == null) {return "Blue Spawn point not set";}
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
    
    //red spawn location
    private Location redspawn = null;
    public Location getRedSpawn() {
    	return redspawn;
    }
    
    public boolean setRedSpawn(Location loc) {
    	redspawn = loc;
    	return true;
    }
    
    //blue spawn location
    private Location bluespawn = null;
    public Location getBlueSpawn() {
    	return bluespawn;
    }
    
    public boolean setBlueSpawn(Location loc) {
    	bluespawn = loc;
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
		arenaconfig.set("CountDown", count);
		
		//saving the arena bounds
		try {
            arenaconfig.set("ArenaBorders.World", arenaworld);
            arenaconfig.set("ArenaBorders.p1", arenap1);
            arenaconfig.set("ArenaBorders.p2", arenap2);
		} catch (Exception e) {}
		
        //saving the lobby point
        try {
            arenaconfig.set("RedSpawnPoint", redspawn.toVector());
        } catch (Exception e) {}
        
        try {
            arenaconfig.set("BlueSpawnPoint", bluespawn.toVector());
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
			Vector v = config.getVector("LobbyPoint");
			lobbypoint = new Location(Bukkit.getServer().getWorld(arenaworld), v.getX(), v.getY(), v.getZ());
		}catch (Exception e) {}
		
		try {
			Vector v = config.getVector("RedSpawnPoint");
			redspawn = new Location(Bukkit.getServer().getWorld(arenaworld), v.getX(), v.getY(), v.getZ());
		}catch (Exception e) {}
		try {
			Vector v = config.getVector("BlueSpawnPoint");
			bluespawn = new Location(Bukkit.getServer().getWorld(arenaworld), v.getX(), v.getY(), v.getZ());
		}catch (Exception e) {}
		
		try {
			Vector v = config.getVector("SpectatePoint");
			spectatepoint = new Location(Bukkit.getServer().getWorld(arenaworld), v.getX(), v.getY(), v.getZ());
		}catch (Exception e) {}
		enabled = config.getBoolean("Enabled");
	}
	
}
