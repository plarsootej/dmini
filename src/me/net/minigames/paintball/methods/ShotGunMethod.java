package me.net.minigames.paintball.methods;

import java.util.Random;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class ShotGunMethod {

	@SuppressWarnings("deprecation")
	public static void ShotGun(Player player) {

		Inventory pi = player.getInventory();
		if(pi.containsAtLeast(new ItemStack(Material.SNOW_BALL), 1)) {
			for (int i = 0; i < 5; i++) {
				Random random = new Random();

				Snowball arrow = player.launchProjectile(Snowball.class);
				arrow.setBounce(false);
				Vector vec_arr = arrow.getVelocity();
				arrow.setVelocity(vec_arr.add(new Vector((random.nextFloat() - 0.5) / 3, (random.nextFloat() - 0.5) / 3, (random.nextFloat() - 0.5) / 3)).multiply(4));
				
				ItemStack itemstack = new ItemStack(Material.SNOW_BALL);
				int amount = itemstack.getAmount();
				if(amount > 1) {
					itemstack.setAmount(amount-1);
				}if(amount == 1) {
					itemstack.setType(Material.AIR);
				}
				player.updateInventory();
			}

		}else {
			player.sendMessage("§aOut of ammo!");
		}
		
	}

}
