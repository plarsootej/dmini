package me.net.minigames.tntrun.commands;

import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;
import me.net.minigames.tntrun.methods.TNTCreateLose;
import me.net.minigames.tntrun.methods.TNTWandTool;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTCommandCreateLose {
	
	@SuppressWarnings("deprecation")
	public static void CreateLose(CommandSender sender, String[] args) {
		if(args.length == 2  && args[0].equalsIgnoreCase("createlose")) {
			if(sender instanceof Player) {
				final String arenaname = args[1];
				if(TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
					if(!(TNTWandTool.loc1.isEmpty()) && !(TNTWandTool.loc2.isEmpty())) {
						
						int x1 = TNTWandTool.loc1.get("X");
						int z1 = TNTWandTool.loc1.get("Z");
						int y1 = TNTWandTool.loc1.get("Y");
						String world = TNTWandTool.world.get("World");
						
						int x2 = TNTWandTool.loc2.get("X");
						int z2 = TNTWandTool.loc2.get("Z");
						int y2 = TNTWandTool.loc2.get("Y");
						
						Location loc1 = new Location(Bukkit.getWorld(world), x1, y1, z1);
						Location loc2 = new Location(Bukkit.getWorld(world), x2, y2, z2);
						
						TNTArena arena = TNTRunMain.TNTRunMain.pdata.getArenaByName(arenaname);
						arena.setLosePoints(loc1, loc2);
						arena.saveToConfig();
						
						
						TNTCreateLose.CreateLoseFloor(arena, arenaname);
						
						if(TNTRunMain.wand.contains(sender.getName()) || TNTRunMain.wand.contains(sender)) {
							TNTRunMain.wand.remove(sender.getName());
							TNTRunMain.wand.remove(sender);
						}
						
						TNTWandTool.loc1.clear();
						TNTWandTool.loc2.clear();
						TNTWandTool.world.clear();
						
						sender.sendMessage("§aLose Succesfully created for arena: §f" + arenaname);
						
						final int WandToolId = ConfigHandler.TNTMainConfig.getInt("Wand-Tool-ID");
						Player player = (Player) sender;
						if(player.getInventory().contains(WandToolId)) {
							player.getInventory().remove(WandToolId);
							player.updateInventory();
						}
						
					}else {
						TNTMessages.sendMessage(sender, TNTRunMessages.locnotselected);
					}
				}else {
					TNTMessages.sendMessage(sender, TNTRunMessages.ArenaDoesntExists);
				}
				
				
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.PlayerOnlyCmd);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt createlose <arenaname>");
		}
		
		
	}

}
