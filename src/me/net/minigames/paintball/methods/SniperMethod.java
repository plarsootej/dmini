package me.net.minigames.paintball.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SniperMethod {
	
	static boolean cancelInteract; //true
	static boolean useOtherButton; //true
	public static HashMap<String, Integer> playersZoomedIn = new HashMap<String, Integer>();
	public static List<Integer> zoomLevels = new ArrayList<Integer>(); //[3; 8; 10; 12]
	
	@SuppressWarnings("deprecation")
	public static void Sniper (Player player, PlayerInteractEvent e) {
		
    
		Action zoomInAirAction =  Action.RIGHT_CLICK_AIR;
		Action zoomInBlockAction = Action.RIGHT_CLICK_BLOCK;
		Action zoomOutAirAction =  Action.LEFT_CLICK_AIR;
		Action zoomOutBlockAction =  Action.LEFT_CLICK_BLOCK;
		
		Inventory pi = player.getInventory();
		

			//Replaced the big ifs we had, since the setZoomLevel already handled out of bounds cases to match the default behaviour :)
			if (e.getAction() == zoomInAirAction || e.getAction() == zoomInBlockAction) {
				//Zoom in!
				setZoomLevel(e.getPlayer(), getClicks(e.getPlayer()) + 1);
				if(cancelInteract) e.setCancelled(true);
			} else if((e.getAction() == zoomOutAirAction || e.getAction() == zoomOutBlockAction)) {
				//Zoom out!
				setZoomLevel(e.getPlayer(), 0);
				
				if(pi.containsAtLeast(new ItemStack(Material.SNOW_BALL), 1)) {
					Projectile p = player.launchProjectile(Snowball.class);
					Projectile p2 = player.launchProjectile(Snowball.class);
					p.setVelocity(player.getLocation().getDirection().multiply(4));
					p2.setVelocity(player.getLocation().getDirection().multiply(4));
					
					ItemStack itemstack = new ItemStack(Material.SNOW_BALL);
					int amount = itemstack.getAmount();
					if(amount > 1) {
						itemstack.setAmount(amount-1);
					}if(amount == 1) {
						itemstack.setType(Material.AIR);
					}
					player.updateInventory();
					
				}else {
					player.sendMessage("§aOut Of ammo");
				}
				
				
				
				if(cancelInteract) e.setCancelled(true);
			}
			

		
		
	}
	static Integer getClicks(Player p) {
		if(playersZoomedIn.containsKey(p.getName())) return playersZoomedIn.get(p.getName());
		return 0;
	}
	static void setZoomLevel(Player p, Integer clicks) {
		setZoomLevel(p, clicks, true);
	}
	static void setZoomLevel(Player p, Integer clicks, boolean b) {

		

		if(clicks < 0) clicks = zoomLevels.size();

		p.removePotionEffect(PotionEffectType.SLOW);
		if(clicks == 0 || clicks > zoomLevels.size()) {
			clicks = 0;
			if(playersZoomedIn.containsKey(p.getName())) playersZoomedIn.remove(p.getName());
		} else {
			if(zoomLevels.get(clicks - 1) != 0) p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 24000, zoomLevels.get(clicks - 1)));
			playersZoomedIn.put(p.getName(), clicks);
		}

	}
	
}
