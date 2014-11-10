package me.net.minigames.tntrun.handlers;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.util.Vector;

public class TNTSpawnLocation {
	
	private String name;
    public TNTSpawnLocation(String name)
    {
            this.name = name;
    }
    
    public String getSpawnLocationName()
    {
            return name;
    }
    
    
    private Vector p1 = null;
    public Vector getP1()
    {
            return p1;
    }
    

    
    protected void setSpawnLocation(Location p1)
    {
            this.p1 = p1.toVector();
    }
    
    protected void saveToConfig(FileConfiguration config)
    {
            config.set("SpawnLocations."+name+".p1", p1);
    }
    protected void loadFromConfig(FileConfiguration config)
    {
            Vector p1 = config.getVector("SpawnLocations."+name+".p1", null);
            this.p1 = p1;
    }

}
