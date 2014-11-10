package me.net.minigames.paintball.methods;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NormalGunMethod {
	
	
	
	
	@SuppressWarnings("deprecation")
	public static void NormalGun(Player player) {
		
		
		Inventory pi = player.getInventory();
		ItemStack itemstack = new ItemStack(Material.SNOW_BALL);
		
		if(pi.containsAtLeast(new ItemStack(Material.SNOW_BALL), 1)) {
			Projectile p = player.launchProjectile(Snowball.class);
			Projectile p2 = player.launchProjectile(Snowball.class);
			p.setVelocity(player.getLocation().getDirection().multiply(4));
			p2.setVelocity(player.getLocation().getDirection().multiply(4));
			
       
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
	}

}
