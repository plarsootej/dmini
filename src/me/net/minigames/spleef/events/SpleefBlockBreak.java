package me.net.minigames.spleef.events;

import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class SpleefBlockBreak {

	@SuppressWarnings("deprecation")
	public static void BlockBreakEvent(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(SpleefMain.SpleefMain.pdata.plingame.containsKey(player.getName())) {
			Block block = event.getBlock();
			if(!(block.getType() == Material.getMaterial(ConfigHandler.MainSpleef.getInt("Floor-Block-Type")))) {
				event.setCancelled(true);

			}
		}
		
	}

}
