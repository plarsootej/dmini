package me.net.minigames.teamdeathmatch.commands;

import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TCommandWand {

	@SuppressWarnings("deprecation")
	public static void wand(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			final int par1 = ConfigHandler.MainTDM.getInt("Wand-Tool-ID");
			final Material wanditem = Material.getMaterial(par1);

			TeamDeathMatchMain.wand.add(player);
			player.sendMessage("§6[DS] §cSet the location with the Wooden Axe!");
			player.sendMessage("§6[DS] §aLeft click: §fSelect pos #1 §a; Right click: §fSelect pos #2");
			if(!player.getItemInHand().equals(new ItemStack(wanditem))) {
				player.setItemInHand(new ItemStack(wanditem));
				player.updateInventory();
			}
		}else {
			TMessages.sendMessage(sender, TeamDeathMatchMessages.PlayerOnlyCmd);
		}		
	}

}
