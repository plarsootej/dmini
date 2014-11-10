package me.net.minigames.tntrun.methods;

import java.util.HashMap;

import me.net.minigames.main.handlers.ConfigHandler;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class TNTWandTool {
	
	public static HashMap<String, Integer> loc1 = new HashMap<String, Integer>();
	public static HashMap<String, Integer> loc2 = new HashMap<String, Integer>();
	public static HashMap<String, String> world = new HashMap<String, String>();
	
	private static int wandtoolid = ConfigHandler.TNTMainConfig.getInt("Wand-Tool-ID");
	
	@SuppressWarnings("deprecation")
	public static void WandTool(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		
		final ItemStack inhand = player.getItemInHand();
		
		
		if(inhand.getType() == Material.getMaterial(wandtoolid)) {
			if(event.getAction() == Action.LEFT_CLICK_BLOCK) {
				
				Block block1 = event.getClickedBlock();
				Location loc = block1.getLocation();
				
				int x1 = loc.getBlockX();
				int z1 = loc.getBlockZ();
				int y1 = loc.getBlockY();
				
				String world1 = loc.getWorld().getName();
				
				loc1.put("X", x1);
				loc1.put("Y", y1);
				loc1.put("Z", z1);
				world.put("World", world1);
				
				if(loc2.isEmpty()) {
					player.sendMessage("§6[DM] §cPos #1 Selected §fRight click: Select pos #2");
				}else {
					player.sendMessage("§6[DM] §cPos #1 and #2 Selected!");
				}
				
				
			}if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				
				Block block2 = event.getClickedBlock();
				Location loc = block2.getLocation();
				
				int x2 = loc.getBlockX();
				int z2 = loc.getBlockZ();
				int y2 = loc.getBlockY();
				
				loc2.put("X", x2);
				loc2.put("Y", y2);
				loc2.put("Z", z2);
				
				if(loc1.isEmpty()) {
					player.sendMessage("§6[DM] §cPos #2 Selected §fLeft cick: Select pos #1");
				}else {
					player.sendMessage("§6[DM] §cPos #1 and #2 Selected! Type §f/tnt setup §c For more information");
				}
				
			}
			
		}
	}

}
