package me.net.minigames.teamdeathmatch.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import me.net.minigames.teamdeathmatch.handlers.TKit;
import me.net.minigames.teamdeathmatch.handlers.TPlayerDataStore;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.teamdeathmatch.messages.TMessages;
import me.net.minigames.teamdeathmatch.messages.TeamDeathMatchMessages;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TCommandKit {
	
	private static List<String> kitinuse = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	public static void kit(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 2 && args[0].equalsIgnoreCase("kit")) {
				if(args[1].equalsIgnoreCase("list")) {
					for(TKit kit : TeamDeathMatchMain.TeamDeathMatchMain.kdata.getKits()) {
						if(kit.getInUse() == true) {
							kitinuse.add(kit.getKitName());
						}
					}
					sender.sendMessage("§aAviable Kits : §f" + kitinuse);
					sender.sendMessage("§aTo use an kit §f/tdm kit <kitname>");
					
				}
				Player player = (Player) sender;
				if(!args[1].equalsIgnoreCase("list")) {
					if(TPlayerDataStore.lobbied.contains(player.getName())) {
						if(TeamDeathMatchMain.TeamDeathMatchMain.kdata.kitnames.containsKey(args[1])) {
							TKit kit = TeamDeathMatchMain.TeamDeathMatchMain.kdata.getKitByName(args[1]);
							
							
							player.getInventory().clear();
							player.getInventory().setChestplate(new ItemStack(Material.getMaterial(kit.getChestPlate())));
							player.getInventory().setLeggings(new ItemStack(Material.getMaterial(kit.getLeggings())));
							player.getInventory().setBoots(new ItemStack(Material.getMaterial(kit.getBoots())));
							player.getInventory().setItemInHand(new ItemStack(Material.getMaterial(kit.getInHand())));
							
							for(Entry<Material, Integer> entry : TeamDeathMatchMain.TeamDeathMatchMain.kdata.items.entrySet())
							{
								player.getInventory().addItem(new ItemStack(entry.getKey(), entry.getValue()));
							}
							player.updateInventory();
							TeamDeathMatchMain.TeamDeathMatchMain.kdata.setPlayerKit(player.getName(), kit);
							
						}else {
							TMessages.sendMessage(sender, TeamDeathMatchMessages.KitDoesntExists);
						}
					}else {
						sender.sendMessage("§cYou can only choose a kit in lobby");
					}
					
				}
			}else {
				sender.sendMessage("§cCommand Ussage: §f/tdm kit <kitname|list>");
			}
		}else {
			TMessages.sendMessage(sender, TeamDeathMatchMessages.PlayerOnlyCmd);
		}
	}

}
