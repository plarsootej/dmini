package me.net.minigames.tntrun.handlers;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.util.Vector;

public class TNTFloorLevel {
	
    private String name;
    public TNTFloorLevel(String name)
    {
            this.name = name;
    }
    public String getGameLevelName()
    {
            return name;
    }
    
    private Vector p1 = null;
    public Vector getP1()
    {
            return p1;
    }
    private Vector p2 = null;
    public Vector getP2()
    {
            return p2;
    }
    
    protected void setGameLocation(Location p1, Location p2)
    {
            this.p1 = p1.toVector();
            this.p2 = p2.toVector();
            fillArea(p1.getWorld());
    }
    public void fillArea(World w)
    {
    	
    	Location loc1 = p1.toLocation(w);
    	Location loc2 = p2.toLocation(w);
   	    int sandminX = Math.min(loc1.getBlockX(), loc2.getBlockX());
	    int sandminY = Math.min(loc1.getBlockY(), loc2.getBlockY());
	    int sandminZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
	    int sandmaxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
	    int sandmaxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
	    int sandmaxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
	    for(int x = sandminX; x <= sandmaxX; x++) {
	         for(int y = sandminY; y <= sandmaxY; y++) {
	             for(int z = sandminZ; z <=sandmaxZ; z++) {
	                 Block b = w.getBlockAt(x, y, z);
	                 
                             b.setType(Material.SAND);
                     
                     b = b.getRelative(BlockFace.DOWN);
                     
                             b.setType(Material.TNT);
                     
	                 
	             }
	         }
	     }

	     
            int y = p1.getBlockY();
            for (int x = p1.getBlockX(); x<p2.getBlockX(); x++)
            {
                    for (int z = p1.getBlockZ(); z<p2.getBlockZ(); z++)
                    {
                            Block b = w.getBlockAt(x, y, z);
                            if (b.getType() == Material.AIR) 
                            {
                                    b.setType(Material.SAND);
                            }
                            b = b.getRelative(BlockFace.DOWN);
                            if (b.getType() == Material.AIR) 
                            {
                                    b.setType(Material.TNT);
                            }
                    }
            }
    }

    protected void saveToConfig(FileConfiguration config)
    {
            config.set("Floors."+name+".p1", p1);
            config.set("Floors."+name+".p2", p2);
    }
    
    protected void loadFromConfig(FileConfiguration config)
    {
            Vector p1 = config.getVector("Floors."+name+".p1", null);
            Vector p2 = config.getVector("Floors."+name+".p2", null);
            this.p1 = p1;
            this.p2 = p2;
    }

}
