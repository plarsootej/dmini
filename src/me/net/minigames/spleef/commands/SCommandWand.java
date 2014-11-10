package me.net.minigames.spleef.commands;

import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SCommandWand {
	
	@SuppressWarnings("deprecation")
	public static void WandCommand (CommandSender sender) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			final int par1 = ConfigHandler.MainSpleef.getInt("Wand-Tool-ID");
			final Material wanditem = Material.getMaterial(par1);

			SpleefMain.wand.add(player);
			player.sendMessage("�6[DM] �cSet the location with the Wooden Axe!");
			player.sendMessage("�6[DM] �aLeft click: �fSelect pos #1 �a; Right click: �fSelect pos #2");
			if(!player.getInventory().contains(new ItemStack(wanditem))) {
				player.getInventory().addItem(new ItemStack(wanditem));
				player.updateInventory();
			}
		}else {
			sender.sendMessage("�cPlayer Only Command!");
		}
	}

}
