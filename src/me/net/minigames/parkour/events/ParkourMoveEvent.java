package me.net.minigames.parkour.events;

import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.parkour.handlers.PArena;
import me.net.minigames.parkour.handlers.PPlayerHandler;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.methods.PlayerFell;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ParkourMoveEvent {
	
	

	@SuppressWarnings("deprecation")
	public static void MoveEvent(PlayerMoveEvent event, Player player) {
		Location loc = player.getLocation();
		Block block = loc.getBlock();
		final Material finishblock = Material.getMaterial(ConfigHandler.ParkourMain.getInt("Finish-Block"));
		final Material finishblock2 = Material.getMaterial(ConfigHandler.ParkourMain.getInt("Finish-Block2"));
		final Material fallblock = Material.getMaterial(ConfigHandler.ParkourMain.getInt("Fall-Block"));
		final Material speedblock = Material.getMaterial(ConfigHandler.ParkourMain.getInt("Speed-Block"));
		final Material slowblock = Material.getMaterial(ConfigHandler.ParkourMain.getInt("Slow-Block"));
		final Material jumpblock = Material.getMaterial(ConfigHandler.ParkourMain.getInt("Jump-Block"));
		
		//Finish block
		if(block.getType() == finishblock || block.getType() == finishblock2) {
			PArena arena = ParkourMain.ParkourMain.pdata.getPlayerArena(player.getName());
			PPlayerHandler.EndParkour(player, arena);
		}
		//fall block
		if(block.getType() == fallblock) {
			PlayerFell.CheckpointPlayer(player);
		}
		//speedblock
		if(block.getType() == speedblock) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 140, 2));
		}
		//slowblock
		if(block.getType() == slowblock) {
			if(player.hasPotionEffect(PotionEffectType.SPEED)) {
				player.removePotionEffect(PotionEffectType.SPEED);
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 140, 2));
			}else {
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 140, 2));
			}
		}
		//jump block
		if(block.getType() == jumpblock) {
			player.setVelocity(event.getPlayer().getVelocity().add(new Vector(0,0.15,0)));
		}
		
		
		
	}

}
