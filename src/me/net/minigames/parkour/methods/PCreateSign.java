package me.net.minigames.parkour.methods;


import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.main.ParkourMain;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.util.Vector;

public class PCreateSign {

	public static void CreateCheckpointSign(Vector v, String arenaname, String checkpoint) {
		PArena arena = ParkourMain.ParkourMain.pdata.getArenaByName(arenaname);
		String world = arena.getArenaWorld().getName();
		Location newloc = new Location(Bukkit.getServer().getWorld(world), v.getX(), v.getY()+1, v.getZ());
		Block block1 = newloc.getBlock();

		Material type = block1.getType();
		if(type == Material.AIR) {
			block1.setType(Material.SIGN_POST);
			Sign sign = (Sign)block1.getState();
			sign.setLine(0, "§6[DM]§3Parkour");
			sign.setLine(1, "§b" + arenaname);
			sign.setLine(2, "§aCheckPoint");
			sign.setLine(3, checkpoint);
			
			sign.update();
		}else {
			System.out.print("not air");
		}
		
	}
	
	

}
