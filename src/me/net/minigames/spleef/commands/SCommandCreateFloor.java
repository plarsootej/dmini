package me.net.minigames.spleef.commands;

import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.spleef.messages.Messages;
import me.net.minigames.spleef.messages.SpleefMessages;
import me.net.minigames.spleef.methods.SCreateFloor;
import me.net.minigames.spleef.methods.SWandTool;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandCreateFloor {

	@SuppressWarnings("deprecation")
	public static void SpleefCreateFloor(CommandSender sender, String[] args) {
		
		if(SpleefMain.SpleefMain.pdata.arenanames.containsKey(args[1])) {
			SArena arena = SpleefMain.SpleefMain.pdata.getArenaByName(args[1]);

			 
			if (args.length == 2) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					String arenaname = args[1];
					if (!(SWandTool.loc1.isEmpty()) && !(SWandTool.loc2.isEmpty())) {

						int x1 = SWandTool.loc1.get("X");
						int z1 = SWandTool.loc1.get("Z");
						int y1 = SWandTool.loc1.get("Y");
						String world = SWandTool.world.get("World");

						int x2 = SWandTool.loc2.get("X");
						int z2 = SWandTool.loc2.get("Z");
						int y2 = SWandTool.loc2.get("Y");

						final Location loc1 = new Location(Bukkit.getServer().getWorld(world), x1, y1, z1);
						final Location loc2 = new Location(Bukkit.getServer().getWorld(world), x2, y2, z2);

						arena.setFloorPoints(loc1, loc2);
						arena.saveToConfig();

						SCreateFloor.CreateFloor(arenaname);

						if (SpleefMain.wand.contains(sender.getName()) || SpleefMain.wand.contains(sender)) {
							SpleefMain.wand.remove(sender.getName());
							SpleefMain.wand.remove(sender);
						}

						SWandTool.loc1.clear();
						SWandTool.loc2.clear();
						SWandTool.world.clear();

						sender.sendMessage("§aFloor Succesfully created for arena §f " + arenaname);

						final int WandToolId = ConfigHandler.MainSpleef.getInt("Wand-Tool-ID");
						if (player.getInventory().contains(WandToolId)) {
							player.getInventory().remove(WandToolId);
							player.updateInventory();
						}

					} else {
						sender.sendMessage("§cLocations are not selected! Type §f/spleef wand");
					}

				}else {
					Messages.sendMessage(sender, SpleefMessages.PlayerOnlyCmd);
				}
			} else {
				sender.sendMessage("§cCommand Ussage: §f/spleef createfloor <arenaname>");
			}
		}else {
			Messages.sendMessage(sender, SpleefMessages.ArenaDoesntExists);
		}
		 

	}

}
