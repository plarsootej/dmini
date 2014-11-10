package me.net.minigames.teamdeathmatch.methods;

import java.util.Map.Entry;

import me.net.minigames.main.MainClass;
import me.net.minigames.teamdeathmatch.handlers.TKit;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class TRestoreKit {
	 static  int runtaskid;
	 static int count = 2;
	public static void RestoreKit(final Player player, final TKit kit) {

		 
         runtaskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.main, new Runnable() 
         {
                 
				@SuppressWarnings("deprecation")
				public void run()
                 {
               	 if(count < 0) {
            		 stopCountDown();
            	 }
                	 if (count == 0)
                     {
                		 
                  		for(Entry<Material, Integer> entry : TeamDeathMatchMain.TeamDeathMatchMain.kdata.items.entrySet())
             			{
             				player.getInventory().addItem(new ItemStack(entry.getKey(), entry.getValue()));
             			}
             			player.updateInventory();
             			
             			String team = TeamDeathMatchMain.TeamDeathMatchMain.pdata.getPlayerTeam(player.getName());
             			if(team.equalsIgnoreCase("blue")) {
             				ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
             				LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
             				helmMeta.setColor(Color.BLUE);
             				helm.setItemMeta(helmMeta);
             				player.getInventory().setHelmet(helm);
             			}
             			if(team.equalsIgnoreCase("red")) {
             				ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
             				LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
             				helmMeta.setColor(Color.RED);
             				helm.setItemMeta(helmMeta);
             				player.getInventory().setHelmet(helm);
             			}
             			
             			player.getInventory().setChestplate(new ItemStack(Material.getMaterial(kit.getChestPlate())));
             			player.getInventory().setLeggings(new ItemStack(Material.getMaterial(kit.getLeggings())));
             			player.getInventory().setBoots(new ItemStack(Material.getMaterial(kit.getBoots())));
             			player.getInventory().setItemInHand(new ItemStack(Material.getMaterial(kit.getInHand())));
             			
             			player.updateInventory();
             			
             			stopCountDown();
                  	}

                	 count --;
                 }


         }, 0, 20);
		
	}
	
	private static void stopCountDown() {
		
		Bukkit.getScheduler().cancelTask(runtaskid);
		count = 2;
		
	}

}
