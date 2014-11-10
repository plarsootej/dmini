package me.net.minigames.parkour.handlers;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.util.Vector;

public class PCheckPoint {
	
	private String name;
    public PCheckPoint(String name)
    {
            this.name = name;
    }
    
    public String getCheckPointName()
    {
            return name;
    }
    
    
    private Vector p1 = null;
    public Vector getP1()
    {
            return p1;
    }
    

    
    protected void setCheckPoint(Location p1)
    {
            this.p1 = p1.toVector();
    }
    
    protected void saveToConfig(FileConfiguration config)
    {
            config.set("CheckPoints."+name+".p1", p1);
    }
    protected void loadFromConfig(FileConfiguration config)
    {
            Vector p1 = config.getVector("CheckPoints."+name+".p1", null);
            this.p1 = p1;
    }

}
